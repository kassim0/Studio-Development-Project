package erasmus.frontla.controllers;


import erasmus.frontla.Loader;
import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseModifySelectionController {


    @FXML
    private ListView<String> listCourse;

    @FXML
    private Button backButton;

    @FXML
    private Button modifyButton;
    public ObservableList<String> observableList;


    public void cargarDatos() throws Exception {

        List<Course> bateria;

        bateria= CoursePetitions.getInstance().getAllCurso();
        System.out.println(bateria.size());

        List<String> nombres;

        for(int i=0;i<=bateria.size();i++){
            nombres.add(bateria.get(i).getName());
        }
        System.out.println(nombres.size());

        observableList = FXCollections.observableArrayList(nombres);

        listCourse.setItems(observableList);

        System.out.println(bateria);
    }

    public void init() throws Exception {
//
//        courseId.setCellValueFactory(new PropertyValueFactory<Course,Integer>("id"));
//        courseName.setCellValueFactory(new PropertyValueFactory<Course,String>("name"));
//        System.out.println("ss");
        cargarDatos();
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
    void modifyCourse(ActionEvent event) {

    }

}