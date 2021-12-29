package ru.job4j.banc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        Optional<User> opt = findByPassport(passport);
        if (opt.isPresent() && !users.get(opt.get()).contains(account)) {
            users.get(opt.get()).add(account);
        }
    }

    /**
     * Метод осуществляет поиск пользователя в базе банка по паспортным данным.
     * Если пользователь с паспортными данными {@code passport} существует в системе,
     * то метод возвращает данного пользователя {@code user}, который завернут в Optional.
     * @param passport - паспортные данные клиента, которые представлены в виде строки.
     * @return возвращается экземпляр класса Optional, значение поля {@code passport} которого
     * соответствует передаваемому параметру passport
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
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
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> opt = findByPassport(passport);
        return opt.flatMap(user -> users.get(user)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}