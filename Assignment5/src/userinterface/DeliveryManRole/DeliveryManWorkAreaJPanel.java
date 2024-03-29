/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DeliveryManRole;

import Business.EcoSystem;
import Business.Restaurant.RestaurantManager;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class DeliveryManWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    
    public DeliveryManWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.system = system;
        populateTable();
    }
    
    public void populateTable(){
        for(OrderRequest or : userAccount.getWorkQueue().getOrderRequestList()){
            DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
            
            for(RestaurantManager rm : system.getRestaurantManagerDirectory().getRestaurantManagerList()){
                if (rm.getUsername().equals(or.getReceiver().getUsername())){
                    row[0] = rm.getRestaurant();
                }
            }
            
            row[1] = or.getSender().getUsername();
            row[2] = or.getStatus();
            row[3] = or.getRequestDate();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnFinish = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Restaurant", "Customer", "Status", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 58, 570, 150));

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        // TODO add your handling code here:
        int row = tblOrder.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tblOrder.getValueAt(row, 2).equals("Finished")){
            JOptionPane.showMessageDialog(null, "The order has already finished!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        for (OrderRequest or : userAccount.getWorkQueue().getOrderRequestList()){
            if (or.getRequestDate() == tblOrder.getValueAt(row, 3)){
                or.setStatus("Finished");
                populateTable();
            }
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
