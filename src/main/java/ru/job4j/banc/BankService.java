package ru.job4j.banc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает функциональность банковской системы.
 * @author ALEKSANDR PHILIMONOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов {@code User} и их счетов {@code List<Account>} осуществляется
     * в структуре типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в базу банка.
     * Добавленному пользователю соответствует пустой список для хранения счетов.
     * @param user - объект класса User, который необходимо добавить в базу банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый аккаунт пользователя в базу банка.
     * Если пользователь с паспортными данными {@code passport} существует в системе,
     * и у него отсутствует счет {@code account}, то пользователю добавляется новый счет.
     * @param passport - паспортные данные клиента, которые представлены в виде строки.
     * @param account - экземпляр класса Account.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод осуществляет поиск пользователя в базе банка по паспортным данным.
     * Если пользователь с паспортными данными {@code passport} существует в системе,
     * то метод возвращает данного пользователя {@code user}.
     * @param passport - паспортные данные клиента, которые представлены в виде строки.
     * @return возвращается экземпляр класса User, значение поля {@code passport} которого
     * соответствует передаваемому параметру passport
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск аккаунта клиента в базе банка по паспортным данным и реквизитам
     * аккаунта.
     * Если пользователь с паспортными данными {@code passport} существует в системе,
     * то метод обрабатывает аккаунты данного пользователя.
     * Если у пользователя найден аккаунт с реквизитами, которые передаются в параметрах, то
     * метод возвратит данный аккаунт.
     * @param passport - паспортные данные клиента, которые представлены в виде строки.
     * @param requisite - реквизиты аккаунта клиента, которые представлены в виде строки.
     * @return возвращается экземпляр класса Account, значение поля {@code passport} которого
     * соответствует передаваемому параметру passport
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег между различными клиентами по паспортным данным
     * и реквизитам.
     * По реквизитам находятся клиенты, между которыми нужно осуществить перевод.
     * Проверяется наличие аккаунтов у клиентов и достаточное количество денег у
     * клиента, со счета которого будет произведен перевод.
     * @param srcPassport - паспортные данные клиента, у которого списываются деньги со счета.
     * @param srcRequisite - реквизиты счета клиента, откуда списываются деньги.
     * @param destPassport - паспортные данные клиента, которому переводятся деньги.
     * @param destRequisite - реквизиты счета клиента, куда зачисляются деньги.
     * @param amount - сумма перевода.
     * @return возвращается true в случае, если клиенты существуют и есть возможность
     * снять денежные средства у клиента, со счета которого осуществляется перевод.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        double srcBalance = srcAccount.getBalance();
        if (srcAccount != null && destAccount != null && srcBalance >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}