package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleGetTest {
    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getAllUsers() {
        LOGGER.info("---------[API Test] Read all Users---------");
        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";

        // Get the RequestSpecification of the request that you want to sent to the server
        // The server is specified by the baseURI that we have specified in the above step
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method type.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET);

        // Now let us print the body of the response
        LOGGER.debug(response.getBody().asString());

        // Now let us print the body of the response status
        LOGGER.debug("Actual Status code: " + response.getStatusCode());

        // Assert that the correct status is returned.
        Assert.assertEquals(response.getStatusCode(), 200);

        // First get the JsonPath object instance from the Response
        JsonPath jsonPath = response.jsonPath();

        // Validate that suer record is not null
        String record = jsonPath.getString("data[0]");
        Assert.assertNotNull(record, "User record is null");
        LOGGER.info("---------[API Test] End of Test---------");
    }

    @Test
    public void getSingleUser() {
        LOGGER.info("---------[API Test] GET - Read Single User---------");
        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the RequestSpecification of the request that you want to sent to the server
        // The server is specified by the baseURI that we have specified in the above step
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method type.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/2");

        // Now let us print the body of the response
        LOGGER.debug(response.getBody().asString());

        // Now let us print the body of the response status
        LOGGER.debug("Actual Status code: " + response.getStatusCode());

        // Assert that the correct status is returned.
        Assert.assertEquals(response.getStatusCode(), 200);

        // First get the JsonPath object instance from the Response
        JsonPath jsonPath = response.jsonPath();

        // Validate that suer record is not null
        String record = jsonPath.getString("data.first_name");
        Assert.assertEquals(record, "Janet");
        LOGGER.info("---------[API Test] End Of Test---------");
    }
}
