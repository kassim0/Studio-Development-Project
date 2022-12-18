package erasmus.frontla.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class CourseViewController {

    @FXML
    private TextArea areaDescription;

    @FXML
    private Text txtCredits;

    @FXML
    private Text txtNameOfCourse;

    public void init(String name, Integer credits, String description){
        areaDescription.setText(description);
        txtCredits.setText(String.valueOf(credits));
        txtNameOfCourse.setText(name);
    }
}