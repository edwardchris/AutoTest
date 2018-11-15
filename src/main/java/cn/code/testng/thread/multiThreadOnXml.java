package cn.code.testng.thread;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 16:16
 * @description:
 */
public class multiThreadOnXml {

    @Test
    public void test1(){
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }


}
