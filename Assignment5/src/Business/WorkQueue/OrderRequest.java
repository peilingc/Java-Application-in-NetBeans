/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.DeliveryMan.DeliveryMan;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class OrderRequest extends WorkRequest{
    private String orderItem;
    private DeliveryMan deliveryMan;

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
    
    public String getOrderItem(){
        return orderItem;
    }
    
    public void setOrderItem(String orderItem){
        this.orderItem = orderItem;
    }
}
