/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.dependencies;

import com.oreizy.everest.planner.structure.Board;
import com.oreizy.everest.planner.structure.User;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author eoreizy
 */
public class HTMLRender {
    
    Object data;
    
    public HTMLRender(Object _data){
        this.data = _data;
    }
    
    public String render(){
        String cx = this.data.getClass().getName();
        System.out.println("I figured out that this data was of class " + cx);
        
        switch(cx){
                case "com.oreizy.everest.planner.structure.Board":   return renderBoard( (Board) data );
                case "com.oreizy.everest.planner.structure.User":    return renderUser( (User) data);
                default:   return null;
        }
    }
    
    private String renderBoard(Board data){
        Map<String, Object> map = new HashMap<>();
        
        map.put("Board_Data", new String("STUFF")); //put MY rendered HTML in there
        map.put("Board_Title", data.title);
        map.put("Username", data.owner.username);
        map.put("Board_Tag", data.tag);
        
        return modelToEngine(map, "board.html"); //template for 'outside' of page with header, footer, etc.
        
    }
    
    private String renderUser(User data){
        return "well at least it's a User";
    }
    
    static String modelToEngine(Map<String, Object> model, String template){
        return new FreeMarkerEngine().render(new ModelAndView(model, template));
    }
    
}
