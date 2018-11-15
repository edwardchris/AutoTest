package cn.code.testng.httpclient;

import com.sun.tools.corba.se.idl.StringEntry;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: huangxiang
 * @create: 2018/5/22 11:21
 * @description:
 */
public class MyCookiesForPost {

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
    public void testPostCookies() throws IOException {
        String uri = bundle.getString("postWithCookies.url");
        String testUrl = this.url + uri;
        //声明client、post对象
        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "demo");
        param.put("age", "18");
        //设置请求头信息
        post.setHeader("content-type", "application/json");
        //讲参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);
        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //获取到返回值
        String success = (String) resultJson.get("demo");
        String status = (String) resultJson.get("status");
        //具体判断返回值是否符合预期
        Assert.assertEquals("success", success);
        Assert.assertEquals("1",status);
    }


}
