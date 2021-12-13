package com.example.tictactoe_blackteam2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button[][] buttons = new Button[4][4];
    private TextView player1TV;
    private TextView player2TV;
    private int turnCount;
    String winner;
    // attempting committing logic again

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1TV = (TextView) findViewById(R.id.p1TV);
        player2TV = (TextView) findViewById(R.id.p2TV);

        // initially have player1 GREEN and p2 black
        player2TV.setTextColor(Color.parseColor("#000000"));
        player1TV.setTextColor(Color.parseColor("#00FF00"));

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
            player1TV.setTextColor(Color.parseColor("#000000"));
            player2TV.setTextColor(Color.parseColor("#00FF00"));
        }
        else
        {
            ((Button) v).setText("o");
            player2TV.setTextColor(Color.parseColor("#000000"));
            player1TV.setTextColor(Color.parseColor("#00FF00"));
        }

        turnCount++;

        if(checkForWin())
        {
            if (player1.getTurn())
            {
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                winner = "Player 1";
                promptResetBoard();
                Log.i("info", getWinner());
            }
            else
            {
                Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                winner = "Player 2";
                promptResetBoard();
                Log.i("info", getWinner());
            }
        }
        else if(turnCount == 16)
        {
            Toast.makeText(this, "It's a draw", Toast.LENGTH_SHORT).show();
            winner = "No one";
            promptResetBoard();
        }
        else
        {
            player1.setTurn(!player1.getTurn());
            player2.setTurn(!player2.getTurn());
        }
    }

    private String getWinner()
    {
        return winner;
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
    public void promptResetBoard()
    {
        //place it in here
        //prompt the dialogue box
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("The winner is...." + getWinner() + ". Do you want to replay?");
                builder.setPositiveButton(R.string.ComfirmReplay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //if yes is clicked then this code will run
                        resetBoard();
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog promptReplay = builder.create();
        promptReplay.show();
    }

    public void resetBoard()
    {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
            }
        }

        turnCount = 0;
        player1.setTurn(true);

        // initially p1 green and p2 black
        player2TV.setTextColor(Color.parseColor("#000000"));
        player1TV.setTextColor(Color.parseColor("#00FF00"));
    }

}