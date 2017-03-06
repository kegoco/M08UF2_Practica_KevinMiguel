package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Btn01_Imagen extends AppCompatActivity {
    private Button btn01_interpolacion;
    private Button btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01__imagen);

        btn01_interpolacion = (Button) findViewById(R.id.btnInterpolacion);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        btn01_interpolacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn01_Imagen.this, Btn01_Interpola.class);
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
