package erasmus.frontla.controllers;

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
        Course v=new Course("hola", "sdafda",3,"winter","University_of_Poznan");
        v.setCredits(3);
        v.setDefinition("sdafda");
        v.setName("reer");
        a.createCourse(v);


        Course v2=new Course("hola", "sdafda",3,"summer","University_of_Krakow");
        v.setCredits(3);
        v.setDefinition("mas descripcion");
        v.setName("cursoDos");
        a.createCourse(v);


        System.out.println(CoursePetitions.getInstance().getCourse(1).getName());
        return CoursePetitions.getInstance().getCourse(1).getName();
    }
}