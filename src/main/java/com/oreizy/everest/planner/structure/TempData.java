/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.structure;

import java.util.ArrayList;

/**
 *
 * @author eoreizy
 */
public class TempData {
    
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    public static ArrayList<Board> boards = new ArrayList<Board>();
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Timeslot> timeslots = new ArrayList<Timeslot>();
    
    public static void addExamples(){
        tasks.add(new Task(0, "Work in NetBeans", 0));
        tasks.add(new Task(0, "Type some stuff", 0));
        tasks.add(new Task(0, "Shoot some video", 0));
        tasks.add(new Task(0, "Charge my phone", 0));
        
        timeslots.add(new Timeslot(0, 0));
        
        boards.add(new Board(0, "my homework", 0));
        
        users.add(new User(0, "Everest Oreizy", "everest@oreizy.com", 123456));
        
    }
    
}
