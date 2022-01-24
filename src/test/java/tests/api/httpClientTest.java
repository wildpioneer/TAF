package tests.api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class httpClientTest {

    @Test
    public void simpleApiTest() throws IOException {
        String restURL = "https://reqres.in";
        // Create Object and pass the url
        HttpUriRequest request = new HttpGet(restURL);

        // send the response or execute the request
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Verify the response code is equal to 200
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
