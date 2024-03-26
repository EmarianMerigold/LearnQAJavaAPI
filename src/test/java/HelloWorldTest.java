import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class HelloWorldTest {

    @Test
    public void testRestAssured(){

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                //.get("https://playground.learnqa.ru/api/check_type")
                //.get("https://playground.learnqa.ru/api/get_500")
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

    }
}