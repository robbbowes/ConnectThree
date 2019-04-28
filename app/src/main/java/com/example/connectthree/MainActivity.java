package com.example.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 1 = red, 2 = yellow, 0 = empty
    private int activePlayer = 1;
    private boolean gameWon = false;
    private int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};


    public void clickGrid(View view) {
        ImageView imageView = (ImageView) view;
        imageView.setTranslationY(-1500);

        int clickedBox = Integer.parseInt(imageView.getTag().toString());
        gameState[clickedBox] = activePlayer;

        int drawable = activePlayer == 1 ? R.drawable.red : R.drawable.yellow;
        imageView.setImageResource(drawable);
        imageView.animate().translationYBy(1500).rotation(1080).setDuration(300);

        activePlayer = activePlayer == 1 ? 2 : 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
