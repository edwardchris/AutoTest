package cn.code.testng.timeout;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/17 09:28
 * @description:
 */
public class TimeOutTest {

    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
