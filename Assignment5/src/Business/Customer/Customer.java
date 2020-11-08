/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

/**
 *
 * @author PeiLingChiang
 */
public class Customer {
    private String name;
    private String username;
    private int id;
    private static int count = 1;

    public Customer() {
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

    @Override
    public String toString() {
        return name;
    }
    
}
