import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest {

    @Test
    public void testRestAssured(){
        Map<String, String> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1");
        headers.put("myHeader2", "myValue2");

        Response response = RestAssured
                .given()
                //.headers(headers)
                .redirects()
                .follow(false)
                .when()
                //.get("https://playground.learnqa.ru/api/show_all_headers")
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();

        response.prettyPrint();

        //Headers responseHeaders = (Headers) response.getHeaders(); // Получение всех заголовков
        //System.out.println(responseHeaders);
        String locationHeader = response.getHeader("Location"); // Получение конкретного заголовка
        System.out.println(locationHeader);

    }
}