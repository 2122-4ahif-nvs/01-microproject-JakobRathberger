package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OptionResourceTest {

    @Test
    @Order(1000)
    void getSingleOptions(){
        String path = "option/id/";
        given().auth().basic("scott", "jb0ss").when().get(path + "1")
                .then().statusCode(200).
                body(is("{\"endTime\":\"2022-01-30T14:00:00\",\"id\":1,\"poll\":{\"description\":\"Meeting for Project1\",\"id\":1,\"name\":\"Meeting\"},\"startTime\":\"2022-01-30T12:00:00\"}"));
        given().auth().basic("scott", "jb0ss").when().get(path + "4")
                .then().statusCode(200).
                body(is("{\"endTime\":\"2022-02-01T16:00:00\",\"id\":4,\"poll\":{\"description\":\"Meeting for Project1\",\"id\":1,\"name\":\"Meeting\"},\"startTime\":\"2022-02-01T14:00:00\"}"));
        given().auth().basic("scott", "jb0ss").when().get(path + "9")
                .then().statusCode(200).
                body(is("{\"endTime\":\"2022-02-22T20:00:00\",\"id\":9,\"poll\":{\"description\":\"Meeting for Project1\",\"id\":3,\"name\":\"Meeting\"},\"startTime\":\"2022-02-22T10:00:00\"}"));
        given().auth().basic("scott", "jb0ss").when().get(path + "14")
                .then().statusCode(200).
                body(is("{\"endTime\":\"2022-02-28T14:00:00\",\"id\":14,\"poll\":{\"description\":\"Meeting for Project3\",\"id\":4,\"name\":\"Meeting\"},\"startTime\":\"2022-02-28T13:00:00\"}"));
        given().auth().basic("noadmin", "n0Adm1n").when().get(path + "18")
                .then().statusCode(200).
                body(is("{\"endTime\":\"2022-03-18T11:00:00\",\"id\":18,\"poll\":{\"description\":\"Meeting for Project4\",\"id\":5,\"name\":\"Meeting\"},\"startTime\":\"2022-03-18T10:00:00\"}"));
    }
}
