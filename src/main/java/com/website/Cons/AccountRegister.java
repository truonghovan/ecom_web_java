package com.website.Cons;


import com.website.models.UserEntity;

public class AccountRegister {

    public static UserEntity accountRegister;

    public static UserEntity getAccountRegister() {
        return accountRegister;
    }

    public static void setAccountRegister(UserEntity accountRegister) {
        AccountRegister.accountRegister = accountRegister;
    }
    public static void reset()
    {
        UserEntity acc = new UserEntity();
        accountRegister = acc;
    }
}
