module erasmus.frontla {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens erasmus.frontla to javafx.fxml;
    exports erasmus.frontla;
    exports erasmus.frontla.controllers;
    opens erasmus.frontla.controllers to javafx.fxml;
}