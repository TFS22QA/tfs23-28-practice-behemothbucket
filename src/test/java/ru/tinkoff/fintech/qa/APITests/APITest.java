package ru.tinkoff.fintech.qa.APITests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.fintech.qa.modelsAPI.RequestUser;
import ru.tinkoff.fintech.qa.modelsAPI.ResponseUser;

public class APITest {
    RequestUser requestUser;
    @BeforeEach
    public void init()
    {
        requestUser = new RequestUser();
        requestUser.setId(16768);
        requestUser.setFio("Po Gh Jj");
        requestUser.setPhone("80123456789");
        requestUser.setPassportSeries(1234);
        requestUser.setPassportNumber(123456);
    }

    @Test
    public void addUserTest()
    {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestUser)
                .post("http://localhost:8080/api/add")
                .then().statusCode(200);
    }

    @Test
    public void getUserTest()
    {
        RequestUser requestUser = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("http://localhost:8080/api/get/16768")
                .as(RequestUser.class);

        Assertions.assertEquals(requestUser.getFio(), "Po Gh Jj");
    }

    @Test
    public void deleteUserTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .post("http://localhost:8080/api/delete/1")
                .then()
                .statusCode(200);
    }



    }
