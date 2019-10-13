package org.yqb2c.pattern.proxy.dynamics;

import com.alibaba.fastjson.JSONObject;
import org.yqb2c.pattern.proxy.UserService;
import org.yqb2c.pattern.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Client2 {

    public static void main(String[] args) {




        //1.创建被代理的对象
        UserServiceImpl userService = new UserServiceImpl();

        //2.获取classLoader
        ClassLoader classLoader = userService.getClass().getClassLoader();

        //3.获取所有接口的Class
        Class[] interfaces = userService.getClass().getInterfaces();
        System.out.println(JSONObject.toJSONString(interfaces));

        InvocationHandler logHandler = new LogHandler(userService);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader,interfaces,logHandler);

        proxy.select();
        proxy.update();


    }


    //volatile
    //1.多线程间可见性
    //2.阻止指令重排序
}
