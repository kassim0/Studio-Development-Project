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
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class SeeCoursesController {

    @FXML
    private Button btnSearch;

    @FXML
    private TextField searchBar;

    @FXML
    private Button btnSeeCourses;

    @FXML
    private Label etiqueta;

    @FXML
    private ListView<String> lst;

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
        List courseSelected = lst.getSelectionModel().getSelectedItems();
        String courseSelectedInString = (String) courseSelected.get(0);
        Course curso = CoursePetitions.getInstance().findByName(courseSelectedInString);
        etiqueta.setText(curso.getDefinition());
    }

    @FXML
    void searchCourse(ActionEvent event) throws Exception {
        CoursePetitions coursePetitions = new CoursePetitions();
        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();
        
        ArrayList<String> nombreDeLosCursos = new ArrayList<>();

        for (Course curse : listadecursos) {
            String nombreAux =curse.getName();

            nombreDeLosCursos.add(nombreAux);
        }

        lst.getItems().clear();
        lst.getItems().addAll(searchList(searchBar.getText(), nombreDeLosCursos));

    }

    private List<String> searchList(String searchWord, List<String> listOfStrings){
        List<String> searchWordsArray = Arrays.asList(searchWord.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
