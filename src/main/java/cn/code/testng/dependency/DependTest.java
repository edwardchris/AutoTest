package cn.code.testng.dependency;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 11:24
 * @description:
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2");
    }
}
