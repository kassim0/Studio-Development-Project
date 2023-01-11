package erasmus.frontla.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static erasmus.frontla.Loader.LoaderView;

public class LoginController {

    Connection connection;
    String jdbcURL = "jdbc:mysql://localhost:3306/learningagreementdb";
    String username = "root";
    String password = "";

    @FXML
    private Button createAnAccountButton;

    @FXML
    private TextField emailInput;

    @FXML
    private Button homeButton;

    @FXML
    private Button laButton;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button studyButton;

    @FXML
    private Label studyp;

    @FXML
    protected void login(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT * FROM users WHERE email='"+emailInput.getText()+"' AND password='"+passwordInput.getText()+"'";
            ResultSet resultSet =statement.executeQuery(sql);

            int rows =0;

            if (resultSet.last()) {
                rows = resultSet.getRow();
                resultSet.beforeFirst();
            }

            if(rows==0){
                System.out.println("Connection failed");
            }
            else{
                System.out.println("Connection success");
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            System.out.println(e);
        }
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

}
