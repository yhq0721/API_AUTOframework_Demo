package com.qa.tests;

import java.io.IOException;
import com.qa.restclient.RestClient3;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.base.TestBase;


public class DeleteApiTest extends TestBase {
    TestBase testBase;
    String host;
    String url;
    RestClient3 restClient;
    CloseableHttpResponse closeableHttpResponse;


    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users/2";  //直接在这个网站可以找到delete的api

    }

    @Test
    public void deleteApiTest() throws ClientProtocolException, IOException {
        restClient = new RestClient3();
        closeableHttpResponse = restClient.delete(url);

        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 204,"status code is not 204");
    }
}