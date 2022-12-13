package erasmus.frontla.controllers;
import erasmus.frontla.Loader;
import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseCreationMenuController {

    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField creditsField;

    @FXML
    private Button backButton;

    @FXML
    private Button createButton;

    @FXML
    void createCourse(ActionEvent event) throws Exception {
        Course course = new Course(nameField.getText(),descriptionField.getText(),Integer.valueOf(creditsField.getText()));

        course.setName(nameField.getText());
        course.setDefinition(descriptionField.getText());
        course.setCredits(Integer.parseInt(creditsField.getText()));

        CoursePetitions a = CoursePetitions.getInstance();

        a.createCourse(course);
        System.out.println(CoursePetitions.getInstance().getCourse(1).getName());
        System.out.println(CoursePetitions.getInstance().findByName("ad").getName());

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
}
