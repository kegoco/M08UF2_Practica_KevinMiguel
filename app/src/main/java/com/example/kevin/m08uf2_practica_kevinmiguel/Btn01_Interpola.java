package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Btn01_Interpola extends AppCompatActivity implements View.OnClickListener{
//holia
    private Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01__interpola);

        btnAtras = (Button) findViewById(R.id.btnAtras);

        ImageView imagen = (ImageView) findViewById(R.id.imgV);
        imagen.setOnClickListener(this);

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        // Cuando se hace un "touch" se ejecutará el siguiente código.
        // El siguiente código pone en marcha la animación de la imagen.
        ImageView imatge = (ImageView) findViewById(R.id.imgV);
        Animation animacioBanana = AnimationUtils.loadAnimation(this,R.anim.venir);
        imatge.startAnimation(animacioBanana);
    }

}
