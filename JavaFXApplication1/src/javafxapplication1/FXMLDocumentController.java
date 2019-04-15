/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author rohit
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private ToggleGroup logintype;
    @FXML private RadioButton logintypeOperator;
    @FXML private RadioButton logintypeDentist;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private String username1;
    @FXML private String password1;
    @FXML private String type1;
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public FXMLDocumentController(){
        con = ConnectionUtil.connectdb();
    }
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        username1 = username.getText().toString();
        password1 = password.getText().toString();
        label.setText("");
        label1.setText("");
        label2.setText("");
        if(logintypeOperator.isSelected()){
            type1 = "operator";
        }
        if(logintypeDentist.isSelected()){
            type1 = "dentist";
        }
        if(username1.isEmpty()){
            label.setText("Username is Empty");
        }
        if(password1.isEmpty()){
            label1.setText("Password is Empty");
        }
        else
        {
        try{
            label.setText("");
            preparedStatement = con.prepareStatement("SELECT * FROM login WHERE username = ? and password = ? and type = ?");
            preparedStatement.setString(1,username1);
            preparedStatement.setString(2,password1);
            preparedStatement.setString(3,type1);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));   
                Scene home_scene = new Scene(home_parent);
                Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                app_stage.setScene(home_scene);
                app_stage.show();
            }
            else{
            label2.setText("Username and Password Doesn't Exists");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    
    @FXML
    private void registerNewAccount(ActionEvent event) throws IOException {
        Parent register_parent = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));   
        Scene register_scene = new Scene(register_parent);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(register_scene);
        app_stage.show();

    }

    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}
