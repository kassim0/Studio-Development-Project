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
    void nuevaVista(ActionEvent event) {

    }
    @FXML
    void seeCourses(ActionEvent event) throws Exception {
        helloController.texto();
       //metodoAux();
        poblar();
        //refresh();
    }
    private void poblar() throws Exception {
        CoursePetitions coursePetitions = new CoursePetitions();


        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();

        for (Course curse : listadecursos) {
            String nombreAux =curse.getId() + "/" + curse.getName();

            lst.getItems().add(nombreAux);
        }
        /*
        lst.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String cursoSeleccionado = lst.getSelectionModel().getSelectedItem();
                try {
                    Course curso =  CoursePetitions.getInstance().findByName(cursoSeleccionado);
                    etiqueta.setText(curso.getDefinition());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println(curso.getCredits() + " " + curso.getDefinition());

            }
        });*/

    }
    public void listViewSelectedCourse() throws Exception {
        String nameOfcourse = String.valueOf(lst.getSelectionModel().getSelectedItems());
        Course curso = CoursePetitions.getInstance().findByName(nameOfcourse);
        etiqueta.setText(curso.getDefinition());


    }

    private void poblarTabla() throws Exception{
        CoursePetitions coursePetitions = new CoursePetitions();


        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();

    }
    private void metodoAux() throws Exception {
        CoursePetitions coursePetitions2 = new CoursePetitions();
        List<Course> listaCursos3 = coursePetitions2.getAllCurso();

        ObservableList<Course> listaaaa = FXCollections.observableArrayList();
        
        for (Course curse2 : listaCursos3) {

            String nombre = curse2.getName();
            Integer creditos = curse2.getCredits();
            String definicion = curse2.getDefinition();

            CoursePetitions a = CoursePetitions.getInstance();
            Course v=new Course("hola", "sdafda",3);
            listaaaa.add(v);
        }

        this.tbleName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tbleCTS.setCellValueFactory(new PropertyValueFactory("credits"));
        this.tbleDef.setCellValueFactory(new PropertyValueFactory("definition"));

        table.setItems(listaaaa);
    }
    private void refresh() throws SQLException {
        query = "SELECT name FROM 'Course'";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
                lst.getItems().add(resultSet.toString());
        }

    }

}
