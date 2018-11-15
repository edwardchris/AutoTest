package cn.code.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author: huangxiang
 * @create: 2018/5/16 14:00
 * @description:
 */
public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + "; age=" + age);

    }

    @DataProvider(name = "data")
    public Object[][] provideData() {
        Object[][] objects = new Object[][]{
                {"zhangsan", 10},
                {"wangwu", 20},
                {"lisi", 30}
        };
        return objects;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1 name=" + name + "; age=" + age);

    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2 name=" + name + "; age=" + age);

    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] objects = null;
        String methodName1 = "test1";
        String methodName2 = "test2";
        if (methodName1.equals(method.getName())) {
            objects = new Object[][]{
                    {"zhangsan", 10},
                    {"wangwu", 20},
                    {"lisi", 30}
            };
        } else if (methodName2.equals(method.getName())) {
            objects = new Object[][]{
                    {"test", 10},
                    {"admin", 20},
                    {"demo", 30}
            };
        }
        return objects;
    }
}
