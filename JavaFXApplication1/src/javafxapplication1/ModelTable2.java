/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author rohit
 */
public class ModelTable2 {
    
    String appointmentid,patientid,patientname,appointmentdate,appointmenttime,requesttreatment,dentistname;

    public ModelTable2() {
    }

    public ModelTable2(String appointmentid, String patientid, String patientname, String appointmentdate, String appointmenttime, String requesttreatment, String dentistname) {
        this.appointmentid = appointmentid;
        this.patientid = patientid;
        this.patientname = patientname;
        this.appointmentdate = appointmentdate;
        this.appointmenttime = appointmenttime;
        this.requesttreatment = requesttreatment;
        this.dentistname = dentistname;
    }

    public String getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public String getRequesttreatment() {
        return requesttreatment;
    }

    public void setRequesttreatment(String requesttreatment) {
        this.requesttreatment = requesttreatment;
    }

    public String getDentistname() {
        return dentistname;
    }

    public void setDentistname(String dentistname) {
        this.dentistname = dentistname;
    }
    
    
}
