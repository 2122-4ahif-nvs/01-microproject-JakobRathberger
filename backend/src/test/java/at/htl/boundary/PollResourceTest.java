package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PollResourceTest {

    @Test
    @Order(1000)
    void getSinglePolls(){
        String path = "poll/id/";
        given().when().get(path + "1")
                .then().statusCode(200).
                body(is("{\"description\":\"Meeting for Project1\",\"id\":1,\"name\":\"Meeting\"}"));
        given().when().get(path + "2")
                .then().statusCode(200).
                body(is("{\"description\":\"Meeting for Project2\",\"id\":2,\"name\":\"Meeting\"}"));
        given().when().get(path + "3")
                .then().statusCode(200).
                body(is("{\"description\":\"Meeting for Project1\",\"id\":3,\"name\":\"Meeting\"}"));
        given().when().get(path + "4")
                .then().statusCode(200).
                body(is("{\"description\":\"Meeting for Project3\",\"id\":4,\"name\":\"Meeting\"}"));
        given().when().get(path + "5")
                .then().statusCode(200).
                body(is("{\"description\":\"Meeting for Project4\",\"id\":5,\"name\":\"Meeting\"}"));
    }

}