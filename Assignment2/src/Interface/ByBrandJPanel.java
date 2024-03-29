/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cosette
 */
public class ByBrandJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ByBrandJPanel
     */
    
    private CarCatalog carCatalog;
    private ArrayList<Car> Arr;
    
    public ByBrandJPanel(CarCatalog carCatalog) {
        initComponents();
        this.carCatalog = carCatalog;
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblByBrand.getModel();
        dtm.setRowCount(0);
        String brand = txtBrand.getText();
        Arr = carCatalog.searchBrand(brand);
        //ArrayList<Car> Arr = carCatalog.searchBrand(brand);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtBrand = new javax.swing.JTextField();
        btnFur = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblByBrand = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Cars by Brand");

        txtCity.setEnabled(false);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnFur.setText("Search");
        btnFur.setEnabled(false);
        btnFur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFurActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Further Search by City ");

        tblByBrand.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblByBrand);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(355, 355, 355))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnFur))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSearch))))
                        .addGap(332, 332, 332))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFur)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtBrand.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Please enter a brand!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (carCatalog.searchBrand(txtBrand.getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "There is no car of this brand.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                populateTable();
                txtCity.setEnabled(true);
                btnFur.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed
    
    //Bonus
    private void btnFurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFurActionPerformed
        // TODO add your handling code here:
        if (txtCity.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Please enter a city!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (carCatalog.searchCity(txtCity.getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "There is no car in this city.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                String city = txtCity.getText();
                ArrayList<Car> newArr = new ArrayList<Car>();
                for (Car car:Arr){
                    if (car.getCity().equals(city))
                        newArr.add(car);
                }
        
                DefaultTableModel dtm1 = (DefaultTableModel)tblByBrand.getModel();
                dtm1.setRowCount(0);
                for (Car car: newArr){    
                    Object row[] = new Object[8];
                    row[0] = car;
                    row[1] = car.getModelNum();
                    row[2] = car.getCity();
                    row[3] = car.isAvailable();
                    row[4] = car.getManufactureYear();
                    row[5] = car.getSeats();
                    row[6] = car.getCertExpriedDate();
                    row[7] = car.getSerialNum();
                    dtm1.addRow(row);
                }
            }
        }
    }//GEN-LAST:event_btnFurActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFur;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblByBrand;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    // End of variables declaration//GEN-END:variables
}
