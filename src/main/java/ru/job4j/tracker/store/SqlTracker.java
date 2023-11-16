package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String query = "insert into items(name, creates) values(?, ?)";
        try (PreparedStatement preparedStatement = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());

            Timestamp timestamp = Timestamp.valueOf(item.getCreated());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    item.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        String query = "update items set name = ?, created = ? where id = ?";
        boolean result = false;
        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            preparedStatement.setString(1, item.getName());

            Timestamp timestamp = Timestamp.valueOf(item.getCreated());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setInt(3, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            result = rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        String query = "delete from items where id = ?";

        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Item with id = " + id + " was deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String query = "select * from items";
        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = getItem(resultSet);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String query = "select * from items where name = ?";
        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            preparedStatement.setString(1, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = getItem(resultSet);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        String query = "select * from items where id = ?";
        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getItem(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Item getItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getInt("id"));
        item.setName(resultSet.getString("name"));
        item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        return item;
    }
}
