package erasmus.frontla;

import erasmus.frontla.endpoints.CoursePetitions;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        texto();
    }

    public String texto(){
        CoursePetitions a = CoursePetitions.getInstance();
        System.out.println(1);
        a.getCourse(1);
        System.out.println(2);

        System.out.println(CoursePetitions.getInstance().getCourse(1).getName());
        return CoursePetitions.getInstance().getCourse(1).getName();
    }
}