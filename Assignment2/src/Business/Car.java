/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.time.LocalDate; 

/**
 *
 * @author cosette
 */
public class Car {
    
    
    //attributes
    private String serialNum;
    private String brand;
    private String modelNum;
    private String city;
    private boolean availability;
    private String manufactureYear;
    private int seats;
    private LocalDate certExpriedDate;
    
    //constructor
    public Car(String serialNum, String brand, String modelNum, String city, boolean availability,
               String manufactureYear, int seats, LocalDate certExpriedDate ){
        this.serialNum = serialNum;
        this.brand = brand;
        this.modelNum = modelNum;
        this.city = city;
        this.availability = availability;
        this.manufactureYear = manufactureYear;
        this.seats = seats;
        this.certExpriedDate = certExpriedDate;
    }
    
    public Car(){
    }
    
    //getter and setter
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public LocalDate getCertExpriedDate() {
        return certExpriedDate;
    }

    public void setCertExpriedDate(LocalDate certExpriedDate) {
        this.certExpriedDate = certExpriedDate;
    }
    
    //override
    @Override
    public String toString(){
        return this.brand;
    }
    
    
}
