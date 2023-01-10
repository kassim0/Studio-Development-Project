package erasmus.frontla.controllers;
import erasmus.frontla.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static erasmus.frontla.Loader.LoaderView;

public class HomePageController {
    @FXML
    private Button homeButton;

    @FXML
    private Button studyButton;

    @FXML
    private Button laButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    void loginView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("LoginPage.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void signupView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("SignUpPage.fxml");
        Scene scene = new Scene(pane,900,600);
        stage.setTitle("Sign Up");
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
}
