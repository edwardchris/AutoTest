package cn.code.testng.httpclient;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: huangxiang
 * @create: 2018/5/21 15:55
 * @description:
 */
public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    /**
     * 用来存放cookies信息
     */
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() {

        String result;
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;
        HttpGet get = new HttpGet(testurl);
        //用来执行get方法
        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies key:" + key + "; cookies value:" + value);
        }


    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() {
        String uri = bundle.getString("getWithCookies.uri");
        String testUrl = this.url + uri;
        int successCode = 200;
        String result;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);

        try {
            HttpResponse response = client.execute(get);
            //获取响应的状态码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("响应状态码:" + statusCode);
            if (statusCode == successCode) {
                System.out.println("响应成功");
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(result);
            } else {
                System.out.println("响应失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
