package homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Parsing {

    @Test
    public void testParsing(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        //Вывод текста второго сообщения
        String secondAnswer = response.getString("messages[1].message");
        System.out.println("Second message text: " + secondAnswer);

        //Вывод времени второго сообщения
        String secondAnswerTimestamp = response.getString("messages[1].timestamp");
        System.out.println("Second message timestamp value: " + secondAnswerTimestamp);

        //Вывод всех данных второго сообщения
        String fullAnswer = response.getString("messages[1]");
        System.out.println("Check: " + fullAnswer);

        //Вывод ответа от сервера
        //System.out.println("\nPretty text:");
        //response.prettyPrint();

    }

}
