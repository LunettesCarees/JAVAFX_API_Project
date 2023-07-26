module com.example.javaassignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;
    requires com.google.gson;
    requires javafx.web;


    opens com.example.javaassignment2 to javafx.fxml;
    exports com.example.javaassignment2;
    exports com.example.javaassignment2.Controllers;
    opens com.example.javaassignment2.Controllers to javafx.fxml;

    // other module directives
    opens com.example.javaassignment2.Models;
}

