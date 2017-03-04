package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn04 = (Button) findViewById(R.id.btn04);

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
