package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import java.io.IOException;

public class Btn04_Sonido extends AppCompatActivity {

    private ToggleButton btnGrabarSonido;
    private Button btnReproducirSonido;
    private Button btnAtras;

    private static String nombreFichero1 = null;
    private static String nombreFichero2 = null;

    private boolean grabandoSonido = false;
    private boolean reproduciendoSonido = false;

    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn04__sonido);

        btnGrabarSonido = (ToggleButton) findViewById(R.id.btnGrabarSonido);
        btnReproducirSonido = (Button) findViewById(R.id.btnReproducirSonido);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        // Generar nombre del fichero.
        nombreFichero1 = Environment.getExternalStorageDirectory() + "/gravacio1.3gp";
        nombreFichero2 = getExternalFilesDir(null) + "/gravacio2.3gp";

        // Botón que decidirá comenzar a grabar el sonido o parará de grabar el sonido.
        btnGrabarSonido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (!grabandoSonido) {
                    comienzaGrabacion();  // Inicia la grabación de sonido.
                } else {
                    pararGrabacion();  // Detiene la grabación de sonido.
                }
                grabandoSonido = !grabandoSonido;  // Cambia el estado de grabación.
            }
        });

        // Botón que decidirá comenzar a reproducir el sonido que hemos grabado o parar de reproducir el mismo.
        btnReproducirSonido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (!reproduciendoSonido) {
                    comenzarReproduccion();
                } else {
                    pararReproduccion();
                }
                reproduciendoSonido = !reproduciendoSonido;
            }
        });

        // Botón para volver a la actividad anterior.
        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }

    // Método para comenzar a grabar el sonido.
    private void comienzaGrabacion() {
        // Crea el MediaRecorder y especifica la fuente de audio, el formato de salida y el ficero, y el codificador de audio.
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(nombreFichero1);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            // Enllestim la grabación.
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Si se dispone de todoo correctamente, se comienza a grabar.
        mRecorder.start();
    }

    // Método para detener la grabación de sonido.
    private void pararGrabacion() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    // Método para comenzar a reproducir el sonido previamente grabado.
    private void comenzarReproduccion() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(nombreFichero1);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para parar de reproducir el sonido previamente grabado.
    private void pararReproduccion() {
        mPlayer.release();
        mPlayer = null;
    }
}
