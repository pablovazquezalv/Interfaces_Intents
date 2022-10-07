package com.example.instanceexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

TextView tvDatos,tvDatos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        tvDatos=findViewById(R.id.text2);

        Bundle recibedatos=getIntent().getExtras();
        String info =recibedatos.getString("keyDatos");

        tvDatos.setText(info);
    }
}