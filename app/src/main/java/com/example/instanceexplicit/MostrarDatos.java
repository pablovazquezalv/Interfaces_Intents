package com.example.instanceexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MostrarDatos extends AppCompatActivity {

    EditText nombre_enviar,edad_enviar;
    Button enviar;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        nombre_enviar=findViewById(R.id.text1);
        nombre_enviar=findViewById(R.id.textView3);
        enviar=findViewById(R.id.buttonenviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle enviaDatos = new Bundle();
                enviaDatos.putString("keyDatos",nombre_enviar.getText().toString());

                Intent intent= new Intent(MostrarDatos.this,Datos.class);
                intent.putExtras(enviaDatos);
                startActivity(intent);


            }
        });

    }


}