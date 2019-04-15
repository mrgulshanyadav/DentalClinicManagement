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
 * FXML Controller class
 *
 * @author rohit
 */
public class FXMLRegisterController implements Initializable {

    @FXML private Label label;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private ToggleGroup logintype;
    @FXML private RadioButton logintypeOperator;
    @FXML private RadioButton logintypeDentist;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmpassword;
    @FXML private String username1;
    @FXML private String password1;
    @FXML private String password2;
    @FXML private String type1;
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public FXMLRegisterController(){
        con = ConnectionUtil.connectdb();
    }

    @FXML
    private void loginPage(ActionEvent event) throws IOException {
        Parent login_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));   
        Scene login_scene = new Scene(login_parent);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(login_scene);
        app_stage.show();

    }
    
    @FXML
    private void registerButtonAction(ActionEvent event) {
        
        username1 = username.getText().toString();
        password1 = password.getText().toString();
        password2 = confirmpassword.getText().toString();
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
            label2.setText("Password is Empty");
        }
        if(!password1.equals(password2)){
            label1.setText("Passwords not matching");
        }
        else
        {
            label1.setText("");
        try{
            preparedStatement = con.prepareStatement("SELECT * FROM login WHERE username = ? and type = ?");
            preparedStatement.setString(1,username1);
            preparedStatement.setString(2,type1);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                                label.setText("");
                try{
                    preparedStatement = con.prepareStatement("INSERT INTO login values(?,?,?)");
                    preparedStatement.setString(1,username1);
                    preparedStatement.setString(2,password1);
                    preparedStatement.setString(3,type1);
                    preparedStatement.executeUpdate();
            
                    preparedStatement = con.prepareStatement("SELECT * FROM login WHERE username = ?");
                    preparedStatement.setString(1,username1);
                    resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        System.out.print("Registered");
                        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));   
                        Scene add_patient_scene = new Scene(add_patient_parent);
                        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        app_stage.setScene(add_patient_scene);
                        app_stage.show();
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

            }
            else{
                label.setText("Username already exists");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        }
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
