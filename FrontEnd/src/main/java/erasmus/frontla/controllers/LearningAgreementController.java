package erasmus.frontla.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

import static erasmus.frontla.Loader.LoaderView;

public class LearningAgreementController {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button21;

    @FXML
    private Button button3;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Button homeButton;

    @FXML
    private Button laButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private Button studyButton;

    @FXML
    private Label gender;

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
    void createView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane pane =  LoaderView("SemesterMobility.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void nextView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        //alterar página
        AnchorPane pane =  LoaderView("SemesterMobility2.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("LEARNING AGREEMENT");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void next2View(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        //alterar página
        AnchorPane pane =  LoaderView("SemesterMobility3.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("LEARNING AGREEMENT");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    void next3View(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        //alterar página
        AnchorPane pane =  LoaderView("SemesterMobility4.fxml");
        Scene scene = new Scene(pane);
        stage.setTitle("LEARNING AGREEMENT");
        stage.setScene(scene);
        stage.show();
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("creating buttons");

        // create a button
        Button b = new Button("button");

        // create a stack pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("button not selected");

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText("   button   selected    ");
            }
        };

        // when button is pressed
        b.setOnAction(event);

        // add button
        r.getChildren().add(b);
        r.getChildren().add(l);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }
}

