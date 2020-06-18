/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.structure;

/**
 *
 * @author eoreizy
 */
public class User {
    
    //public int userId;
    public String username; //Usernames should be noncase sensitive and always stored as lowercase
    public String email;
    public int pin;
    public String hash;
    
    public User(String _username, String _email, int _pin){
        //this.userId = _userId;
        this.username = _username.toLowerCase();
        this.email = _email;
        this.pin = _pin;
    }
    
    public UserTX toUserTX(){
        return new UserTX(this.username, this.email);
    }
    
}
