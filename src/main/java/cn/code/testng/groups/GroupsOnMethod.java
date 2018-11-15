package cn.code.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:31
 * @description:
 */
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端组1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端组2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端组1");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端组2");

    }

    @BeforeGroups("server")
    public void beforeGroups(){
        System.out.println("beforeGroups");
    }

    @AfterGroups("server")
    public  void afterGroups(){
        System.out.println("afterGroups");
    }
}
