package cn.code.testng.extentreport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/17 09:55
 * @description:
 */
public class TestMethodDemo {

    @Test
    public void testFail(){
        Assert.assertEquals(1,2);
    }


    @Test
    public void testSuccess1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void testSuccess2(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("生成日志");
        throw new RuntimeException("生成异常");
    }
}


