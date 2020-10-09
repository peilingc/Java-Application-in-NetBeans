/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.lang.String;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author cosette
 */
public class CarCatalog {
    private LocalDateTime lastUpdatedTime;
    private ArrayList<Car> carList;
    
    public CarCatalog(){
        this.carList = new ArrayList<Car>();
        this.lastUpdatedTime = LocalDateTime.now();
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }
    
    public Car addCar(){
        this.lastUpdatedTime = LocalDateTime.now();
        Car car = new Car();
        carList.add(car);
        return car;
    } 
    
    public ArrayList<Car> searchAvail(){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.isAvailable()) 
                Arr.add(car); 
        }
        return Arr;
    }
    
    public ArrayList<Car> searchUnavail(){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(!car.isAvailable()) 
                Arr.add(car);  
        }
        return Arr;
    }
    
    public ArrayList<Car> searchYear(String year){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getManufactureYear().equals(year) ) 
                Arr.add(car);
        }
        return Arr;
    }
    
    public ArrayList<Car> searchBrand(String brand){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getBrand().equals(brand)) 
                Arr.add(car);  
        }
        return Arr;
    }
    
    public ArrayList<Car> searchSeats(int min, int max){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getSeats() >= min & car.getSeats() <= max & car.isAvailable()) 
                Arr.add(car);
        }
        return Arr;
    }
    
    public ArrayList<Car> searchSerialNum(String serialNum){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getSerialNum().equals(serialNum) ) 
                Arr.add(car);
        }
        return Arr;
    }
    
    public ArrayList<Car> searchModelNum(String modelNum){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getModelNum().equals(modelNum) ) 
                Arr.add(car);
        }
        return Arr;
    }
    
    public ArrayList<Car> searchCity(String city){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getCity().equals(city) & car.isAvailable()) 
                Arr.add(car);   
        }
        return Arr;
    }
    
    public ArrayList<Car> searchExpCert(){
        ArrayList<Car> Arr = new ArrayList<Car>();
        for(Car car: carList){
            if(car.getCertExpriedDate().isBefore(LocalDate.now())) 
                Arr.add(car);   
        }
        return Arr;
    }
  
    
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }
    
}
