package erasmus.frontla.controllers;

import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class SeeCoursesController {

    @FXML
    private Button btnSeeCourses;

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
    void seeCourses(ActionEvent event) throws Exception {
        helloController.texto();
       // metodoAux();
        poblar();
    }
    private void poblar() throws Exception {
        CoursePetitions coursePetitions = new CoursePetitions();


        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();

        for (Course curse : listadecursos) {
            lst.getItems().add(curse.getName());

            String nombreAux = curse.getName();
            
        }


    }

    private void poblarTabla() throws Exception{
        CoursePetitions coursePetitions = new CoursePetitions();


        List<Course> listadecursos = null;
        listadecursos = coursePetitions.getAllCurso();



    }
    private void metodoAux() throws Exception {
        CoursePetitions coursePetitions2 = new CoursePetitions();
        List<Course> listadecursos2 = coursePetitions2.getAllCurso();

        ObservableList<Course> listaaaa = FXCollections.observableArrayList();


        for (Course curse2 : listadecursos2) {

            String nombre = curse2.getName();
            Integer creditos = curse2.getCredits();
            String definicion = curse2.getDefinition();

            CoursePetitions a = CoursePetitions.getInstance();
            Course v=new Course("hola", "sdafda",3);
            listaaaa.add(v);
        }

        tbleName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbleCTS.setCellValueFactory(new PropertyValueFactory<>("credits"));
        tbleDef.setCellValueFactory(new PropertyValueFactory<>("definition"));

        table.setItems(listaaaa);
    }


}
