package ru.tinkoff.fintech.qa.DBTests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;

import javax.management.Query;


public class DatebaseTest {
    public static Session session;
    @BeforeAll
    public static void init() {
        UserEntity1 requestUser = new UserEntity1();
        requestUser.setId(16768);
        requestUser.setFio("Po Gh Jj22");
        requestUser.setPhone("80123456789");
        requestUser.setPasswordNumber(12);
        requestUser.setPasswordSeries(1222);
        SessionFactory sessionFactory = DbfactoryCreator.createSessionFactory();
        session = sessionFactory.openSession();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestUser)
                .post("http://localhost:8080/api/add");
    }
    @Test
    public void addUserDbTest() {
        UserEntity1 user =session.find(UserEntity1.class, 16768);
        Assertions.assertEquals(user.getFio(), "Po Gh Jj22");

    }

}
