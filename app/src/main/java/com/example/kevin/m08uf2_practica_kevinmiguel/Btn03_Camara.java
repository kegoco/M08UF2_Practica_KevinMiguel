package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class Btn03_Camara extends AppCompatActivity {

    private Button btnFoto;
    private Button btnAtras;
    private ImageView imgFoto;
    private Uri identificadorImatge = null;
    final static int APP_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn03__camara);

        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        btnFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                // Se crea el intent para la aplicación de fotos.
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

                // Se crea un nuevo fichero al almacenamiento externo y se le pasa al intent.
                File foto = new File(getExternalFilesDir(null), "fotos2.jpg");
                //File foto = new File(Environment.getExternalStorageDirectory(), "fotos.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));

                // Se guarda el identificador de la imagen para recuperarla cuando esté hecha.
                identificadorImatge = Uri.fromFile(foto);

                // Arranca la actividad.
                startActivityForResult(intent, APP_CAMERA);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("requestCode", "requestCode: " + requestCode);
        Log.e("RESULT_OK", "RESULT_OK" + RESULT_OK);

        switch (requestCode) {
            case APP_CAMERA:
                if (resultCode == RESULT_OK) {
                    ContentResolver contRes = getContentResolver();
                    contRes.notifyChange(identificadorImatge, null);

                    Bitmap bitmap;

                    try {
                        bitmap = android.provider.MediaStore.Images.Media.getBitmap(contRes, identificadorImatge);
                        int alt = (int) (bitmap.getHeight() * 1080 / bitmap.getWidth());
                        Bitmap reduit = Bitmap.createScaledBitmap(bitmap, 1080, alt, true);
                        imgFoto.setImageBitmap(reduit);
                    } catch (Exception e) {
                        Toast.makeText(this, "No se puede cargar la imagen " + identificadorImatge.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
