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
public class ModelTable3 {
    
    String treatmentid,treatmentname,treatmentamount;

    public ModelTable3() {
    }

    public ModelTable3(String treatmentid, String treatmentname, String treatmentamount) {
        this.treatmentid = treatmentid;
        this.treatmentname = treatmentname;
        this.treatmentamount = treatmentamount;
    }

    public String getTreatmentid() {
        return treatmentid;
    }

    public void setTreatmentid(String treatmentid) {
        this.treatmentid = treatmentid;
    }

    public String getTreatmentname() {
        return treatmentname;
    }

    public void setTreatmentname(String treatmentname) {
        this.treatmentname = treatmentname;
    }

    public String getTreatmentamount() {
        return treatmentamount;
    }

    public void setTreatmentamount(String treatmentamount) {
        this.treatmentamount = treatmentamount;
    }
    
    
}
