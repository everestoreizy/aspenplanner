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
    
    public int userId;
    public String username;
    public String email;
    public int pin;
    
    public User(int _userId, String _username, String _email, int _pin){
        this.userId = _userId;
        this.username = _username;
        this.email = _email;
        this.pin = _pin;
    }
    
}
