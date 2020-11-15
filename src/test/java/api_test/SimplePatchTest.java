package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePatchTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePatchTest.class);

    @Test
    public void updateUserSingleField() {
        LOGGER.info("---------[API Test] PATCH - Update Single Field ---------");
        String userRole = "Engineer";

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject reqBody = new JSONObject();
        reqBody.put("job", userRole);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reqBody.toJSONString());
        LOGGER.debug("Request Body" + reqBody);

        Response response = httpRequest.request(Method.PATCH, "/2");
        LOGGER.debug(response.getBody().asString());

        // Now let us print the body of the response status
        LOGGER.debug("Actual Status code: " + response.getStatusCode());

        // Assert that the correct status is returned.
        Assert.assertEquals(response.getStatusCode(), 200);

        // First get the JsonPath object instance from the Response
        JsonPath jsonPath = response.jsonPath();

        // Validate that user is updated
        String record = jsonPath.getString("job");
        Assert.assertEquals(record, userRole);
        LOGGER.info("---------[API Test] End Of Test---------");
    }
}
