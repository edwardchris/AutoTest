package cn.code.testng.dependency;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 11:39
 * @description:
 */
@Test(groups = "stu")
public class DependOnGroups1 {

    public void stu1(){
        System.out.println("stu1");
    }

    public void stu2(){
        System.out.println("stu2");
    }
}
