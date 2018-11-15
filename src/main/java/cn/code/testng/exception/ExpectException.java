package cn.code.testng.exception;

import org.testng.annotations.Test;

/**
 * @author: huangxiang
 * @create: 2018/5/16 10:55
 * @description:
 */
public class ExpectException {


    @Test(expectedExceptions=RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("runTimeExceptionSuccess");
        throw new RuntimeException();
    }
}
