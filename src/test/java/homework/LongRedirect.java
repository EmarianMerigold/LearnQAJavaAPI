package homework;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import lib.ApiCoreRequests;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRedirect {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test
    public void testGetLongRedirectAddress(){

        String currentUrl = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode;
        int iterations = 0;

        do {
            Response response = apiCoreRequests
                    .makeGetRequestWithRedirect(currentUrl);

            statusCode = response.getStatusCode();
            System.out.println("Status code: " + statusCode);

            currentUrl = response.getHeader("Location");
            System.out.println("URL for redirect: " + currentUrl);

            System.out.println("\n------------------");

            iterations ++;

            // Если статус-код 200, то нужно выйти из цикла, чтобы избежать бесконечного выполнения.
            // Это необязательно в данном случае,однако, есди не остановить цикл,
            // то проверка на код 200 произойдет непосредственно перед новой запуском новой итерации
            /* if (statusCode == 200) {
                break;
            } */

        } while (statusCode != 200);

            // Проверка, что последний ответ имеет статус-код 200
            assertEquals(200, statusCode, "The final status code should be 200.");

            System.out.println("The cycle is stopped!");
            System.out.println("Last status code: " + statusCode);
            System.out.println("Total number of requests: " + iterations);
        }

}
