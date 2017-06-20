package com.example.usuario.sieteymedia;



import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class Juego extends DialogFragment {

    Baraja baraja;
    double mySum;
    Carta.PaloCarta palo;
    Carta.ValorCarta numero;
    double playerSum;
    InterfazJuego ventana;
    Jugador jugador = new Jugador();
    AlertDialog.Builder builder;

    public Juego(InterfazJuego ventana) {
        this.ventana = ventana;
        baraja = new Baraja();


    }


    public void darCartaInicio(Jugador jugador) {
        Carta carta = baraja.getCarta();
        //damos una carta al jugador
        jugador.giveCarta(carta);
        //cambiamos la carta de la mano del jugador
        jugador.setCartaMano(carta);
        //cambiamos la imagen
        palo = carta.getPalo();
        numero = carta.getNombre();
        ventana.cambiarCarta(carta);
        //cogemos la puntuacion de la carta
        playerSum = carta.getValue();
        System.out.println("jugador: " + numero + " " + palo + "=" + playerSum);

        ventana.etPuntos.setText("Puntos: " + playerSum);


        //etPuntuacion.setText(" "+playerSum+"");
    }

    public void darCarta(final Jugador jugador) throws InterruptedException {
        //aqui obtenemos una carta de la baraja

        Carta carta = baraja.getCarta();
        System.out.println(carta);
        jugador.giveCarta(carta);
        playerSum = jugador.getSum();
        palo = carta.getPalo();
        numero = carta.getNombre();
        ventana.cambiarCarta(carta);
        //cogemos la puntuacion de la carta

        System.out.println("jugador: " + numero + " " + palo + "=" + playerSum);
        System.out.println(toString());
        //AS
        ventana.etPuntos.setText("Puntos: " + playerSum);

        //etPuntuacion.setText((int) playerSum);
        //cambiamos la puntuacion

        if (!jugador.isInGame()) {
            ventana.btnPlantarse.setEnabled(false);
            ventana.btnPedirCarta.setEnabled(false);





            new AlertDialog.Builder(ventana)
                    .setTitle("Siete y Media")
                    .setMessage("Has perdido, ¿quieres jugar otra partida?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ventana.reiniciar(jugador);
                            jugador.setEnJuego(true);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ventana.finish();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();




        }


    }






    public void Plantarse(Jugador jugador) {
        jugador.isInGame();
        ventana.btnPedirCarta.setEnabled(false);
        ventana.btnPlantarse.setEnabled(true);


    }

    public void Maquina(final Jugador jugador) throws InterruptedException {
        if (jugador.isInGame()) {

            playerSum = jugador.getSum();
            mySum = 0.0d;
            while (mySum <= 7.5) {

                Carta carta = baraja.getCarta();

                mySum += carta.getValue();

                ventana.cambiarCartaMaquina(carta);
                ventana.etPuntos2.setText("Puntos: "+mySum);

                System.out.println("maquina: "+mySum);

                if (mySum > 7.5d) {



                        ventana.btnPlantarse.setEnabled(false);
                        ventana.btnPedirCarta.setEnabled(false);
                    new AlertDialog.Builder(ventana)
                            .setTitle("Siete y Media")
                            .setMessage("Has ganado, ¿quieres jugar otra partida?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    ventana.reiniciar(jugador);
                                    jugador.setEnJuego(true);
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    ventana.finish();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();



                    break;
                }

                if (mySum >=6.0d && mySum<=7.5) {

                    if (mySum > playerSum) {
                        new AlertDialog.Builder(ventana)
                                .setTitle("Siete y Media")
                                .setMessage("Has perdido, ¿quieres jugar otra partida?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.reiniciar(jugador);
                                        jugador.setEnJuego(true);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.finish();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                    }
                    else if(mySum==playerSum){
                        new AlertDialog.Builder(ventana)
                                .setTitle("Siete y Media")
                                .setMessage("Empate, ¿quieres jugar otra partida?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.reiniciar(jugador);
                                        jugador.setEnJuego(true);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.finish();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }else{
                        new AlertDialog.Builder(ventana)
                                .setTitle("Siete y Media")
                                .setMessage("Has ganado, ¿quieres jugar otra partida?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.reiniciar(jugador);
                                        jugador.setEnJuego(true);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.finish();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                        ventana.btnPedirCarta.setEnabled(false);
                        ventana.btnPlantarse.setEnabled(false);




                    break;
                }
                if (mySum >=6.0d && mySum>7.5) {

                    if (mySum > playerSum) {
                        new AlertDialog.Builder(ventana)
                                .setTitle("Siete y Media")
                                .setMessage("Has ganado, ¿quieres jugar otra partida?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.reiniciar(jugador);
                                        jugador.setEnJuego(true);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.finish();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                    }else{
                        new AlertDialog.Builder(ventana)
                                .setTitle("Siete y Media")
                                .setMessage("Has Ganado, ¿quieres jugar otra partida?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.reiniciar(jugador);
                                        jugador.setEnJuego(true);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        ventana.finish();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                    ventana.btnPedirCarta.setEnabled(false);
                    ventana.btnPlantarse.setEnabled(false);




                    break;
                }
                if (mySum == 7.5d && playerSum == 7.5d) {
                    ventana.btnPlantarse.setEnabled(false);
                    ventana.btnPedirCarta.setEnabled(false);


                    new AlertDialog.Builder(ventana)
                            .setTitle("Siete y Media")
                            .setMessage("Empate, ¿quieres jugar otra partida?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    ventana.reiniciar(jugador);
                                    jugador.setEnJuego(true);
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    ventana.finish();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                    break;
                }

            }
        }
    }



}


