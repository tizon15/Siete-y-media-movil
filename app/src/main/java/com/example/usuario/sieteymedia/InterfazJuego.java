package com.example.usuario.sieteymedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;
import static com.example.usuario.sieteymedia.R.drawable.as_bastos;

/**
 * Created by usuario on 09/03/2017.
 */

public class InterfazJuego extends AppCompatActivity {
    Juego juego;
    Jugador jugador = new Jugador();
    Button btnPedirCarta, btnPlantarse;
    ImageView imgJug, imgJug2, imgBaraja;
    TextView etPuntos, etPuntos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        btnPedirCarta = (Button) findViewById(R.id.btnPedirCarta);
        btnPlantarse = (Button) findViewById(R.id.btnPlantarse);

        imgJug = (ImageView) findViewById(R.id.imgJug);

        imgJug2 = (ImageView) findViewById(R.id.imgJug2);
        imgBaraja = (ImageView) findViewById(R.id.imgBaraja);
        etPuntos = (TextView) findViewById(R.id.etPuntos);
        etPuntos2 = (TextView) findViewById(R.id.etPuntos2);

        juego = new Juego(this);
        juego.darCartaInicio(jugador);


        btnPedirCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    juego.darCarta(jugador);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        btnPlantarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juego.Plantarse(jugador);

                try {
                    juego.Maquina(jugador);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void reiniciar(Jugador jugador) {
         imgJug.refreshDrawableState();
        imgJug2.refreshDrawableState();
        jugador.vaciar();
        juego.playerSum=0.0;
        juego.mySum=0.0;
        imgJug2.setImageResource(R.drawable.barajacartas);
        etPuntos2.setText("Puntos: "+juego.mySum);
        //empezamos de nuevo la partida
        juego.darCartaInicio(jugador);
        //activamos los botones
        btnPedirCarta.setEnabled(true);
        btnPlantarse.setEnabled(true);



    }



    public void cambiarCarta(Carta carta) {


        //AS
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(as_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.as_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.as_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.as_oros);
        }
        //dos
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.dos_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.dos_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.dos_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.dos_oros);
        }
        //TRES
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.tres_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.tres_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.tres_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.tres_oros);
        }
        //CUATRO
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.cuatro_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.cuatro_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.cuatro_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.cuatro_oros);
        }
        //CINCO
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.cinco_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.cinco_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.cinco_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.cinco_oros);
        }
        //SEIS
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.seis_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.seis_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.seis_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.seis_oros);
        }
        //SIETE
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.siete_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.siete_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.siete_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.siete_oros);
        }
        //SOTA
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.sota_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.sota_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.sota_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.sota_oros);
        }
        //CABALLO
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.caballo_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.caballo_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.caballo_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.caballo_oros);
        }
        //REY
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug.setImageResource(R.drawable.rey_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug.setImageResource(R.drawable.rey_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug.setImageResource(R.drawable.rey_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug.setImageResource(R.drawable.rey_oros);
        }
    }
          public void cambiarCartaMaquina(Carta carta) {


        //AS
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(as_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.as_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.as_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.AS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.as_oros);
        }
        //dos
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.dos_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.dos_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.dos_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.DOS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.dos_oros);
        }
        //TRES
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.tres_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.tres_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.tres_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.TRES) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.tres_oros);
        }
        //CUATRO
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.cuatro_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.cuatro_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.cuatro_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CUATRO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.cuatro_oros);
        }
        //CINCO
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.cinco_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.cinco_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.cinco_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CINCO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.cinco_oros);
        }
        //SEIS
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.seis_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.seis_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.seis_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SEIS) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.seis_oros);
        }
        //SIETE
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.siete_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.siete_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.siete_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SIETE) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.siete_oros);
        }
        //SOTA
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.sota_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.sota_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.sota_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.SOTA) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.sota_oros);
        }
        //CABALLO
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.caballo_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.caballo_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.caballo_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.CABALLO) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.caballo_oros);
        }
        //REY
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.BASTOS)) {
            imgJug2.setImageResource(R.drawable.rey_bastos);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.COPAS)) {
            imgJug2.setImageResource(R.drawable.rey_copas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.ESPADAS)) {
            imgJug2.setImageResource(R.drawable.rey_espadas);
        }
        if (carta.getNombre().equals(Carta.ValorCarta.REY) && carta.getPalo().equals(Carta.PaloCarta.OROS)) {
            imgJug2.setImageResource(R.drawable.rey_oros);
        }
    }



}



