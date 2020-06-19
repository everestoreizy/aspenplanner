/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner;

import com.oreizy.everest.planner.dependencies.HTMLRender;
import com.oreizy.everest.planner.dependencies.JSONRT;
import com.oreizy.everest.planner.structure.TempData;
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
        port(5000);

        staticFiles.location("/");
        
        TempData.addExamples();

        get("/", (req, res) -> RouteHandlers.indexRequest(req, res));

        get("/hello", (req, res) -> RouteHandlers.sayHello("world!"));

        get("/boards/:usr/:tag", (req, res) -> RouteHandlers.boardRequest(req, res));
        
        get("/boards-data/:usr/:tag", (req, res) -> RouteHandlers.boardDataRequest(req, res), new JSONRT());
        
        get("/boards-static", (req, res) -> RouteHandlers.boardStaticRequest(req, res)); //not working right now
        
        get("/users/all", "application/json", (req, res) -> TempData.users, new JSONRT());
        
        get("/boards-all", "application/json", (req, res) -> TempData.boards, new JSONRT());
    }
}
