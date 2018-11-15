package cn.code.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:40
 * @description:
 */
@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("stu1");
    }

    public void stu2(){
        System.out.println("stu2");
    }
}
