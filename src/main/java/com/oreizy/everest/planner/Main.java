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
        port(80);

        staticFiles.location("/");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("ip", req.ip());
            return new FreeMarkerEngine().render(new ModelAndView(model, "index.html"));
        });

        get("/string", (req, res) -> {
            return "Hello world!";
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
            return new String();
        });

        get("/board/:id", (req, res) -> {
            String boardId = req.params(":id");

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

            return new FreeMarkerEngine().render(new ModelAndView(model, "board.html"));
        });
    }
}
