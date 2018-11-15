package cn.code.testng.httpclient;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import java.io.IOException;


/**
 * @author: huangxiang
 * @create: 2018/5/21 14:51
 * @description:
 */
public class MyHttpClient {

    @Test
    public void test(){
        //用户存放结果
        String result;
        HttpGet get =  new HttpGet("http://www.baidu.com");
        //用来执行get方法
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(get);
            result = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
