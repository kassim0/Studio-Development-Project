package erasmus.frontla.controllers;

import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SeeCoursesController {

    @FXML
    private Button btnSeeCourses;

    @FXML
    private Label etiqueta;

    @FXML
    private ListView<String> lst;

    @FXML
    private TableView<Course> table;

    @FXML
    private TableColumn<Course, Integer> tbleCTS;

    @FXML
    private TableColumn<Course, String> tbleDef;

    @FXML
    private TableColumn<Course, String> tbleName;

    @FXML
    private Button nuevaVista;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    HelloController helloController = new HelloController();

    private final StringProperty project = new SimpleStringProperty();

    public final StringProperty projectProperty() {
        return project;
    }

    public final String getProject() {
        return project.get();
    }

    public final void setProject(String value) {
        project.set(value);
    }


    @FXML
    void nuevaVista(ActionEvent event) throws Exception {
        List lista = lst.getSelectionModel().getSelectedItems();
        String nombre = (String) lista.get(0);
        System.out.println(nombre);
        System.out.println(lst.getSelectionModel().getSelectedItems());
        System.out.println(lst.getSelectionModel().getSelectedItems().getClass().getSimpleName());

        List courseSelected = lst.getSelectionModel().getSelectedItems();
        String courseSelectedInString = (String) courseSelected.get(0);
        Course curso = CoursePetitions.getInstance().findByName(courseSelectedInString);
        etiqueta.setText(curso.getDefinition());
        //System.out.println(curso);

        //etiqueta.setText(CoursePetitions.getInstance().findByName("cursoDos").getDefinition());

        //etiqueta.setText(curso.getDefinition());
        //Course cursoAux = CoursePetitions.getInstance().getCourse(1);
        //etiqueta.setText(cursoAux.getName());

    }
    @FXML
    void seeCourses(ActionEvent event) throws Exception {
        helloController.texto();
        poblar();
    }



    private void poblar() throws Exception {
        CoursePetitions coursePetitions = new CoursePetitions();


        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();

        for (Course curse : listadecursos) {
            String nombreAux =curse.getName();

            lst.getItems().add(nombreAux);
        }
        System.out.println("**** " + CoursePetitions.getInstance().findByName("cursoDos").getDefinition() +" ***");
    }


    public void listViewSelectedCourse() throws Exception {
        /*
        String nameOfcourse = String.valueOf(lst.getSelectionModel().getSelectedItems());
        //Course curso = CoursePetitions.getInstance().findByName(nameOfcourse);
        //etiqueta.setText(curso.getDefinition());
        Course cursoAux = CoursePetitions.getInstance().getCourse(1);
        etiqueta.setText(cursoAux.getName());

        */
    }
}
