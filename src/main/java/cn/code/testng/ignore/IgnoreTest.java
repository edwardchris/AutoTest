package cn.code.testng.ignore;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:24
 * @description:
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2");
    }
}
