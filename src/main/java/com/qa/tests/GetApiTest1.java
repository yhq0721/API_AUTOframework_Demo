package com.qa.tests;

import java.io.IOException;
import com.qa.restclient.RestClient4;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;
public class GetApiTest1 extends TestBase {

    TestBase testBase;
    String host;
    String url;
    RestClient4 restClient;
    CloseableHttpResponse closeableHttpResponse;

    final static Logger Log = Logger.getLogger(GetApiTest1.class);

    @BeforeClass
    public void setUp() {

        testBase = new TestBase();
        //Log.info("测试服务器地址为："+ host.toString());
        host = prop.getProperty("HOST");
        //Log.info("当前测试接口的完整地址为："+url.toString());
        url = host + "/api/users?page=2";

    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        Log.info("开始执行用例...");
        restClient = new RestClient4();
        closeableHttpResponse = restClient.get(url);

        //断言状态码是不是200
        Log.info("测试响应状态码是否是200");
        int statusCode = restClient.getStatusCode(closeableHttpResponse);
        Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200, "response status code is not 200");

        JSONObject responseJson = restClient.getResponseJson(closeableHttpResponse);
        //System.out.println("respon json from API-->" + responseJson);

        //json内容解析
        String s = TestUtil.getValueByJPath(responseJson,"data[0]/first_name");
        Log.info("执行JSON解析，解析的内容是 " + s);
        //System.out.println(s);
        Log.info("接口内容响应断言");
        Assert.assertEquals(s, "Eve","first name is not Eve");
        Log.info("用例执行结束...");
    }
}

