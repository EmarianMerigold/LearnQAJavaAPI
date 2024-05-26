package homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Redirect {

    @Test
    public void testGetRedirectAddress(){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        //Вывод кода ответа
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);

        //Вывод адреса редиректа
        String location = response.getHeader("Location");
        System.out.println("URL for redirect: " + location);

    }

}
