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
class VoteResourceTest {

    @Test
    @Order(1000)
    void getSingleVotes(){
        String path = "vote/id/";
        given().when().get(path + "1")
                .then().statusCode(200).
                body(is("{\"id\":1,\"option\":{\"endTime\":\"2022-01-30T14:00:00\",\"id\":1,\"poll\":{\"description\":\"Meeting for Project1\",\"id\":1,\"name\":\"Meeting\"},\"startTime\":\"2022-01-30T12:00:00\"},\"person\":{\"id\":1,\"name\":\"Zoe\"}}"));
        given().when().get(path + "2")
                .then().statusCode(200).
                body(is("{\"id\":2,\"option\":{\"endTime\":\"2022-01-30T16:00:00\",\"id\":2,\"poll\":{\"description\":\"Meeting for Project1\",\"id\":1,\"name\":\"Meeting\"},\"startTime\":\"2022-01-30T14:00:00\"},\"person\":{\"id\":1,\"name\":\"Zoe\"}}"));
        given().when().get(path + "15")
                .then().statusCode(200).
                body(is("{\"id\":15,\"option\":{\"endTime\":\"2022-02-10T14:00:00\",\"id\":5,\"poll\":{\"description\":\"Meeting for Project2\",\"id\":2,\"name\":\"Meeting\"},\"startTime\":\"2022-02-10T12:00:00\"},\"person\":{\"id\":2,\"name\":\"Katy\"}}"));
        given().when().get(path + "39")
                .then().statusCode(200).
                body(is("{\"id\":39,\"option\":{\"endTime\":\"2022-03-09T11:00:00\",\"id\":17,\"poll\":{\"description\":\"Meeting for Project4\",\"id\":5,\"name\":\"Meeting\"},\"startTime\":\"2022-03-09T10:00:00\"},\"person\":{\"id\":4,\"name\":\"Verity\"}}"));
        given().when().get(path + "60")
                .then().statusCode(200).
                body(is("{\"id\":60,\"option\":{\"endTime\":\"2022-03-18T11:00:00\",\"id\":18,\"poll\":{\"description\":\"Meeting for Project4\",\"id\":5,\"name\":\"Meeting\"},\"startTime\":\"2022-03-18T10:00:00\"},\"person\":{\"id\":6,\"name\":\"Bob\"}}"));
    }
}