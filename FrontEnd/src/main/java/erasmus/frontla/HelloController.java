package erasmus.frontla;

import erasmus.frontla.endpoints.CoursePetitions;
import erasmus.frontla.objects.Course;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Exception {
        texto();
    }

    public String texto() throws Exception {
        CoursePetitions a = CoursePetitions.getInstance();
        Course v=new Course();
        v.setCredits(3);
        v.setDefinition("sdafda");
        v.setName("reer");
        a.createCourse(v);
        System.out.println(1);
        a.getCourse(1);
        System.out.println(2);

        System.out.println(CoursePetitions.getInstance().getCourse(1).getName());
        return CoursePetitions.getInstance().getCourse(1).getName();
    }
}