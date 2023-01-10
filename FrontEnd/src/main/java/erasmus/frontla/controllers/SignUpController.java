package erasmus.frontla.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpController {

    Connection connection;
    String jdbcURL = "jdbc:mysql://localhost:3306/learningagreementdb";
    String username = "root";
    String password = "";
    int test=0;

    @FXML
    private Button createAnAccountButton;

    @FXML
    private DatePicker dateOfBirthInput;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField facultyInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private Button homeButton;

    @FXML
    private Button laButton;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField nationalityIput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField repeatPasswordInput;

    @FXML
    private ChoiceBox<String> roleChoice;

    @FXML
    private Button studyButton;

    @FXML
    private TextField studyCycleInput;

    @FXML
    private Label studyp;

    @FXML
    protected void register(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users (first_name,last_name,email,date_of_birth,nationality,faculty,cycle_study,role,password) VALUES ('"+firstNameInput.getText()+"','"+lastNameInput.getText()+"','"+emailInput.getText()+"','"+dateOfBirthInput.getValue()+"','"+nationalityIput.getText()+"','"+facultyInput.getText()+"','"+studyCycleInput.getText()+"','"+roleChoice.getValue()+"','"+passwordInput.getText()+"')";
            statement.executeUpdate(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void homeView(ActionEvent event) {

    }

    @FXML
    void laView(ActionEvent event) {

    }

    @FXML
    void studyView(ActionEvent event) {

    }

}


