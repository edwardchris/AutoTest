package cn.code.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:41
 * @description:
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("teacher1");
    }

    public void teacher2(){
        System.out.println("teacher2");
    }

}
