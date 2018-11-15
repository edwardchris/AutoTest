package cn.code.testng.thread;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 15:03
 * @description:
 */
@SuppressWarnings("ALL")
public class multiThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 10)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
