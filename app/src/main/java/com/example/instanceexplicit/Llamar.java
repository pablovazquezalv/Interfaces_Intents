package com.example.instanceexplicit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Llamar extends AppCompatActivity {
    protected  static final int REQUEST_PERMISSION_CALL=100;
    Button btnllamar;
   EditText txtnumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);

        btnllamar=findViewById(R.id.llamarapablo);
        txtnumero=findViewById(R.id.textnumber);

        btnllamar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ObsoleteSdkInt")
            @Override
            public void onClick(View v) {
            String phone = txtnumero.getText().toString().trim();
            if(Build.VERSION.SDK_INT <  Build.VERSION_CODES.M)
            {
                //LA VERSION DE LA API ES DE LAS QUE PIDE ACEPTAR PERMISOS AL INTALAR
                call(phone);

            }//SI NO ES DE ESAS
            else
            {
                //SI LA VERSION Y LOS PERMISOS SON ACEPTADOS
              if(ContextCompat.checkSelfPermission(Llamar.this, Manifest.permission.CALL_PHONE)==  PackageManager.PERMISSION_GRANTED)
              {
                  //LLAMAR (PERMISOS ACEPTADOS)
                  call(phone);
              }
              else
              {
                if (ActivityCompat.shouldShowRequestPermissionRationale(Llamar.this,Manifest.permission.CALL_PHONE))
                {

                }
                else
                {
                    //EL USUARIO RECHAZO LOS PERMISOS 1 VEZ
                    //SE RECHAZARON
                    // RECIBE LOS PERMISOS Y LA ACCION Y RECIBE EL PERMISO (INT)
                }ActivityCompat.requestPermissions(Llamar.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PERMISSION_CALL);
              }
            }
            }
        });
    }

    //
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        //SI EL CODE ES IGUAL AL CODIGO
        if (requestCode==REQUEST_PERMISSION_CALL)
        {    //SI LOS PERMISOS FUERON HABILITADOS
            if (permissions.length>0    && grantResults[0]  ==    PackageManager.PERMISSION_GRANTED)
            {
                //ACCION DE LLAMAR
                String phone = txtnumero.getText().toString().trim();
                call(phone);
            }
            //SI LOS RECHAZA OTRA VEZ
            else
            {
                if (ActivityCompat.shouldShowRequestPermissionRationale(Llamar.this,Manifest.permission.CALL_PHONE))
                {
                    //
                }
                else
                {//SI LOS RECHAZO YA QUE ES LA ULTIMA VEZ DEBE ACTIVALOS MANUALMENTE
                    Toast.makeText(this, "activalos nuevamente manual", Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void call(String phone)
    {
        startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phone)));
    }
}







