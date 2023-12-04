package ru.tinkoff.fintech.qa.DBTests;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;


public class DbfactoryCreator {
    public static SessionFactory createSessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                .setProperty("hibernate.connection.username", "admin")
                .setProperty("hibernate.connection.password", "1234")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("show_sql", "true")
                .addAnnotatedClass(UserEntity1.class)
                .buildSessionFactory();
    }
}

