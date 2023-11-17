package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenReplaceItemSuccess() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item 1");
        int itemId = tracker.add(item).getId();
        Item newVersionItem = new Item("Updated Item 1");
        tracker.replace(itemId, newVersionItem);
        Item replacedItem = tracker.findById(itemId);
        assertThat(replacedItem.getName()).isEqualTo(newVersionItem.getName());
    }

    @Test
    void whenDeleteExistingItemThenSuccess() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item 1");
        int itemId = item.getId();
        tracker.add(item);
        tracker.delete(itemId);
        assertThat(tracker.findById(itemId)).isNull();
    }

    @Test
    void whenDeleteNonExistingItemThenNoChange() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item 1");
        tracker.add(item);
        int countBefore = getCountOfItemsInDatabase();
        int notExistingId = Integer.MAX_VALUE;
        tracker.delete(notExistingId);
        int countAfter = getCountOfItemsInDatabase();
        assertThat(countBefore).isEqualTo(countAfter);
    }

    private int getCountOfItemsInDatabase() throws SQLException {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from items")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        }
        return count;
    }

    @Test
    void whenFindAllThenReturnAllItems() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Test item 1");
        tracker.add(item1);
        Item item2 = new Item("Test item 2");
        tracker.add(item2);
        Item item3 = new Item("Test item 3");
        tracker.add(item3);
        Item item4 = new Item("Test item 4");
        tracker.add(item4);

        List<Item> itemList = tracker.findAll();

        assertThat(itemList).containsExactlyInAnyOrder(item1, item2, item3, item4);
    }

    @Test
    void whenFindAllThenShouldNotReturnIncompleteItems() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Test item 1");
        tracker.add(item1);
        Item item2 = new Item("Test item 2");
        tracker.add(item2);
        Item item3 = new Item("Test item 3");
        tracker.add(item3);
        Item item4 = new Item("Test item 4");
        tracker.add(item4);

        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from items where id = ?")) {
            preparedStatement.setInt(1, item4.getId());
            preparedStatement.executeUpdate();
        }

        List<Item> itemList = tracker.findAll();

        assertThat(itemList).doesNotContain(item4);
    }

    @Test
    void whenFindByNameThenReturnMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Test item 1");
        tracker.add(item1);
        Item item2 = new Item("Test item 1");
        tracker.add(item2);
        Item item3 = new Item("Test item 1");
        tracker.add(item3);
        Item item4 = new Item("Test item 4");
        tracker.add(item4);

        List<Item> itemList = tracker.findByName(item1.getName());

        assertThat(itemList).containsExactlyInAnyOrder(item1, item2, item3);
    }

    @Test
    void whenFindByNameWithNonExistingNameThenReturnEmptyList() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Test item 1");
        tracker.add(item1);
        Item item2 = new Item("Test item 1");
        tracker.add(item2);
        Item item3 = new Item("Test item 1");
        tracker.add(item3);
        Item item4 = new Item("Test item 4");
        tracker.add(item4);
        String notExistingName = "Not existing name";

        List<Item> itemList = tracker.findByName(notExistingName);

        assertThat(itemList).isEmpty();
    }

    @Test
    void whenFindByIdThenReturnItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item expectedItem = new Item("Test item 1");

        expectedItem = tracker.add(expectedItem);
        int itemId = expectedItem.getId();

        Item foundItem = tracker.findById(itemId);

        assertThat(foundItem.getName()).isEqualTo(expectedItem.getName());

        assertThat(foundItem.getCreated().truncatedTo(ChronoUnit.MILLIS)).isEqualTo(expectedItem.getCreated().truncatedTo(ChronoUnit.MILLIS));
    }

    @Test
    void whenFindByIdWithNonExistingIdThenReturnNull() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item expectedItem = new Item("Test item 1");

        tracker.add(expectedItem);
        int itemId = expectedItem.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from items where id = ?")) {
            preparedStatement.setInt(1, itemId);
            preparedStatement.executeUpdate();
        }

        Item foundItem = tracker.findById(itemId);

        assertThat(foundItem).isNull();
    }
}