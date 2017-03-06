package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Btn01_Fotogra extends AppCompatActivity {
    private Button btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01__fotogra);

        btnAtras = (Button) findViewById(R.id.btnAtras);
        ImageView imatge = (ImageView) findViewById(R.id.imgcClick);
        AnimationDrawable animacio = (AnimationDrawable) imatge.getDrawable();
        animacio.start();

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }
}
