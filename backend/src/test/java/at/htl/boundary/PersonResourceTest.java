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
class PersonResourceTest {

    @Test
    @Order(1000)
    void getSinglePersons(){
        String path = "person/id/";
        String name = "scott";
        String pw = "jb0ss";

        given().auth().preemptive().basic(name, pw).when().get(path + "1")
                .then().statusCode(200).
                body(is("{\"id\":1,\"name\":\"Zoe\"}"));
        given().auth().preemptive().basic(name, pw).when().get(path + "3")
                .then().statusCode(200).
                body(is("{\"id\":3,\"name\":\"Eliza\"}"));
        given().auth().preemptive().basic(name, pw).when().get(path + "5")
                .then().statusCode(200).
                body(is("{\"id\":5,\"name\":\"Jodie\"}"));
        given().auth().preemptive().basic(name, pw).when().get(path + "8")
                .then().statusCode(200).
                body(is("{\"id\":8,\"name\":\"Eve\"}"));
        given().auth().preemptive().basic(name, pw).when().get(path + "9")
                .then().statusCode(200).
                body(is("{\"id\":9,\"name\":\"Eve\"}"));
    }
}
