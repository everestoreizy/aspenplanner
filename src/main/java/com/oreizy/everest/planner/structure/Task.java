/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.structure;

/**
 *
 * @author eoreizy
 */
public class Task {
    public int taskId;
    public String title;
    public int timeslotId;
    public boolean isComplete;
    
    public Task(int _taskId, String _title, int _timeslotId){
        this.taskId = _taskId;
        this.title = _title;
        this.timeslotId = _timeslotId;
        this.isComplete = false;
    }
    
}
