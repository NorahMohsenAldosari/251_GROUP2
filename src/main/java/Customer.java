/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.main;

/**
 *
 * @author ragha
 */
public class Customer {
      private String name;
        private String phone;
        

    public Customer() {
        this.name = "Not booked";
        this.phone="None";
    }

    public Customer(String name ,String phone) {
        this.name = name;
         this.phone=phone;
    }

    public String getName() {
        return name;
    }
 public String getPhone() {
        return phone;
    }
   public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    } 
}

    

