/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author remo
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bhk
 */
public class Reclamation {
   // private int id,status;
    private String Type,Description, User="ayedboukadida",notification="en cours de traitement" ;
    private int id ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Reclamation(String Type, String Description, int id) {
        this.Type = Type;
        this.Description = Description;
        this.id = id;
    }
      public Reclamation(String Type, String Description,String User,String notification, int id) {
        this.Type = Type;
        this.Description = Description;
        this.id = id;
        this.notification = notification;
        this.User=User ;
    }
     public Reclamation(String notification ,int id) {
        this.notification = notification;
       
        this.id = id;
    }
    public Reclamation(String Type, String Description) {
        this.Type = Type;
        this.Description = Description;
        
    }
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
  

 
    public Reclamation() {
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/
    
    @Override
    public String toString() {
        return "les reclamations{"+" id = "+id+" user = "+User+" notification= "+notification +" type= " + Type + ", description = " + Description +  "\n";
    }
    
    
}
