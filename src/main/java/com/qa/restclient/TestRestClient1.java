package com.qa.restclient;

import com.qa.base.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestRestClient1 extends TestBase{
        TestBase testBase;
        String host;
        String url;
        RestClient1 restClient;

        @BeforeClass
        public void setUp() {
            testBase = new TestBase();
            host = prop.getProperty("HOST");
            url = host + "/api/users?page=2";

        }

        @Test
        public void getAPITest() throws ClientProtocolException, IOException {
            restClient = new RestClient1();
            restClient.get(url);
        }
}
