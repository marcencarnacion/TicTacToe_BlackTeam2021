package com.example.tictactoe_blackteam2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button[][] buttons = new Button[3][3];
    private int turnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets btnID to buttons array
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
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
            player1.setTurn(false);
        }
        else
        {
            ((Button) v).setText("o");
            player1.setTurn(true);
        }

        turnCount++;
    }
/*
    private boolean checkForWin()
    {
        String[][] field = new String[3][3];

        //sets field array to text of buttons array
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        //checks columns
        for(int i = 0; i < 3; i++)
        {
            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals(""))
            {
                return true;
            }
        }
        //checks rows
        for(int i = 0; i < 3; i++)
        {
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals(""))
            {
                return true;
            }
        }

    }
*/
}