package erasmus.frontla.controllers;

import erasmus.frontla.Loader;
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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import static erasmus.frontla.Loader.LoaderView;

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

    @FXML
    private ComboBox<String> universities;
    @FXML
    private Label selectedUniversity;

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


    public void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList("University_of_Poznan", "University_of_Warsawa", "University_of_Krakow");
        universities.setItems(list);
    }

    @FXML
    void nuevaVista(ActionEvent event) throws Exception {
        List courseSelected = lst.getSelectionModel().getSelectedItems();
        String courseSelectedInString = (String) courseSelected.get(0);
        Course curso = CoursePetitions.getInstance().findByName(courseSelectedInString);

        Stage stage = new Stage();
        URL paneUrl = Loader.LoaderViewCont("courseView.fxml");

        FXMLLoader paneL = new FXMLLoader(paneUrl);
        AnchorPane pane = paneL.load();

        CourseViewController controller = paneL.getController();
        controller.init(curso.getName(), curso.getCredits(), curso.getDefinition());
        Scene scene = new Scene(pane);
        stage.setTitle("View course");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();

    }

    @FXML
    void seeCourses(ActionEvent event) throws Exception {
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
    @FXML
    void selectUniversity(ActionEvent event) throws Exception {
        String s = universities.getSelectionModel().getSelectedItem().toString();
        selectedUniversity.setText(s);

        CoursePetitions coursePetitions = new CoursePetitions();
        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getCoursesByUniversity(s);

        ArrayList<String> nombreDeLosCursos = new ArrayList<>();

        for (Course curse : listadecursos) {
            String nombreAux =curse.getName();

            nombreDeLosCursos.add(nombreAux);
        }

        lst.getItems().clear();
        lst.getItems().addAll(searchList(searchBar.getText(), nombreDeLosCursos));
    }
}
