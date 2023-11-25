package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import model.CreateUserReq;
import model.CreateUserResp;
import model.RegUser;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;
import static specs.SpecsReqRes.request;
import static specs.SpecsReqRes.responseSpec;


@Owner("Keniy163")
@Feature("API test")
@Story("ReqRes")
@Tags({@Tag("api")})
public class ReqresTests {

    @Test
    @DisplayName("Get lists users")
    void getUserListWithLombok() {
        User data = given().spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .extract().as(User.class);
    }

    @Test
    @DisplayName("Check user in DBase")
    void getSingleUserNotFound() {
        given()
                .spec(request)
                .when()
                .get("/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Create user")
    void createUserLombok() {
        CreateUserReq body = new CreateUserReq();
        body.setName("Keniy");
        body.setJob("student");

        CreateUserResp response = given().spec(request)
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(CreateUserResp.class);

        assertEquals(body.getName(), response.getName());
        assertEquals(body.getJob(), response.getJob());
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getCreatedAt().isEmpty());
    }

    @Test
    @DisplayName("Refresh user")
    void updateUserLombok() {
        CreateUserReq body = new CreateUserReq();
        body.setName("Cumberbatch");
        body.setJob("Driver");

        CreateUserResp response = given().spec(request)
                .body(body)
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .extract().as(CreateUserResp.class);

        assertEquals(body.getName(), response.getName());
        assertEquals(body.getJob(), response.getJob());
    }

    @Test
    @DisplayName("Registration user")
    void registerSuccessfulLombok() {
        RegUser body = new RegUser();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("qwerty");

        CreateUserResp response = given().spec(request)
                .body(body)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec)
                .extract().as(CreateUserResp.class);

        assertEquals("4", response.getId());
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    @DisplayName("Check Id and E-mail user")
    void checkIdAndEmailOfFeaturedUser() {
        User userResponse = given().spec(request)
                .when()
                .pathParam("id", "2")
                .get("/users/{id}")
                .then()
                .spec(responseSpec)
                .extract().jsonPath().getObject("data", User.class);

        assertEquals(2, userResponse.getId());
        assertTrue(userResponse.getEmail().endsWith("@reqres.in"));
    }

    @Test
    @DisplayName("Check E-mail user with Groovy")
    public void checkEmailUsingGroovy() {

        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
    }

}
