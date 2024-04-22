package com.silaskin.matematik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LevelsActivity extends AppCompatActivity {

    private ImageView b_back; //ANASAYFA BUTONU
    private ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    private int oyun, level; //OYNANMAK İSTENEN OYUN TAKİP
    private SharedPreferences spLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_levels );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );

            //VERİTABANINDA Kİ VERİLERİN ÇEKİLMESİ
            spLevel = getSharedPreferences("Matematik", Context.MODE_PRIVATE);
            oyun = spLevel.getInt("oyun", 0);
            level = spLevel.getInt("level", 1);

            //OBJELERİN TANIMLAMALARI
            b_back = findViewById( R.id.b_back );
            btn1 = findViewById( R.id.btn1 );
            btn2 = findViewById( R.id.btn2 );
            btn3 = findViewById( R.id.btn3 );
            btn4 = findViewById( R.id.btn4 );
            btn5 = findViewById( R.id.btn5 );
            btn6 = findViewById( R.id.btn6 );
            btn7 = findViewById( R.id.btn7 );
            btn8 = findViewById( R.id.btn8 );
            btn9 = findViewById( R.id.btn9 );
            btn10 = findViewById( R.id.btn10 );


            //METHODLARIN ÇALIŞTIRILMASI
            hideNavigationBar();
            BackButton();
            LevelsButton();
            LevelsControl();


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
    } //OYUNU TAM EKRAN YAPMAK İÇİN
    public void BackButton() // GERİ TUŞU
    {
        b_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        } );

    }
    public void LevelsButton() //LEVEL BUTONLARININ İŞLEMLERİ
    {
        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 1;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 2;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 3;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 4;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 5;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 6;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 7;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 8;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 9;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );

        btn10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyun = 10;
                SharedPreferences.Editor editor = spLevel.edit();
                editor.putInt("oyun",oyun);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        } );
    }
    public void LevelsControl() //LEVEL BUTONLARININ KONTROLLERİ, AÇIK OLMAYAN LEVELLERİ KAPATMAK İÇİN
    {
        if (level == 1)
        {
            //IMAGE LERE GÖRSEL ATAMAK
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.bklt );
            btn3.setImageResource( R.drawable.bklt );
            btn4.setImageResource( R.drawable.bklt );
            btn5.setImageResource( R.drawable.bklt );
            btn6.setImageResource( R.drawable.bklt );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            //BUTONLARIN TIKLANABİLİRLİK KONTROLLERİ
            btn1.setEnabled( true );
            btn2.setEnabled( false );
            btn3.setEnabled( false );
            btn4.setEnabled( false );
            btn5.setEnabled( false );
            btn6.setEnabled( false );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 2)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.bklt );
            btn4.setImageResource( R.drawable.bklt );
            btn5.setImageResource( R.drawable.bklt );
            btn6.setImageResource( R.drawable.bklt );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( false );
            btn4.setEnabled( false );
            btn5.setEnabled( false );
            btn6.setEnabled( false );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 3)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.bklt );
            btn5.setImageResource( R.drawable.bklt );
            btn6.setImageResource( R.drawable.bklt );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( false );
            btn5.setEnabled( false );
            btn6.setEnabled( false );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 4)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.bklt );
            btn6.setImageResource( R.drawable.bklt );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( false );
            btn6.setEnabled( false );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 5)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.bklt );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( false );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 6)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.b6 );
            btn7.setImageResource( R.drawable.bklt );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( true );
            btn7.setEnabled( false );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 7)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.b6 );
            btn7.setImageResource( R.drawable.b7 );
            btn8.setImageResource( R.drawable.bklt );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( true );
            btn7.setEnabled( true );
            btn8.setEnabled( false );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 8)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.b6 );
            btn7.setImageResource( R.drawable.b7 );
            btn8.setImageResource( R.drawable.b8 );
            btn9.setImageResource( R.drawable.bklt );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( true );
            btn7.setEnabled( true );
            btn8.setEnabled( true );
            btn9.setEnabled( false );
            btn10.setEnabled( false );
        }

        else  if (level == 9)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.b6 );
            btn7.setImageResource( R.drawable.b7 );
            btn8.setImageResource( R.drawable.b8 );
            btn9.setImageResource( R.drawable.b9 );
            btn10.setImageResource( R.drawable.bklt );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( true );
            btn7.setEnabled( true );
            btn8.setEnabled( true );
            btn9.setEnabled( true );
            btn10.setEnabled( false );
        }

        else  if (level == 10)
        {
            btn1.setImageResource( R.drawable.b1 );
            btn2.setImageResource( R.drawable.b2 );
            btn3.setImageResource( R.drawable.b3 );
            btn4.setImageResource( R.drawable.b4 );
            btn5.setImageResource( R.drawable.b5 );
            btn6.setImageResource( R.drawable.b6 );
            btn7.setImageResource( R.drawable.b7 );
            btn8.setImageResource( R.drawable.b8 );
            btn9.setImageResource( R.drawable.b9 );
            btn10.setImageResource( R.drawable.b10 );

            btn1.setEnabled( true );
            btn2.setEnabled( true );
            btn3.setEnabled( true );
            btn4.setEnabled( true );
            btn5.setEnabled( true );
            btn6.setEnabled( true );
            btn7.setEnabled( true );
            btn8.setEnabled( true );
            btn9.setEnabled( true );
            btn10.setEnabled( true );
        }
    }

}