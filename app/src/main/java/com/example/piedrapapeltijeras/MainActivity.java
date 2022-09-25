package com.example.piedrapapeltijeras;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int datoJugador = 0;
    int datoBot = 0;
    //int numAleatory = (int)(Math.random()*3+1);
    int puntosJugador;
    int puntosBot;

    Button btpiedra, btpapel, bttijeras;

    ImageView dataJugador;
    ImageView dataBot;
    TextView tvpuntosJugador;
    TextView tvPuntosBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataJugador = findViewById(R.id.ivJugador);
        dataBot = findViewById(R.id.ivBot);
        tvpuntosJugador = findViewById(R.id.tvPuntosJugador);
        tvPuntosBot = findViewById(R.id.tvPuntosBot);

        btpapel = (Button) findViewById(R.id.btPapel);
        bttijeras = (Button) findViewById(R.id.btTijeras);
        btpiedra = (Button) findViewById(R.id.btPiedra);

        btpapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador=2;
                //ResultadoJugador();
                AleatorioDataComputer();
                Resultado();
            }
        });

        bttijeras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador=3;
                //ResultadoJugador();
                AleatorioDataComputer();
                Resultado();
            }
        });

        btpiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador=1;
                //ResultadoJugador();
                AleatorioDataComputer();
                Resultado();
            }
        });

    }
    //metodo dato jugador
    public void ResultadoJugador() {
        if (datoJugador == 1) {
            dataJugador.setImageResource(R.drawable.piedra);
        } else if (datoJugador == 2) {
            dataJugador.setImageResource(R.drawable.papel);
        } else if (datoJugador == 3) {
            dataJugador.setImageResource(R.drawable.tijeras);
        }

        Resultado();
    }

    public void AleatorioDataComputer() {
        //clase Aleatorio
        int num_aleatorio = (int)(Math.random()*3+1);

        if (num_aleatorio == 1) {
            dataBot.setImageResource(R.drawable.piedra2);
            datoBot = 1;
        } else if (num_aleatorio == 2) {
            dataBot.setImageResource(R.drawable.papel2);
            datoBot = 2;
        } else if (num_aleatorio == 3) {
            dataBot.setImageResource(R.drawable.tijeras2);
            datoBot = 3;
        }
        //ejecuto el metodo ResultadoJugador
        ResultadoJugador();
    }

    //compara quien gana
    public void Resultado() {
        if (datoJugador == datoBot) {
            Toast.makeText(this, "EMPATE", Toast.LENGTH_SHORT).show();
        } else if (datoJugador == 1 && datoBot == 2) {
            //piedra vs papel (gano papel bot)
            puntosBot++;
            tvPuntosBot.setText(String.valueOf(puntosBot));
        } else if (datoJugador == 1 && datoBot == 3) {
            //piedra vs tijera (gano piedra jugador)
            puntosJugador++;
            tvpuntosJugador.setText(String.valueOf(puntosJugador));
        } else if (datoJugador == 2 && datoBot == 3) {
            //papel vs tijera (gano tijera bot)
            puntosBot++;
            tvPuntosBot.setText(String.valueOf(puntosBot));
        } else if (datoJugador == 2 && datoBot == 1) {
            //papel vs piedra (gano papel jugador)
            puntosJugador++;
            tvpuntosJugador.setText(String.valueOf(puntosJugador));
        } else if (datoJugador == 3 && datoBot == 1) {
            //tijera vs piedra (gano piedra bot)
            puntosBot++;
            tvPuntosBot.setText(String.valueOf(puntosBot));
        } else if (datoJugador == 3 && datoBot == 2) {
            //tijera vs papel (gano tijera jugadro)
            puntosJugador++;
            tvpuntosJugador.setText(String.valueOf(puntosJugador));
        }

    }

}