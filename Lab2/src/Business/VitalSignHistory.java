/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.util.ArrayList;

/**
 *
 * @author cosette
 */
public class VitalSignHistory {
    private ArrayList<VitalSigns> VitalSignHistory;
    
    public VitalSignHistory(){
        VitalSignHistory = new ArrayList<VitalSigns> ();
        
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return VitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> VitalSignHistory) {
        this.VitalSignHistory = VitalSignHistory;
    }
    
    public VitalSigns addVitals(){
    VitalSigns vs = new VitalSigns();
    VitalSignHistory.add(vs);
    return vs;
    }
    
    public void deleteVitals(VitalSigns v){
    VitalSignHistory.remove(v);
    }
    
}

