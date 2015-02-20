package com.ryan.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Board game;
    private ArrayList<Button> buttons;

    private TextView playerTurn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.button0));
        buttons.add((Button) findViewById(R.id.button1));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
        buttons.add((Button) findViewById(R.id.button6));
        buttons.add((Button) findViewById(R.id.button7));
        buttons.add((Button) findViewById(R.id.button8));

        game = new Board();
        playerTurn = (TextView) findViewById(R.id.turn_player);

        startNewGame();

    }

    public void startNewGame() {

        game.clearBoard();
        playerTurn.setText("Player 1's turn");

        for (Button b : buttons) {

            b.setEnabled(true);
            b.setText("");
            b.setOnClickListener(new ButtonClickListener(b));

        }


    }

    private class ButtonClickListener implements View.OnClickListener {


        Button clickedButton;

        public ButtonClickListener(Button b) {

            this.clickedButton = b;

        }

        public void onClick(View v) {

        String TAG = "TicTacToe Log Message:";
            if (!game.checkWin() || !game.checkTie()) {

                Log.d(TAG, "checkTie is" + String.valueOf(game.checkTie()));
                Log.d(TAG, "checkWin is" + String.valueOf(game.checkWin()));

                if (v.isEnabled()) {
                    if (game.turnCounter == 1) {
                        String tempNumberString = v.getResources().getResourceEntryName(v.getId()).substring(6);
                        int tempLocation = Integer.parseInt(tempNumberString);
                        game.setMove(1, tempLocation);
                        this.clickedButton.setText("X");
                        this.clickedButton.setEnabled(false);
                        game.turnCounter = 2;

                    }
                    else if (game.turnCounter == 2) {
                        String tempNumberString = v.getResources().getResourceEntryName(v.getId()).substring(6);
                        int tempLocation = Integer.parseInt(tempNumberString);
                        game.setMove(2, tempLocation);
                        this.clickedButton.setText("O");
                        this.clickedButton.setEnabled(false);
                        game.turnCounter = 1;
                    }
                }
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
