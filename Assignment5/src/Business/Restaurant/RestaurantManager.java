/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

/**
 *
 * @author PeiLingChiang
 */
public class RestaurantManager {
    private String name;
    private String username;
    private int id;
    private static int count = 1;
    private Restaurant restaurant;
    
    public RestaurantManager() {
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
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getUsername() {
        return username;
    }
    
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    
    public Restaurant getRestaurant(){
        return restaurant;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
