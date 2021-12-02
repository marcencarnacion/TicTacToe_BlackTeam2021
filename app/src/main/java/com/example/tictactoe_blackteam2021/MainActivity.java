package com.example.tictactoe_blackteam2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    private Button[][] buttons = new Button[4][4];
    private int turnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets btnID to buttons array
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                String btnID = "btn" + i + j;
                int resID = getResources().getIdentifier(btnID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this::onClick);
            }
        }

    }

    Player player1 = new Player(true, "Player 1");
    Player player2 = new Player(false, "Player 2");

    public void onClick(View v)
    {
        if(!((Button) v).getText().toString().equals(""))
        {
            return;
        }

        if(player1.getTurn() == true)
        {
            ((Button) v).setText("x");
        }
        else
        {
            ((Button) v).setText("o");
        }

        turnCount++;

        if(checkForWin())
        {
            if(player1.getTurn())
            {
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                resetBoard();
            }
            else
            {
                Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                resetBoard();
            }
        }
        else if(turnCount == 16)
        {
            Toast.makeText(this, "It's a draw", Toast.LENGTH_SHORT).show();
            resetBoard();
        }
        else
        {
            player1.setTurn(!player1.getTurn());
            player2.setTurn(!player2.getTurn());
        }
    }

    //checks if a player has won
    private boolean checkForWin()
    {
        String[][] field = new String[4][4];

        //sets field array to text of buttons array
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        //checks rows
        for(int i = 0; i < 4; i++)
        {
            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && field[i][0].equals(field[i][3]) && !field[i][0].equals(""))
            {
                return true;
            }
        }
        //checks columns
        for(int i = 0; i < 4; i++)
        {
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && field[0][i].equals(field[3][i]) && !field[0][i].equals(""))
            {
                return true;
            }
        }

        if(field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && field[0][0].equals(field[3][3]) && !field[0][0].equals(""))
        {
            return true;
        }

        if(field[0][3].equals(field[1][2]) && field[0][3].equals(field[2][1]) && field[0][3].equals(field[3][0]) && !field[0][3].equals(""))
        {
            return true;
        }
        return false;
    }

    //resets the board
    private void resetBoard()
    {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
            }
        }

        turnCount = 0;
        player1.setTurn(true);
    }


}