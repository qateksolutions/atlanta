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

public class SimplePutTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePutTest.class);

    @Test
    public void updateUserFields() {
        LOGGER.info("---------[API Test] PUT - Update User Fields---------");
        String userName = "Md Alam";
        String userRole = "Engineer";

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", userName);
        reqBody.put("job", userRole);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reqBody.toJSONString());
        LOGGER.debug("Request Body" + reqBody);

        Response response = httpRequest.request(Method.PUT, "/2");

        // Now let us print the body of the response
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        // First get the JsonPath object instance from the Response
        JsonPath jsonPath = response.jsonPath();

        // Validate that user is updated
        String record = jsonPath.getString("name");
        Assert.assertEquals(record, userName);
        LOGGER.info("---------[API Test] End of Test---------");
    }
}
