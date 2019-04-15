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
public class ModelTable4 {
    
    String billid,dentistname,billdate,patientname,treatments,billtotal;

    public ModelTable4() {
    }

    public ModelTable4(String billid, String dentistname, String billdate, String patientname, String treatments, String billtotal) {
        this.billid = billid;
        this.dentistname = dentistname;
        this.billdate = billdate;
        this.patientname = patientname;
        this.treatments = treatments;
        this.billtotal = billtotal;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getDentistname() {
        return dentistname;
    }

    public void setDentistname(String dentistname) {
        this.dentistname = dentistname;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getBilltotal() {
        return billtotal;
    }

    public void setBilltotal(String billtotal) {
        this.billtotal = billtotal;
    }
    
    
}
