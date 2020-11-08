/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PeiLingChiang
 */
public class RestaurantManagerDirectory {
    private ArrayList<RestaurantManager> restaurantManagerList;
    private RestaurantDirectory rd;

    public RestaurantManagerDirectory(RestaurantDirectory rd) {
        restaurantManagerList = new ArrayList<RestaurantManager>();
        this.rd = rd; 
    }

    public ArrayList<RestaurantManager> getRestaurantManagerList() {
        return restaurantManagerList;
    }
    
    public RestaurantManager createRestaurantManager(String name, String username, String restaurantName){
        // create rm
        RestaurantManager restaurantManager = new RestaurantManager();
        restaurantManager.setName(name);
        restaurantManager.setUsername(username);
        
        // create restaurant
        
        Restaurant newR = rd.createRestaurant(restaurantName, new ArrayList<String>());
        restaurantManager.setRestaurant(newR);
        newR.setRm(restaurantManager);
        
        restaurantManagerList.add(restaurantManager);
        return restaurantManager;
    }
    
}
