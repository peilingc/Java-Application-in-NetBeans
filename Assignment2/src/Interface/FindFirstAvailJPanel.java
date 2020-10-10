/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author cosette
 */
public class FindFirstAvailJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FindFirstAvailJPanel
     */
    private CarCatalog carCatalog;
    public FindFirstAvailJPanel(CarCatalog carCatalog) {
        initComponents();
        this.carCatalog = carCatalog;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblFindFirst.getModel();
        dtm.setRowCount(0);
        
        ArrayList<Car> Arr = carCatalog.searchAvail();
        Car car = Arr.get(0);  
        
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
        
        /**set the width of the table columns
        int[] length = {60,60,60,60,60,60,70,70};	
	TableColumnModel model0 = tblFindFirst.getColumnModel();
	for (int i = 0 ; i<model0.getColumnCount() ; i++){
            TableColumn column = model0.getColumn(i);			
            column.setPreferredWidth(length[i]);			
	}
        **/
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFindFirst = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Find The First Available Car");

        tblFindFirst.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFindFirst);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFindFirst;
    // End of variables declaration//GEN-END:variables
}