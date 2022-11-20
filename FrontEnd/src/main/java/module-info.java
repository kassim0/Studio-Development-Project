module erasmus.frontla {
    requires javafx.controls;
    requires javafx.fxml;


    opens erasmus.frontla to javafx.fxml;
    exports erasmus.frontla;
}