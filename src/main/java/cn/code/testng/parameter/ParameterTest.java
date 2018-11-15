package cn.code.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/15 11:37
 * @description:
 */
public class ParameterTest {

    @Test
    @Parameters({"name", "age"})
    public void testCase(String name, int age) {

        System.out.println("name= " + name + "; age=" + age);

    }
}
