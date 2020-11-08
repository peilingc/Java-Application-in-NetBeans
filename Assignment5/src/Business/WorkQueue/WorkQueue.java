/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<OrderRequest> orderRequestList;

    public WorkQueue() {
        orderRequestList = new ArrayList();
    }

    public ArrayList<OrderRequest> getOrderRequestList() {
        return orderRequestList;
    }
}