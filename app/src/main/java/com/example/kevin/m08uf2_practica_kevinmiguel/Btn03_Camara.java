package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
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
    private static final int SCALE_FACTOR_IMAGE_VIEW = 4;
    private String mDirAbsoluto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn03__camara);

        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        btnAtras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                System.exit(0);
            }
        });
    }

    public void fesFoto(View v) {
        // Se crea el intent para la aplicación de fotos.
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

        // Se crea un nuevo fichero al almacenamiento externo y se le pasa al intent.
        File foto = new File(getExternalFilesDir(null), "fotos2.jpg");
        //File foto = new File(Environment.getExternalStorageDirectory(), "fotos.jpg");
        mDirAbsoluto = foto.getAbsolutePath();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));

        // Se guarda el identificador de la imagen para recuperarla cuando esté hecha.
        identificadorImatge = Uri.fromFile(foto);

        // Arranca la actividad.
        startActivityForResult(intent, APP_CAMERA);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("requestCode", "requestCode: " + requestCode);
        Log.e("RESULT_OK", "RESULT_OK" + RESULT_OK);

        switch (requestCode) {
            case APP_CAMERA:
                if (resultCode == RESULT_OK) {
                    ContentResolver contRes = getContentResolver();
                    contRes.notifyChange(identificadorImatge, null);

                    //Bitmap bitmap;

                    try {
                        /*bitmap = android.provider.MediaStore.Images.Media.getBitmap(contRes, identificadorImatge);
                        int alt = (int) (bitmap.getHeight() * 1080 / bitmap.getWidth());
                        Bitmap reduit = Bitmap.createScaledBitmap(bitmap, 1080, alt, true);
                        imgFoto.setImageBitmap(reduit);*/
                        Bitmap bitmap = escalarBitmap(mDirAbsoluto, SCALE_FACTOR_IMAGE_VIEW);
                        imgFoto.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        Toast.makeText(this, "No se puede cargar la imagen " + identificadorImatge.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
    public Bitmap escalarBitmap(String uri, Integer factor) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = factor;
        bmOptions.inPurgeable = true;
        return rotarBitmap(uri, BitmapFactory.decodeFile(uri, bmOptions));
    }

    private Bitmap rotarBitmap(String Url, Bitmap bitmap) {
        try {
            ExifInterface exifInterface = new ExifInterface(Url);
            int orientacion = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 1);
            Matrix matrix = new Matrix();

            if (orientacion == 6) {
                matrix.postRotate(90);
            } else if (orientacion == 3) {
                matrix.postRotate(180);
            } else if (orientacion == 8) {
                matrix.postRotate(270);
            }

            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                    bitmap.getHeight(), matrix, true); // rotating bitmap
        } catch (Exception e) {
            // TODO:
        }
        return bitmap;
    }
}
