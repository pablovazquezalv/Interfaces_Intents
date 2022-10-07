package com.example.instanceexplicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class Llamadas extends AppCompatActivity {


    int REQUEST_CODE=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamadas);

        verificarPermiso();
    }


    private void verificarPermiso()
    {
        int Permiso=ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(Permiso==PackageManager.PERMISSION_GRANTED)
        {
            ///
            Toast.makeText(this, "permiso aceptado", Toast.LENGTH_SHORT).show();
        }else
        {
        requestPermissions(new String[]{Manifest.permission.SEND_SMS},REQUEST_CODE);
        }
    }
}