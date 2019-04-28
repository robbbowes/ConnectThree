package com.example.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1 = red, 2 = yellow, 0 = empty
    private int activePlayer = 1;
    private int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[][] winningCombos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private int winner = 0;

    public void clickGrid(View view) {
        ImageView imageView = (ImageView) view;
        boolean alreadyClicked = gameState[Integer.parseInt(imageView.getTag().toString())] != 0;
        if (winner == 0 && !alreadyClicked) {
            imageView.setTranslationY(-1500);

            int clickedBox = Integer.parseInt(imageView.getTag().toString());
            gameState[clickedBox] = activePlayer;

            int drawable = activePlayer == 1 ? R.drawable.red : R.drawable.yellow;
            imageView.setImageResource(drawable);
            imageView.animate().translationYBy(1500).rotation(1080).setDuration(300);
            winnerChecker();
            if (winner != 0) {
                String winnerColour = winner == 1 ? "Red" : "Yellow";
                System.out.println(activePlayer + " has won!!");
                Toast.makeText(this, winnerColour + " has won!", Toast.LENGTH_LONG).show();
            } else {
                activePlayer = activePlayer == 1 ? 2 : 1;
            }
        }
    }

    private void winnerChecker() {
        for (int[] winningCombo : winningCombos) {
            if (
                    (gameState[winningCombo[0]] == gameState[winningCombo[1]])
                            && (gameState[winningCombo[1]] == gameState[winningCombo[2]])
                            && (gameState[winningCombo[0]] != 0)
            ) {
                winner = activePlayer;
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
