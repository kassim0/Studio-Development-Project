package erasmus.frontla.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import static erasmus.frontla.Loader.LoaderView;

public class StudyProgrammesController {

    @FXML
    private Button winterButton;

    @FXML
    private Button springButton;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    void winterView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("WinterSemesterArch.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Winter Semester");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void springView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("SpringSemesterArch.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Spring Semester");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void studyView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("StudyProgrammesPage.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Study Programmes");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void laView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("LearningAgreement.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("LEARNING AGREEMENT");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void homeView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("HomePageTeste.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void Page1View(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("StudyProgrammesPage.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Study Programmes");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void Page2View(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("StudyProgrammesPage2.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }


    @FXML
    void Page3View(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("StudyProgrammesPage3.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Study Programmes");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://creef.put.poznan.pl/en"));
    }

    @FXML
    void openLink2(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://cat.put.poznan.pl/"));
    }

    @FXML
    void openLink3(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://wilit.put.poznan.pl/"));
    }

    @FXML
    void openLink4(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://www.phys.put.poznan.pl/"));
    }

    @FXML
    void openLink5(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://isie.put.poznan.pl/"));
    }

    @FXML
    void openLink6(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://www.dmef.put.poznan.pl/"));
    }

    @FXML
    void openLink7(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://architecture.put.poznan.pl/"));
    }

    @FXML
    void openLink8(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://www.fem.put.poznan.pl/"));
    }

    @FXML
    void openLink9(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("link clicked");
        Desktop.getDesktop().browse(new URI("https://www.fct.put.poznan.pl/"));
    }
}
