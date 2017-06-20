package com.example.usuario.sieteymedia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btnEmpezar,btnAyuda,btnAcercaDe;


    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar=(Button) findViewById(R.id.btnEmpezar);
        btnAyuda=(Button) findViewById(R.id.btnAyuda);
        btnAcercaDe=(Button) findViewById(R.id.btnAcercaDe);
        btnEmpezar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent areaJuego = new Intent(MainActivity.this, InterfazJuego.class);
                startActivity(areaJuego);
            }
        });
        btnAyuda.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent areaAyuda = new Intent(MainActivity.this, Ayuda.class);
                startActivity(areaAyuda);
            }
        });
        btnAcercaDe.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent areaAyuda = new Intent(MainActivity.this, acercaDe.class);
                startActivity(areaAyuda);
            }
        });


        mediaPlayer = MediaPlayer.create(this, R.raw.cancion);
        mediaPlayer.isLooping();
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.start();










    }



}
