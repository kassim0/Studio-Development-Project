module erasmus.frontla {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens erasmus.frontla to javafx.fxml;
    exports erasmus.frontla;
}