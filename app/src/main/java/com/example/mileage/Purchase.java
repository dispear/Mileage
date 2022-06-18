package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Purchase extends AppCompatActivity {
    ImageButton btnBack;
    Button btnPurchase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnPurchase = (Button) findViewById(R.id.btn_purchase);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 결제하기 화면으로 이동
        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Paying.class);
                startActivity(intent);
            }
        });
    }
}

