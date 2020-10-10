/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.CustomerDirectory;
import java.util.Date;

/**
 *
 * @author AEDSpring2019
 */
public class Customer extends User implements Comparable<Customer>{
    private CustomerDirectory directory;
    private Date createdOn;
    
    public Customer(String password, String userName) {
        super(password, userName, "CUSTOMER");
        directory = new CustomerDirectory();
        this.createdOn = new Date();
    }

    
    
    public CustomerDirectory getDirectory() {
        return directory;
    }

    public void setDirectory(CustomerDirectory directory) {
        this.directory = directory;
    }

    @Override
    public int compareTo(Customer o) {
        return o.getUserName().compareTo(this.getUserName());
    }

    @Override
    public String toString() {
        return getUserName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verify(String password){
        if(password.equals(getPassword()))
            return true;
        return false;
    }
    
    public Date getCreatedOn(){
        return createdOn;
    }
}
