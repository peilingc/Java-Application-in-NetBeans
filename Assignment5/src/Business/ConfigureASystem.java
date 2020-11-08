package Business;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantManager;
import Business.Role.*;

/**
 *
 * @author PeiLingChiang
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //create system admin 
        Employee employee = system.getEmployeeDirectory().createEmployee("PLC");
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        
        //create some customers
        Customer customer1 = system.getCustomerDirectory().createCustomer("Alex", "alexander39");
        Customer customer2 = system.getCustomerDirectory().createCustomer("Anita", "anita57");
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("alexander39", "alexander39", employee, new CustomerRole());
        UserAccount ua3 = system.getUserAccountDirectory().createUserAccount("anita57", "anita57", employee, new CustomerRole());
        
        //create some delivery men
        DeliveryMan deliveryman1 = system.getDeliveryManDirectory().createDeliveryMan("Ted", "ted11");
        DeliveryMan deliveryman2 = system.getDeliveryManDirectory().createDeliveryMan("Cindy", "cindy11");
        UserAccount ua4 = system.getUserAccountDirectory().createUserAccount("ted11", "ted11", employee, new DeliveryManRole());
        UserAccount ua5 = system.getUserAccountDirectory().createUserAccount("cindy11", "cindy11", employee, new DeliveryManRole());
        
        //create some restaurant managers
        RestaurantManager restaurantManager1 = system.getRestaurantManagerDirectory().createRestaurantManager("Wendy", "wendy22", "Wendy's");
        RestaurantManager restaurantManager2 = system.getRestaurantManagerDirectory().createRestaurantManager("Sam", "sam22", "KFC");
        UserAccount ua6 = system.getUserAccountDirectory().createUserAccount("wendy22", "wendy22", employee, new AdminRole());
        UserAccount ua7 = system.getUserAccountDirectory().createUserAccount("sam22", "sam22", employee, new AdminRole());
        
        
        /**
        //create some restaurants with menu
        String[] menu1 = new String[]{"Fried Chicken", "Nuggets", "Sandwich"};
        String[] menu2 = new String[]{"French Fried", "McChicken", "Big Mac"};
        String[] menu3 = new String[]{"Dave's Single", "Croissant", "French Fries"};
        Restaurant restaurant1 = system.getRestaurantDirectory().createRestaurant("KFC", menu1);
        Restaurant restaurant2 = system.getRestaurantDirectory().createRestaurant("McDonalds", menu2);
        Restaurant restaurant3 = system.getRestaurantDirectory().createRestaurant("Wendy's", menu3);
        **/
        
        
  
        return system;
    }
    
}
