package com.example.instanceexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnweb,btncamara,btngatito,btnutt;

    String _url="https://www.youtube.com/watch?v=VtKcDwz6hiM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncamara=findViewById(R.id.camara);
        btnweb=findViewById(R.id.web);
        btngatito=findViewById(R.id.gato);
        btnutt=findViewById(R.id.utt);

        btncamara.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(intent,1);
                }
            }
        });

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri _link= Uri.parse(_url);
                Intent i=new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        btngatito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Gato.class));
            }
        });

        btnutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Utt.class));
            }
        });

    }


    @Override
    public void onClick(View v) {

    }


}