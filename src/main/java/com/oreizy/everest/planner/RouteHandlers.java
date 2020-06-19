/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner;

import com.oreizy.everest.planner.dependencies.HTMLRender;
import com.oreizy.everest.planner.structure.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author eoreizy
 */
public class RouteHandlers {
    
    static String indexRequest(spark.Request req, spark.Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("ip", req.ip());
        return modelToEngine(model, "index.html");
    }
    
    static String boardStaticRequest(spark.Request req, spark.Response res){
        String boardId = "7";

        //would get stuff from db instead of static arrays
        String[] listNames = new String[]{
            "Monday 13",
            "Tuesday 14",
            "Wednesday 15",
            "Thursday 16",
            "Friday 17"
        };

        String[] listItems = new String[]{
            "Open NetBeans",
            "Write some code",
            "Have a quarantine party time",
            "Try out what really long Strings do to my website. Will it break or survive?",
            "Drink water - hydrate or diedrate!"
        };

        String boardTitle = "My Awesome Board";



        //put it in the model and render
        Map<String, Object> model = new HashMap<>();
        model.put("Board_Id", boardId);
        model.put("Board_Title", boardTitle);

        for (int i = 0; i < listNames.length; i++) {
            model.put("List_Title_" + i, listNames[i]);
        }

        for (int i = 0; i < listItems.length; i++) {
            model.put("Item_Text_" + i, listItems[i]);
        }

        return modelToEngine(model, "board_html/board_static.html");
    }
    
    static String boardRequest(spark.Request req, spark.Response res){
        Board b = boardDataRequest(req, res);
        
        HTMLRender html = new HTMLRender(b);
        
        return html.render();
        
    }
    
    static Board boardDataRequest(Request req, Response res) {
        String user = req.params(":usr");
        String tag = req.params(":tag");
        
        return TempData.findBoard(user, tag); 
    }
    
    static String sayHello(String what){
        return "Hello, " + what;
    }
    
    


    static String bfnCompleteTask(Request req, Response res) {
        String username = req.params(":usr");
        String boardTag = req.params(":tag");
        int timeslotId = Integer.parseInt(req.queryParams("ts"));
        int taskId = Integer.parseInt(req.queryParams("id"));
        
        TempData.findTask(username, boardTag, timeslotId, taskId).toggleCompletion();
        
        return "done";
        
    }

    static String modelToEngine(Map<String, Object> model, String template){
        return new FreeMarkerEngine().render(new ModelAndView(model, template));
    }

    static String imageRequest(Request req, Response res) {
        return "/src/main/resources/images/" + req.params(":img");
    }
    
}
