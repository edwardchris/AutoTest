package cn.code.testng.dependency;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 11:39
 * @description:
 */
@Test(groups = "stu")
public class DependOnGroups2 {

    public void stu3() {

        System.out.println("stu3");

    }

    public void stu4() {
        System.out.println("stu4");
    }
}
