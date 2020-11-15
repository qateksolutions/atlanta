package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDeleteTest {
    private static final Logger LOGGER = LogManager.getLogger(SimpleDeleteTest.class);

    @Test
    public void deleteSingleUser() {
        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the RequestSpecification of the request that you want to sent to the server
        // The server is specified by the baseURI that we have specified in the above step
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method type.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.DELETE, "/2");

        // Now let us print the body of the response
        LOGGER.debug(response.getBody().asString());

        // Now let us print the body of the response status
        LOGGER.debug("Actual Status code: " + response.getStatusCode());

        // Assert that the correct status is returned.
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
