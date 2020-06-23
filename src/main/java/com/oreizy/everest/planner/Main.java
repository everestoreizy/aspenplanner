/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner;

import com.oreizy.everest.planner.dependencies.JSONRT;
import com.oreizy.everest.planner.structure.TempData;
import static spark.Spark.*;

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
        
        
        get("/boards/:usr/:tag/fn/task-compl", (req, res) -> RouteHandlers.bfnCompleteTask(req, res));
        
        put("/boards/:usr/:tag/fn/task-add", (req, res) -> RouteHandlers.bfnAddTask(req, res));
        
        get("/boards/:usr/:tag/fn/task-rm", (req, res) -> RouteHandlers.bfnRemoveTask(req, res));
        
    }
}
