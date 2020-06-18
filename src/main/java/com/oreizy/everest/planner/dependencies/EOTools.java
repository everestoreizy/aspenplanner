/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose EOTools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.dependencies;

/**
 *
 * @author eoreizy
 */
public class EOTools {
    
    public static String nameToTag(String name){
        return name.toLowerCase()
                .replaceAll(" ", "-")
                .replaceAll("[^a-zA-Z0-9-]", "_");
    }
    
}
