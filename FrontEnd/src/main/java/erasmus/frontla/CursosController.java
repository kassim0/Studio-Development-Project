package erasmus.frontla;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class CursosController {

    @FXML
    private ListView<Integer> ListaDeCursos;

    @FXML
    private Button boton2;

    @FXML
    private AnchorPane panel;

    @FXML
    private Label text1;

    @FXML
    void getCoursesClick(ActionEvent event) {
        text1.setText("He cambiado!");

        poblar();
    }

    private void poblar(){
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(5);
        lista.add(16);
        lista.add(2);

        for(Integer listaa:lista ){
            ListaDeCursos.getItems().add(listaa);
        }
    }

}