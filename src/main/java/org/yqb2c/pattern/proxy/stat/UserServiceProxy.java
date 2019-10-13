package org.yqb2c.pattern.proxy.stat;

import org.yqb2c.pattern.proxy.UserService;

import java.util.Date;

public class UserServiceProxy {
    private UserService target;


    public UserServiceProxy(UserService userService){
        this.target = userService;
    }

    public void select(){
        doBefore();
        target.select();
        doAfter();
    }

    public void update(){
        doBefore();
        target.update();
        doAfter();
    }

    private void doBefore(){
        System.out.println(String.format("log start time [%s] ",new Date()));
    }

    private void doAfter(){
        System.out.println(String.format("log end time [%s] ",new Date()));
    }
}
