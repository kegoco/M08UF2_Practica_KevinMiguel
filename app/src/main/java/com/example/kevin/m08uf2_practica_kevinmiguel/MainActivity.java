package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn01;
    private Button btn02;
    private Button btn04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn04 = (Button) findViewById(R.id.btn04);

        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn01_Imagen.class);
                startActivity(i);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn02_GPS.class);
                startActivity(i);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn04_Sonido.class);
                startActivity(i);
            }
        });
    }
    public void onClick(View v){
        System.out.println("funciona");


    }

}
