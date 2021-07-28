module MyMailClient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.mail;
    requires activation;

    opens pl.wojciechsiwek;
    opens pl.wojciechsiwek.controller;
    opens pl.wojciechsiwek.model;
}