package erasmus.frontla.controllers;
import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    }
}
