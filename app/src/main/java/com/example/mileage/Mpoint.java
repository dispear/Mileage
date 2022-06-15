package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mpoint extends AppCompatActivity {

    Button btnBack,btnRecycle;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mpoint);

            btnBack=(Button) findViewById(R.id.btn_purchase);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            btnRecycle=(Button) findViewById(R.id.btn_purchase);
            btnRecycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(getApplicationContext(), Photo.class);
                    startActivity(intent);
                }
            });

        }
    }
