package com.silaskin.matematik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinishActivity extends AppCompatActivity {

    private CardView cv_home, cv_next;
    private int level; //LEVEL TAKİP
    private SharedPreferences spLevel;

    private TextView tvLevelDurum, bScore, gScore;
    int score, score1, score2, score3, score4, score5, score6, score7, score8, score9, score10 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_finish );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );

            spLevel = getSharedPreferences("Matematik", Context.MODE_PRIVATE);
            level = spLevel.getInt("level", 1);
            score = spLevel.getInt("score", 0);
            score1 = spLevel.getInt("score1", 0);
            score2 = spLevel.getInt("score2", 0);
            score3 = spLevel.getInt("score3", 0);
            score4 = spLevel.getInt("score4", 0);
            score5 = spLevel.getInt("score5", 0);
            score6 = spLevel.getInt("score6", 0);
            score7 = spLevel.getInt("score7", 0);
            score8 = spLevel.getInt("score8", 0);
            score9 = spLevel.getInt("score9", 0);
            score10 = spLevel.getInt("score10", 0);

            cv_home = findViewById( R.id.cv_home );
            cv_next = findViewById( R.id.cv_next );

            tvLevelDurum = findViewById( R.id.tvLevelDurum );
            bScore = findViewById( R.id.bScore );
            gScore = findViewById( R.id.gScore );

            gScore.setText( String.valueOf( score ) );

            hideNavigationBar();
            HomeButton();
            NextButton();
            LevelControl();
            HighScoreControl();

            return insets;
        } );
    }
    public void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

                );
    } // OYUNU TAM EKRAN YAPMAK İÇİN

    public void HomeButton() //ANASAYFAYA DÖNMEK İÇİN
    {
        cv_home.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        } );
    }

    public void NextButton() //SONRAKİ LEVEL İÇİN
    {
        cv_next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (level == 11)
                {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

                else
                {
                    Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                    startActivity(intent);
                }

            }
        } );
    }

    public void LevelControl(){

         tvLevelDurum.setText( String.valueOf("LEVEL "+ (level -1)));

    }

    public void HighScoreControl(){

        int goster = level -1;
        if (goster == 1){
            bScore.setText( String.valueOf( score1 ) );
        } else if (goster == 2){
            bScore.setText( String.valueOf( score2 ) );
        } else if (goster == 3){
            bScore.setText( String.valueOf( score3 ) );
        } else if (goster == 4){
            bScore.setText( String.valueOf( score4 ) );
        } else if (goster == 5){
            bScore.setText( String.valueOf( score5 ) );
        } else if (goster == 6){
            bScore.setText( String.valueOf( score6 ) );
        } else if (goster == 7){
            bScore.setText( String.valueOf( score7 ) );
        } else if (goster == 8){
            bScore.setText( String.valueOf( score8 ) );
        } else if (goster == 9){
            bScore.setText( String.valueOf( score9 ) );
        } else if (goster == 10){
            bScore.setText( String.valueOf( score10 ) );
        }

    }
}