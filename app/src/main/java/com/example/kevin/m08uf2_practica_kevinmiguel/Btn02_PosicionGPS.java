package com.example.kevin.m08uf2_practica_kevinmiguel;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Btn02_PosicionGPS extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn02__posicion_gps);

        LocationManager gestorLoc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        gestorLoc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1500, 1, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        // Éste evento se ejecutará cuando la posición cambie.
        String text = "Posicion actual:\n" + "Latitud - " + location.getLatitude() + "\n"
                + "Longitud = " + location.getLongitude();
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String s, int status, Bundle bundle) {
        // Éste evento se ejecutará cuando el estado cambie.
        String missatge = "";
        switch (status){
            case LocationProvider.OUT_OF_SERVICE:
                missatge = "GPS status: Out of service";
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                missatge = "GPS status: Temporaly unavailable";
                break;
            case LocationProvider.AVAILABLE:
                missatge = "GPS status: Available";
                break;
        }

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(getApplicationContext(),"GPS activat per l'usuari", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(getApplicationContext(),"GPS desactivat per l'usuari", Toast.LENGTH_LONG).show();

    }
}

