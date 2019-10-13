package org.yqb2c.pattern.proxy.stat;

import org.yqb2c.pattern.proxy.UserService;
import org.yqb2c.pattern.proxy.UserServiceImpl;

public class Client1 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.select();
        proxy.update();

    }
}
