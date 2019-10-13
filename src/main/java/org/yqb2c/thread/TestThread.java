package org.yqb2c.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {
    //volatile
    //1.保证内存可见性
    //2.防止指令重排  在保证代码结果不变的情况下，jvm虚拟机会对代码顺序进行微调

    //线程内存会存一份，主内存的变量副本，当A线程正在使用这个副本变量时，线程B更改了
    //这个变量副本。加了volatile关键字后，线程执行引擎会强制让所有正在使用这个变量的
    //线程去更新这个变量副本


    public static void main(String[] args) {

        //new ThreadPoolExecutor();
        //1.corePoolSize                //线程池中的线程数量
        //2.maximumPoolSize             //线程池中最大的线程数量
        //3.keepAliveTime               //
        //4.TimeUnit
        //5.workQueue


        //Executors.newFixedThreadPool()
        //1.Executors.newCachedThreadPool()
        //Integer.MAX_VALUE 不限量的创建

        //2.Executors.newFixedThreadPool()
        //创建固定大小的线程池

        //3.Executors.newSingleThreadExecutor()
        //创建单个线程池

        //4.创建定时调度的线程池
        //Executors.newScheduledThreadPool()

        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        if (t.isDaemon()) {
                            t.setDaemon(false);
                        }
                        t.setName("order-thread");
                        return t;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("拒绝策略");
                    }
                }
        );

        for(int i = 0; i < 30; i++){
            pool.submit(() -> {
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+"---------线程"+t.getId());
            });
        }

        pool.shutdown();
    }
}
