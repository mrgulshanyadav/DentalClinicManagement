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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rohit
 */
public class FXMLAddAppointmentController implements Initializable {
        @FXML MenuBar myMenuBar;
        
    @FXML private TextField appointmentid;
    @FXML private TextField patientid;
    @FXML private TextField patientname;
    @FXML private TextField appointmentdate;
    @FXML private TextField appointmenttime;
    @FXML private TextField requesttreatment;
    @FXML private ChoiceBox dentistname;
    
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public FXMLAddAppointmentController(){
        con = ConnectionUtil.connectdb();
    }

    @FXML
    private void logoutButtonAction(ActionEvent event) throws IOException {
        Parent login_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));   
        Scene login_scene = new Scene(login_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(login_scene);
        app_stage.show();

    }
    
    @FXML
    private void updatepatientButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLUpdatePatient.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();

    }
    
    @FXML
    private void addpatientButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLAddPatient.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();

    }

    @FXML
    private void adddentistButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLAddDentist.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();

    }
    @FXML
    private void updatedentistButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLUpdateDentist.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void addappointmentButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLAddAppointment.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void updateappointmentButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLUpdateAppointment.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void addtreatmentButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLAddTreatment.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void updatetreatmentButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLUpdateTreatment.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void addbillButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLAddBill.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void updatebillButtonAction(ActionEvent event) throws IOException {
        Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLUpdateBill.fxml"));   
        Scene add_patient_scene = new Scene(add_patient_parent);
        Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
        app_stage.setScene(add_patient_scene);
        app_stage.show();
    }
    @FXML
    private void saveAppointment(ActionEvent event){
        try{
            preparedStatement = con.prepareStatement("INSERT INTO appointment values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(appointmentid.getText().toString()));
            preparedStatement.setString(2,patientid.getText().toString());
            preparedStatement.setString(3,patientname.getText().toString());
            preparedStatement.setString(4,appointmentdate.getText().toString());
            preparedStatement.setString(5,appointmenttime.getText().toString());
            preparedStatement.setString(6,requesttreatment.getText().toString());
            preparedStatement.setString(7,dentistname.getValue().toString());
            preparedStatement.executeUpdate();
            
            preparedStatement = con.prepareStatement("SELECT * FROM appointment WHERE appointmentid = ?");
            preparedStatement.setInt(1,Integer.parseInt(appointmentid.getText().toString()));
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.print("Saved");
                Parent add_patient_parent = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));   
                Scene add_patient_scene = new Scene(add_patient_parent);
                Stage app_stage = (Stage)((Node)myMenuBar).getScene().getWindow();
                app_stage.setScene(add_patient_scene);
                app_stage.show();

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
