/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class Restaurant {
    private String name;
    private int id;
    private static int count = 1;
    private ArrayList<String> menu;
    private RestaurantManager rm;
    

    public Restaurant() {
        menu = new ArrayList<String>();
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }
    
    public void setMenu(ArrayList<String> menu){
        this.menu = menu;
    }
    
    public ArrayList<String> getMenu(){
        return menu;
    }

    public RestaurantManager getRm() {
        return rm;
    }

    public void setRm(RestaurantManager rm) {
        this.rm = rm;
    }
    

    @Override
    public String toString() {
        return name;
    }
}
