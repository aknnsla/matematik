package com.silaskin.matematik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    private ImageView b_back; //ANASAYFA BUTONU
    private ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndel, btnenter; //KLAVYE BUTONLARI
    private EditText ed_txt; //CEVABIN YAZILACAĞI EDİTTEXT
    private ImageView iv_soru;
    private TextView tv_level;
    private String cevap, tahmin; //DORĞU CEVAP VE TAHMİN STRİNGLERİ
    private int level, oyun; //LEVEL TAKİP
    private SharedPreferences spLevel;
    private SharedPreferences.Editor spLevelEditor;

    private CountDownTimer countDownTimer;

    private long timer = 100000;
    int score, score1, score2, score3, score4, score5, score6, score7, score8, score9, score10 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_game );
        ViewCompat.setOnApplyWindowInsetsListener( findViewById( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets( WindowInsetsCompat.Type.systemBars() );
            v.setPadding( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );

            spLevel = getSharedPreferences("Matematik", Context.MODE_PRIVATE);
            level = spLevel.getInt("level", 1);
            oyun = spLevel.getInt("oyun", 0);
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

            b_back = findViewById( R.id.b_back );
            iv_soru = findViewById( R.id.iv_soru );
            tv_level = findViewById( R.id.tv );
            btn1 = findViewById( R.id.btn1 );
            btn2 = findViewById( R.id.btn2 );
            btn3 = findViewById( R.id.btn3 );
            btn4 = findViewById( R.id.btn4 );
            btn5 = findViewById( R.id.btn5 );
            btn6 = findViewById( R.id.btn6 );
            btn7 = findViewById( R.id.btn7 );
            btn8 = findViewById( R.id.btn8 );
            btn9 = findViewById( R.id.btn9 );
            btn0 = findViewById( R.id.btn0 );
            btndel = findViewById( R.id.btndel );
            btnenter = findViewById( R.id.btnenter );
            ed_txt = findViewById( R.id.ed_txt );

            score = 0;
            spLevelEditor = spLevel.edit();
            spLevelEditor.putInt( "score", score );
            spLevelEditor.commit();

            hideNavigationBar();
            CountdownTimers();
            EkranaSoruGetirme();
            BackButton();
            EnterButton();
            KeyboardControl();

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

    public void EkranaSoruGetirme() //LEVELE VE SEÇİLEN OYUNA GÖRE EKRANDA SORU GÖZÜKMESİ
    {
        if (oyun == 0){


            if (level == 1)
            {
                iv_soru.setImageResource( R.drawable.soru1 );
                tv_level.setText( "Lv.1" );
            }

            else if (level == 2)
            {
                iv_soru.setImageResource( R.drawable.soru2 );
                tv_level.setText( "Lv.2" );
            }

            else if (level == 3)
            {
                iv_soru.setImageResource( R.drawable.soru3 );
                tv_level.setText( "Lv.3" );
            }

            else if (level == 4)
            {
                iv_soru.setImageResource( R.drawable.soru4 );
                tv_level.setText( "Lv.4" );
            }

            else if (level == 5)
            {
                iv_soru.setImageResource( R.drawable.soru5 );
                tv_level.setText( "Lv.5" );
            }

            else if (level == 6)
            {
                iv_soru.setImageResource( R.drawable.soru6 );
                tv_level.setText( "Lv.6" );
            }

            else if (level == 7)
            {
                iv_soru.setImageResource( R.drawable.soru7 );
                tv_level.setText( "Lv.7" );
            }

            else if (level == 8)
            {
                iv_soru.setImageResource( R.drawable.soru8 );
                tv_level.setText( "Lv.8" );
            }

            else if (level == 9)
            {
                iv_soru.setImageResource( R.drawable.soru9 );
                tv_level.setText( "Lv.9" );
            }

            else if (level == 10)
            {
                iv_soru.setImageResource( R.drawable.soru10 );
                tv_level.setText( "Lv.10" );
            }
        }

        else  if (oyun == 1)
        {
            iv_soru.setImageResource( R.drawable.soru1 );
            tv_level.setText( "Lv.1" );
        }

        else if (oyun == 2)
        {
            iv_soru.setImageResource( R.drawable.soru2 );
            tv_level.setText( "Lv.2" );
        }

        else if (oyun == 3)
        {
            iv_soru.setImageResource( R.drawable.soru3 );
            tv_level.setText( "Lv.3" );
        }

        else if (oyun == 4)
        {
            iv_soru.setImageResource( R.drawable.soru4 );
            tv_level.setText( "Lv.4" );
        }

        else if (oyun == 5)
        {
            iv_soru.setImageResource( R.drawable.soru5 );
            tv_level.setText( "Lv.5" );
        }

        else if (oyun == 6)
        {
            iv_soru.setImageResource( R.drawable.soru6 );
            tv_level.setText( "Lv.6" );
        }

        else if (oyun == 7)
        {
            iv_soru.setImageResource( R.drawable.soru7 );
            tv_level.setText( "Lv.7" );
        }

        else if (oyun == 8)
        {
            iv_soru.setImageResource( R.drawable.soru8 );
            tv_level.setText( "Lv.8" );
        }

        else if (oyun == 9)
        {
            iv_soru.setImageResource( R.drawable.soru9 );
            tv_level.setText( "Lv.9" );
        }

        else if (oyun == 10)
        {
            iv_soru.setImageResource( R.drawable.soru10 );
            tv_level.setText( "Lv.10" );
        }
    }

    public void BackButton() //GERİ BUTONU ANASAYFAYA DÖNER
    {
        b_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        } );

    }

    public void KeyboardControl() //KLAVYEDEKİ BUTONLARIN İŞLEMLERİ
    {
        btn0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString(); //EDİTTEXT ÜZERİNDE YAZAN VERİYİ CEVAP DEĞİŞKENİNE AL
                ed_txt.setText( cevap+"0" ); //CEVAP DEĞİŞKENİ YANINA 0 RAKAMINI YAZ
            }
        } );

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"1" );
            }
        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"2" );
            }
        } );

        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"3" );
            }
        } );

        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"4" );
            }
        } );

        btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"5" );
            }
        } );

        btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"6" );
            }
        } );

        btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"7" );
            }
        } );

        btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"8" );
            }
        } );

        btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevap = ed_txt.getText().toString();
                ed_txt.setText( cevap+"9" );
            }
        } );

        btndel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_txt.setText( "" );
            }
        } );

    }

    public void EnterButton() //ENTER BUTONUNA BASINCA GERÇEKLEŞECEK EYLEMLER
    {
        btnenter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tahmin = ed_txt.getText().toString(); //EDİTTEXTE YAZAN SONUCU DEĞİŞKENE ATAR

                if (oyun == 0)
                {
                    if (level == 1){
                        if (tahmin.equals( "12" )){ //EDİTTEXTE YAZAN SONUÇ 12 YE EŞİTSE BU İŞLEM GERÇEKLEŞİR
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score1){
                                score1 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score1", score1 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 2){
                        if (tahmin.equals( "12" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score2){
                                score2 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score2", score2 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 3){
                        if (tahmin.equals( "18" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score3){
                                score3 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score3", score3 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 4){
                        if (tahmin.equals( "13" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score4){
                                score4 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score4", score4 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 5){
                        if (tahmin.equals( "16" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score5){
                                score5 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score5", score5 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 6){
                        if (tahmin.equals( "32" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score6){
                                score6 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score6", score6 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 7){
                        if (tahmin.equals( "28" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score7){
                                score7 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score7", score7 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 8){
                        if (tahmin.equals( "5" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score8){
                                score8 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score8", score8 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 9){
                        if (tahmin.equals( "16" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score9){
                                score9 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score9", score9 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    else if (level == 10){
                        if (tahmin.equals( "9" )){
                            Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();
                            level++;
                            SharedPreferences.Editor editor = spLevel.edit();
                            editor.putInt("level",level);
                            editor.commit();

                            ScoreControl();

                            if (score > score10){
                                score10 = score;
                                spLevelEditor = spLevel.edit();
                                spLevelEditor.putInt( "score10", score10 );
                                spLevelEditor.commit();
                            } else {

                            }

                            Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            ed_txt.setText( "" );
                            Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                        }
                    }
                }

                else if (oyun == 1)
                {
                    if (tahmin.equals( "12" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 2)
                {
                    if (tahmin.equals( "12" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 3)
                {
                    if (tahmin.equals( "18" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 4)
                {
                    if (tahmin.equals( "13" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 5)
                {
                    if (tahmin.equals( "16" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 6)
                {
                    if (tahmin.equals( "32" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 7)
                {
                    if (tahmin.equals( "28" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 8)
                {
                    if (tahmin.equals( "5" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 9)
                {
                    if (tahmin.equals( "16" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }

                else if (oyun == 10)
                {
                    if (tahmin.equals( "9" )){
                        Toast.makeText( GameActivity.this, "Doğru Cevap", Toast.LENGTH_SHORT ).show();

                        ScoreControl();

                        if (score > score1){
                            score1 = score;
                            spLevelEditor = spLevel.edit();
                            spLevelEditor.putInt( "score1", score1 );
                            spLevelEditor.commit();
                        } else {

                        }
                    }

                    else
                    {
                        ed_txt.setText( "" );
                        Toast.makeText( GameActivity.this, "Yanlış Cevap", Toast.LENGTH_SHORT ).show();
                    }
                }


            }
        } );
    }
    public void CountdownTimers(){
        countDownTimer = new CountDownTimer(timer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer = millisUntilFinished;
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    protected void onStop() {
        super.onStop();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void ScoreControl(){

        countDownTimer.cancel();

        score = (int) (timer / 1000);
        spLevelEditor = spLevel.edit();
        spLevelEditor.putInt( "score", score );
        spLevelEditor.commit();
    }
}