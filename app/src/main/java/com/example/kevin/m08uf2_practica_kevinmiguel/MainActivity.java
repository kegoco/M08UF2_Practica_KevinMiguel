package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);

        // El botón "btn01" hace referencia al botón con la imagen de Mario.
        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn01_Imagen.class);
                startActivity(i);
            }
        });

        // El botón "btn02" hace referencia al botón con la imagen de GPS.
        btn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn02_GPS.class);
                startActivity(i);
            }
        });

        // El botón "btn03" hace referencia al botón con la imagen del Pinguino que sujeta una cámara.
        btn03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn03_Camara.class);
                startActivity(i);
            }
        });

        // El botón "btn04" hace referencia al botón con la imagen del micrófono.
        btn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn04_Sonido.class);
                startActivity(i);
            }
        });

        // El botón "btn05" hace referencia al botón con la imagen del vídeo.
        btn05.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn05_Video.class);
                startActivity(i);
            }
        });
    }
}
