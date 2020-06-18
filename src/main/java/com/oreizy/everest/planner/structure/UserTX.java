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
public class UserTX {
    
    public String username;
    public String email;
    //add Something so that the User can be found with just the userTX
    //i guess that would be the username because each username will be unique
    
    public UserTX(String _username, String _email){
        this.username = _username;
        this.email = _email;
    }
    
}
