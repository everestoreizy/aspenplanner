/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.structure;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author eoreizy
 */
public class TempData {
    
    //public static ArrayList<Task> tasks = new ArrayList<Task>();
    public static ArrayList<Board> boards = new ArrayList<Board>();
    public static ArrayList<User> users = new ArrayList<User>();
    //public static ArrayList<Timeslot> timeslots = new ArrayList<Timeslot>();
    
    public static void addExamples(){
        
        User tu = new User("everest-oreizy", "everest@oreizy.com", 123456);
        
        Timeslot ts1 = new Timeslot(new Date(2020, 6, 18), "Summer day 1");
        
        ts1.tasks.add(new Task("Work in NetBeans"));
        ts1.tasks.add(new Task("Type some stuff"));
        ts1.tasks.add(new Task("Shoot some video"));
        ts1.tasks.add(new Task("Charge my phone"));
        
        Timeslot ts2 = new Timeslot(new Date(2020, 6, 19), "Summer day 2");
        
        ts2.tasks.add(new Task("Play some NSMBU"));
        ts2.tasks.add(new Task("Do something nice for Mom and Dad's anniversary"));
        ts2.tasks.add(new Task("Listen to music"));
        ts2.tasks.add(new Task("Connect bluetooth devices"));
        
        Timeslot ts3 = new Timeslot(new Date(2020, 6, 19), "Summer day 2 after dinner");
        
        ts3.tasks.add(new Task("Bake a cake"));
        ts3.tasks.add(new Task("Read a book"));
        ts3.tasks.add(new Task("Make a yummy dessert for the family"));
        
        ArrayList<Timeslot> tsx = new ArrayList<Timeslot>();
        tsx.add(ts1);
        tsx.add(ts2);
        tsx.add(ts3);
        
        boards.add(new Board("General tasks", tu.toUserTX(), tsx));
        
        
        
        users.add(tu);
        
    }
    
    public static Board findBoard(String username, String tag){
        for(Board b : TempData.boards){
            if(b.owner.username.equals(username) && b.tag.equals(tag)){
                return b;
            }
        }
        return null;
    }
    
    public static Timeslot findTimeslot(String username, String tag, int timeslotId){
        return findBoard(username, tag).timeslots.get(timeslotId);
    }
    
    public static Task findTask(String username, String tag, int timeslotId, int taskId){
        return findTimeslot(username, tag, timeslotId).tasks.get(taskId);
    }
    
}
