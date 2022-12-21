package erasmus.frontla.controllers;


import erasmus.frontla.Loader;
import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseModifySelectionController {


    @FXML
    private ListView<String> listCourse;

    @FXML
    private Button backButton;

    @FXML
    private Button modifyButton;
    public ObservableList<String> observableList;
    int delete;


    public void cargarDatos() throws Exception {

        CoursePetitions coursePetitions = new CoursePetitions();
        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();

        for (Course curse : listadecursos) {
            String nombreAux =curse.getName();

            listCourse.getItems().add(nombreAux);
        }
    }

    public void init(int a) throws Exception {

        cargarDatos();
        delete=a;
        if(a==1){
            modifyButton.setText("Delete");
        }
        else{
            modifyButton.setText("Modify");
        }
    }

    @FXML
    void backView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  Loader.LoaderView("CoursesCreation.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Course management");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();

    }

    @FXML
    void modifyCourse(ActionEvent event) throws Exception {
        if(delete==1){
            String selected = listCourse.getSelectionModel().getSelectedItem();
            CoursePetitions.getInstance().deleteCourse(selected);
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("CONFIRMATION");
            alerta.setHeaderText("A course has been deleted");
            Optional<ButtonType> resultado = alerta.showAndWait();
        }
        else {
            String selected = listCourse.getSelectionModel().getSelectedItem();
            Course toModify = CoursePetitions.getInstance().findByName(selected);

            Stage stage = new Stage();
            URL paneUrl = Loader.LoaderViewCont("CourseCreationMenu.fxml");

            FXMLLoader paneL = new FXMLLoader(paneUrl);
            AnchorPane pane = paneL.load();

            CourseCreationMenuController controller = paneL.getController();
            controller.init(toModify);
            Scene scene = new Scene(pane);
            stage.setTitle("Modify");
            stage.setScene(scene);
            stage.show();
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
        }

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
    void modifyCoursePage(ActionEvent event) throws Exception {
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

    public void homeView(ActionEvent actionEvent) {
    }
}