package erasmus.frontla.controllers;

import erasmus.frontla.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static erasmus.frontla.Loader.LoaderView;

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
    void deleteCourse(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        URL paneUrl = Loader.LoaderViewCont("CourseModifySelection.fxml");

        FXMLLoader paneL = new FXMLLoader(paneUrl);
        AnchorPane pane = paneL.load();

        CourseModifySelectionController controller = paneL.getController();
        controller.init(1);
        Scene scene = new Scene(pane);
        stage.setTitle("Modify");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();

    }

    @FXML
    void modifyCourse(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        URL paneUrl = Loader.LoaderViewCont("CourseModifySelection.fxml");

        FXMLLoader paneL = new FXMLLoader(paneUrl);
        AnchorPane pane = paneL.load();

        CourseModifySelectionController controller = paneL.getController();
        controller.init(0);
        Scene scene = new Scene(pane);
        stage.setTitle("Modify");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void homeView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("CourseCreationMenu.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }
}