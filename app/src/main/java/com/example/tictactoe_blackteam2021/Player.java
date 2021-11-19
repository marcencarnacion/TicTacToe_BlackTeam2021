package com.example.tictactoe_blackteam2021;

import androidx.appcompat.app.AppCompatActivity;

public class Player extends AppCompatActivity
{
    // instance variables
    private boolean turn;
    private String username;

    // constructor
    public Player (boolean turn, String username)
    {
        this.turn = turn;
        this.username = username;
    } // end com.example.tictactoe_blackteam2021.Player constructor

    // getters and setters
    public boolean getTurn ()
    {
        return turn;
    }
    public String getUsername ()
    {
        return username;
    }
    public void setTurn (boolean turn)
    {
        this.turn = turn;
    }
    public void setUsername (String username)
    {
        this.username = username;
    }

    // brain method
    // toString if necessary
} // end com.example.tictactoe_blackteam2021.Player parent class
