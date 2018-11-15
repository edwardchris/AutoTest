package cn.code.testng.dependency;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 11:39
 * @description:
 */
@Test(dependsOnGroups = "stu")
public class DependOnGroups3 {

    public void teacher1(){
        System.out.println("teacher1");
    }

    public void teacher2(){
        System.out.println("teacher2");
    }
}
