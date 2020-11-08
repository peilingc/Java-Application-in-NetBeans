/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Restaurant.RestaurantDirectory;
import Business.Restaurant.RestaurantManagerDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private RestaurantManagerDirectory restaurantManagerDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    
    public EcoSystem(RestaurantDirectory restaurantDirectory, RestaurantManagerDirectory restaurantManagerDirectory, CustomerDirectory customerDirectory, DeliveryManDirectory deliveryManDirectory) {

        this.restaurantDirectory = restaurantDirectory;
        this.restaurantManagerDirectory = restaurantManagerDirectory;
        this.customerDirectory = customerDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
    }
    
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    private EcoSystem(){
        super(null);
        restaurantDirectory = new RestaurantDirectory();
        restaurantManagerDirectory =  new RestaurantManagerDirectory(restaurantDirectory);
        customerDirectory = new CustomerDirectory();
        deliveryManDirectory = new DeliveryManDirectory();
       // networkList=new ArrayList<Network>();
    }

    public boolean checkIfUserIsUnique(String userName){
       return (this.getUserAccountDirectory().checkIfUsernameIsUnique(userName));
    }
    
    public RestaurantDirectory getRestaurantDirectory(){
        return this.restaurantDirectory;
    }
    
    public RestaurantManagerDirectory getRestaurantManagerDirectory(){
        return this.restaurantManagerDirectory;
    }
    
    public CustomerDirectory getCustomerDirectory(){
        return this.customerDirectory;
    }
    
    public DeliveryManDirectory getDeliveryManDirectory(){
        return this.deliveryManDirectory;
    }
}
