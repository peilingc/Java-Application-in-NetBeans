/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Car;
import Business.CarCatalog;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cosette
 */
public class SerialNumJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SerialNumJPanel
     */
   
    private CarCatalog carCatalog;
    
    public SerialNumJPanel(CarCatalog carCatalog) {
        initComponents();
        this.carCatalog = carCatalog;
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblSerialNum.getModel();
        dtm.setRowCount(0);
        String serialNum = txtSerialNum.getText();
        ArrayList<Car> Arr = carCatalog.searchSerialNum(serialNum);
        for (Car car: Arr){
                Object row[] = new Object[8];
                row[0] = car;
                row[1] = car.getModelNum();
                row[2] = car.getCity();
                row[3] = car.isAvailable();
                row[4] = car.getManufactureYear();
                row[5] = car.getSeats();
                row[6] = car.getCertExpriedDate();
                row[7] = car.getSerialNum();
                dtm.addRow(row); 
        }
    }
    
    public boolean isInteger( String input ){ 
        try { 
            Integer.parseInt( input ); 
            return true; 
        } 
        catch( Exception e ) {  
            JOptionPane.showMessageDialog(null, "Please enter numbers!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false ;
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSerialNum = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSerialNum = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Search by Serial Number");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblSerialNum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand", "Model Num.", "City", "Availability", "YOM", "Seats", "Cert. Exp.", "Serial Num."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSerialNum);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSerialNum, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addGap(332, 332, 332))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(293, 293, 293))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerialNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtSerialNum.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Please enter a serial number!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if (isInteger(txtSerialNum.getText())){
            if (carCatalog.searchSerialNum(txtSerialNum.getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "There is no car for this serial number.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                populateTable();
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSerialNum;
    private javax.swing.JTextField txtSerialNum;
    // End of variables declaration//GEN-END:variables
}
