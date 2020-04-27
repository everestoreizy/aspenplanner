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
public class Board {
    
    public int boardId;
    public String title;
    public int userId;
    public String titleBarColor;
    
    public Board(int _boardId, String _title, int _userId){
        this.boardId = _boardId;
        this.title = _title;
        this.userId = _userId;
    }
    
}
