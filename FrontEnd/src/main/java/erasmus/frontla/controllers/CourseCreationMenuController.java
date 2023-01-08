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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CourseCreationMenuController {

    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField creditsField;


    @FXML
    private Text pageText;


    @FXML
    private ChoiceBox<String> semesterPick;


    @FXML
    private Button backButton;

    @FXML
    private Button createButton;

    private String oldname;

    public void initialize(){
        ArrayList<String> listSeme=new ArrayList<String>(Arrays.asList("winter","summer","full year"));
        ObservableList<String> list = FXCollections.observableArrayList(listSeme);
        semesterPick.setItems(list);
    }

    public void init(Course course) throws Exception {
        nameField.setText(course.getName());
        oldname = nameField.getText();
        descriptionField.setText(course.getDefinition());
        creditsField.setText(course.getCredits().toString());
        pageText.setText("Modify Course");
        createButton.setText("Modify");
        semesterPick.setValue(course.getSemester());

    }

    @FXML
    void createCourse(ActionEvent event) throws Exception {
        if (createButton.getText().compareTo("Create")==0) {
            if(nameField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course Title");
                alerta.setContentText("The course must have a title");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
            else if(CoursePetitions.getInstance().findByName(nameField.getText()).getName()!=null){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course Title");
                alerta.setContentText("There is a course that already have that title");
                Optional<ButtonType> resultado = alerta.showAndWait();

            }
            else if(descriptionField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course description");
                alerta.setContentText("The course must have a description");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
            else if(nameField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course credits");
                alerta.setContentText("The course must have a number of credits");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
            else {
                Course course = new Course(nameField.getText(), descriptionField.getText(), Integer.valueOf(creditsField.getText()),semesterPick.getValue());

                course.setName(nameField.getText());
                course.setDefinition(descriptionField.getText());
                course.setCredits(Integer.parseInt(creditsField.getText()));

                CoursePetitions a = CoursePetitions.getInstance();

                a.createCourse(course);
                if(createButton.getText().compareTo("Create")==0) {
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setTitle("CONFIRMATION");
                    alerta.setHeaderText("A course has been created");
                    Optional<ButtonType> resultado = alerta.showAndWait();
                }
            }
        }
        else{
            //CoursePetitions.getInstance().deleteCourse(oldname);
            if(nameField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course Title");
                alerta.setContentText("The course must have a title");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
            else if(CoursePetitions.getInstance().findByName(nameField.getText()).getName()!= null){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course Title");
                alerta.setContentText("There is a course that already have that title");
                Optional<ButtonType> resultado = alerta.showAndWait();

            }
            else if(descriptionField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course description");
                alerta.setContentText("The course must have a description");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
            else if(nameField.getText().isEmpty()){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Warning");
                alerta.setHeaderText("Course credits");
                alerta.setContentText("The course must have a number of credits");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }

            else {


                Course course = new Course(nameField.getText(), descriptionField.getText(), Integer.valueOf(creditsField.getText()),semesterPick.getValue());


                course.setName(nameField.getText());
                course.setDefinition(descriptionField.getText());
                course.setCredits(Integer.parseInt(creditsField.getText()));

                CoursePetitions a = CoursePetitions.getInstance();

                a.createCourse(course);
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("CONFIRMATION");
                alerta.setHeaderText("A course has been modified");
                Optional<ButtonType> resultado = alerta.showAndWait();
            }
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
    void homeView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  Loader.LoaderView("seeCourses.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Course management");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }


    @FXML
    void createCoursePage(ActionEvent event) throws IOException {
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
        stage.setTitle("Delete");
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

}
