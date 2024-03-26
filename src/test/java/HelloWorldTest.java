import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest {

    @Test
    public void testRestAssured(){
        Map<String, String> data = new HashMap<>();
        data.put("login", "secret_login");
        data.put("password", "secret_pass");

        Response response = RestAssured
                .given()
                .body(data)
                .when()
                .get("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

        /*
        System.out.println("\nCode:");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        System.out.println("\nPretty text:");
        response.prettyPrint();

        System.out.println("\nHeaders:");
        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);

        //Получение всех cookie ключ/значение
        System.out.println("\nCookies:");
        Map<String,String> responseCookies = response.getCookies();
        System.out.println(responseCookies);
        */

        //-------------------------------------------------------------------

        //Получение конкретного значения у параметра auth_cookie
        System.out.println("\nCookie_key:");
        String responseCookie = response.getCookie("auth_cookie");
        System.out.println(responseCookie);

        // Создание переменной, в которую будет записываться значение полученного cookie.
        // Также сделано условие, что записываться cookie будет только валидное. Значении null не сохраняется.
        Map<String, String> cookies = new HashMap<>();
        if(responseCookie != null) {
            cookies.put("auth_cookie", responseCookie);
        }

        // В данном запросе для авторизовации по cookie передаётся сохранённое значение cookie,
        // полученное из предыдущего запроса
        Response responceForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .get("https://playground.learnqa.ru/api/check_auth_cookie")
                .andReturn();

        System.out.println("\n");
        responceForCheck.print();


    }
}