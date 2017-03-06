package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class Btn05_Video extends AppCompatActivity {

    private Button btnGrabarVideo;
    private Button btnReproducirVideo;
    private Button btnAtras;
    private VideoView vvPantalla;
    final static int INTENT_GRABAR_VIDEO = 1;
    private Uri uriVideo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn05__video);

        btnGrabarVideo = (Button) findViewById(R.id.btnGrabarVideo);
        btnReproducirVideo = (Button) findViewById(R.id.btnReproducirVideo);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        vvPantalla = (VideoView) findViewById(R.id.vvPantalla);
        btnReproducirVideo.setEnabled(false);

        btnGrabarVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i, INTENT_GRABAR_VIDEO);
            }
        });

        btnReproducirVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Toast.makeText(Btn05_Video.this, "Reproduciendo: " + uriVideo.getPath(), Toast.LENGTH_LONG).show();
                vvPantalla.setVideoURI(uriVideo);
                vvPantalla.start();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == INTENT_GRABAR_VIDEO) {
                uriVideo = data.getData();
                Toast.makeText(this, uriVideo.getPath(), Toast.LENGTH_LONG).show();
                btnReproducirVideo.setEnabled(true);
            }
        } else if (resultCode == RESULT_CANCELED) {
            uriVideo = null;
            Toast.makeText(this, "¡Grabación cancelada!", Toast.LENGTH_LONG).show();
        }
    }
}
