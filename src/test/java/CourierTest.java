import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CourierTest {


/*    @Test
    public void createCourierTest() {

        String login = "user0201";
        String password = "user0201";
        String firstName = "user0201";
        String body = "{\"login\":\"" + login + "\","
                + "\"password\":\"" + password + "\","
                + "\"firstName\":\"" + firstName + "\"}";
        System.out.println(body);

        given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .statusCode(201);
    }*/

/*    @Test
    public void loginCourierTest() {

        String login = "user0201";
        String password = "user0201";
        String body = "{\"login\":\"" + login + "\","
                + "\"password\":\"" + password + "\" }";

        System.out.println(body);

        given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .statusCode(200);
    }*/



    @Test
    @DisplayName("Add a")
    @Description("This test a.")

    public void deleteCourierTest() {

        String login = "user0201";
        String password = "user0201";
        String body = "{\"login\":\"" + login + "\","
                + "\"password\":\"" + password + "\" }";

        int num = given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .statusCode(200)
                .extract()
                .path("id");
        System.out.println(num);

        String id = "{\"id\":\""+ num +"\"}";
        System.out.println(id);
        given()
                .header("Content-type", "application/json")
                .body(id)
                .when()
                .delete("http://qa-scooter.praktikum-services.ru/api/v1/courier/" + num)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Add b")
    @Description("This test is b.")
    public void createOrderTest(){

        String body = "{ \"firstName\": \"Naruto\",\"lastName\": \"Uchiha\",\"address\": \"Konoha, 142 apt.\",\"metroStation\": 4,\"phone\": \"+7 800 355 35 35\",\"rentTime\": 5,\"deliveryDate\": \"2020-06-06\",\"comment\": \"Saske, come back to Konoha\",\"color\": [\"BLACK\"]}";

        int num = given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                .then()
                .statusCode(201)
                .extract()
                .path("track");

        System.out.println(num);
    }

    @Test
    @DisplayName("Add c")
    @Description("This test is c.")
    public void listOrdersTest(){
        List<String> list = new ArrayList<>();
       list = given()
                .header("Content-type", "application/json")
                .when()
                .get("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                .then()
                .statusCode(200)
               .extract()
               .path("orders");
       System.out.println(list);
    }
}
