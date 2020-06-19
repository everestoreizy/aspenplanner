/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.dependencies;

import com.oreizy.everest.planner.structure.Board;
import com.oreizy.everest.planner.structure.Task;
import com.oreizy.everest.planner.structure.Timeslot;
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
        
        switch(cx){
                case "com.oreizy.everest.planner.structure.Board":   return renderBoard( (Board) data );
                case "com.oreizy.everest.planner.structure.User":    return renderUser( (User) data);
                default:   return null;
        }
    }
    
    private String renderBoard(Board data){
        String boardHTML = "";
        
        System.out.println("Rendering board " + data.owner.username + "/" + data.tag);
        
        
        for(Timeslot ts : data.timeslots){
            
            String tasksHTML = "";
            
            for(Task ta : ts.tasks){
                
                Map<String, Object> taskMap = new HashMap<>();
                taskMap.put("Item_Content", ta.title);
                taskMap.put("Image_Src", (ta.isComplete ? "filled" : "unfilled"));
                taskMap.put("Image_Alt", (ta.isComplete ? "complete" : "incomplete"));
                taskMap.put("Timeslot_Id", data.timeslots.indexOf(ts));
                taskMap.put("Item_Id", ts.tasks.indexOf(ta));
                
                
                tasksHTML += modelToEngine(taskMap, "board_html/item.html");
                
            }
            
            Map<String, Object> timeslotMap = new HashMap<>();
            timeslotMap.put("List_Title", ts.title);
            timeslotMap.put("List_Content", tasksHTML);
            timeslotMap.put("Timeslot_Id", data.timeslots.indexOf(ts));
            boardHTML += modelToEngine(timeslotMap, "board_html/list.html");
        }
        
        
        Map<String, Object> map = new HashMap<>();
        map.put("Board_Data", boardHTML);
        map.put("Board_Title", data.title);
        map.put("Username", data.owner.username);
        map.put("Board_Tag", data.tag);
        
        
        return modelToEngine(map, "board_html/board.html");
        
    }
    
    private String renderUser(User data){
        return "well at least it's a User";
    }
    
    static String modelToEngine(Map<String, Object> model, String template){
        return new FreeMarkerEngine().render(new ModelAndView(model, template));
    }
    
    
    
}
