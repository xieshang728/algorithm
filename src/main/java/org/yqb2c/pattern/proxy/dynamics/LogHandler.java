package org.yqb2c.pattern.proxy.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(target,args);
        doAfter();
        return result;
    }


    private void doBefore(){
        System.out.println(String.format("log start time [%s] ",new Date()));
    }

    private void doAfter(){
        System.out.println(String.format("log end time [%s] ",new Date()));
    }
}
