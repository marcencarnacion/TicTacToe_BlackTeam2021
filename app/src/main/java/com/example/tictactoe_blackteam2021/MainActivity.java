package com.example.tictactoe_blackteam2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button[][] buttons = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                String btnID = "btn" + i + j;
                
            }
        }

    }

    Player player1 = new Player(1, "Player 1");

}