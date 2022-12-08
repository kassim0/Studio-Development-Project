package erasmus.frontla.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CourseDescriptionController {

    @FXML
    private Text textoACambiar;

    public void setTextoACambiar(Text texto){
        this.textoACambiar = texto;
    }
}