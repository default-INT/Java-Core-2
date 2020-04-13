package by.gstu.models;

import by.gstu.models.entities.Account;

public class AccountContext {
    private static AccountContext instance;
    private Account account;

    private  AccountContext() {

    }

    public static AccountContext getInstance() {
        if (instance == null) {
            instance = new AccountContext();
        }
        return instance;
    }
}
