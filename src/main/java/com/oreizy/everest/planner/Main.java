/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author eoreizy
 */
public class Main {
    public static void main(String[] args) {
        port(4567);
        
        staticFiles.location("/");
        
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("ip", req.ip());
            return new FreeMarkerEngine().render(new ModelAndView(model, "index.ftl"));
        });
        
        get("/internals/add/task", (req, res) -> {
            String text = req.queryParams("content");
            String listId = req.queryParams("list_id");
            String tag = req.queryParams("tag_id");
            
            //do all my fancy db stuff
            
            return "added task with " + text + " to list " + listId + " with tag " + tag;
            
        });
        
        get("/internals/get/tasks", (req, res) -> {
            String listId = req.queryParams("list_id");
            
            //do all my db stuff
            
            return "getting tasks";
        })
    }
}
