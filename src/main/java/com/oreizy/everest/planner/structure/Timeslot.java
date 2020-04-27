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
public class Timeslot {
    
    public int timeslotId;
    public int boardId;
    
    public Timeslot(int _timeslotId, int _boardId){
        this.timeslotId = _timeslotId;
        this.boardId = _boardId;
    }
    
}
