package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Btn02_GPS extends AppCompatActivity {

    private Button btnGPS;
    private  Button btnGoogleMaps;
    private Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn02__gps);

        btnGPS = (Button) findViewById(R.id.btnGPS);
        btnGoogleMaps = (Button) findViewById(R.id.btnGoogleMaps);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        btnGPS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn02_GPS.this, Btn02_PosicionGPS.class);
                startActivity(i);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });

    }
}
