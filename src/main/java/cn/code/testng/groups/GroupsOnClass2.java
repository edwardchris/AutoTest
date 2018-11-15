package cn.code.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:41
 * @description:
 */
@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu3() {

        System.out.println("stu3");

    }

    public void stu4() {
        System.out.println("stu4");
    }
}
