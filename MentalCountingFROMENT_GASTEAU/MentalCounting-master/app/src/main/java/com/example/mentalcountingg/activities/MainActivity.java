package com.example.mentalcountingg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mentalcountingg.R;

public class MainActivity extends AppCompatActivity {

    private Button go_game;
    private Button scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_game= (Button) findViewById(R.id.go_game);
        go_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityGame();
            }
        });

        scores= (Button) findViewById(R.id.scores);
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_scores();
            }
        });
    }


    public void openActivityGame(){
        Intent intent = new Intent(this, ActivityGame.class);
        startActivity(intent);
    }

    public void openActivity_scores(){
        Intent intent = new Intent(this, Activity_scores.class);
        startActivity(intent);
    }
}