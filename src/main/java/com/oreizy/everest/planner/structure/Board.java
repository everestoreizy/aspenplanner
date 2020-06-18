/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.planner.structure;

import com.oreizy.everest.planner.dependencies.EOTools;
import java.util.ArrayList;

/**
 *
 * @author eoreizy
 */
public class Board {
    
    //public int boardId;
    public String title;
    //public int userId;
    public String titleBarColor;
    public ArrayList<Timeslot> timeslots;
    public UserTX owner;
    public String tag;
    
    public Board(String _title, UserTX _owner){
        //this.boardId = _boardId;
        this.title = _title;
        //this.userId = _userId;
        this.timeslots = new ArrayList<Timeslot>();
        this.owner = _owner;
        this.tag = EOTools.nameToTag(_title);
    }
    
    public Board(String _title, UserTX _owner, ArrayList<Timeslot> _timeslotArr){
        //this.boardId = _boardId;
        this.title = _title;
        //this.userId = _userId;
        this.timeslots = _timeslotArr;
        this.owner = _owner;
        this.tag = EOTools.nameToTag(_title);
    }
    
}
