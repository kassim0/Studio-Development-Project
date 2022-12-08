package erasmus.frontla.controllers;
import erasmus.frontla.Loader;
import erasmus.frontla.endpoints.CoursePetitions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CourseCreationController {
    @FXML
    private Button createButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button deleteButton;

    @FXML
    void createCourse(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  Loader.LoaderView("CourseCreationMenu.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Create");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();


    }

    @FXML
    void deleteCourse(ActionEvent event) {

    }

    @FXML
    void modifyCourse(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        URL paneUrl = Loader.LoaderViewCont("CourseModifySelection.fxml");

        FXMLLoader paneL = new FXMLLoader(paneUrl);
        AnchorPane pane = paneL.load();

        CourseModifySelectionController controller = paneL.getController();
        controller.init();
        Scene scene = new Scene(pane);
        stage.setTitle("Modify");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();


    }
}
