/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner;

import com.oreizy.everest.planner.dependencies.JSONRT;
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

        get("/", (req, res) -> RouteHandlers.indexRequest(req, res));

        get("/hello", (req, res) -> RouteHandlers.sayHello("world!"));

        get("/board/:id", (req, res) -> RouteHandlers.boardRequest(req, res));
        
        get("/tasks/all", "application/json", (req, res) -> RouteHandlers.tasksRequest(req, res), new JSONRT());
        
        get("/users/all", "application/json", (req, res) -> RouteHandlers.nothing(req, res), new JSONRT());
        
        get("/boards/all", "application/json", (req, res) -> RouteHandlers.nothing(req, res), new JSONRT());
    }
}
