package com.silaskin.matematik;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    private ImageView b_play, b_level, b_reset; //Anasayfada buton olarak kullanılacak olan ımageview
    private int level, oyun; //LEVEL TAKİP
    private SharedPreferences spLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_main );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );

            spLevel = getSharedPreferences("Matematik", Context.MODE_PRIVATE);
            level = spLevel.getInt("level", 1);
            oyun = spLevel.getInt("oyun", 0);

            b_play = findViewById( R.id.b_play );
            b_level = findViewById( R.id.b_level );
            b_reset = findViewById( R.id.b_reset );

            PlayButton();
            LevelButton();
            ResetButton();
            hideNavigationBar();

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
    }

    public void PlayButton()
    {
        //BAŞLA BUTONUNA TIKLANDIĞINDA GERÇEKLEŞECEK EYLEMLER
        b_play.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oyun = 0;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                if(level == 11)
                {
                    Toast.makeText( MainActivity.this, "Oyunu Tamamladınız", Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                    startActivity(intent);
                }

            }
        } );
    }

    public void LevelButton()
    {
        //LEVEL BUTONUNA TIKLANDIĞINDA GERÇEKLEŞECEK EYLEMLER
        b_level.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LevelsActivity.class);
                startActivity(intent);
            }
        } );
    }

    public void ResetButton()
    {
        //RESET BUTONUNA TIKLANDIĞINDA GERÇEKLEŞECEK EYLEMLER
        b_reset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spLevel.edit().clear().commit();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast.makeText( MainActivity.this, "Oyun Sıfırlandı", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}