package com.example.mileage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Paying extends AppCompatActivity {
    Button btnPaying;
    ImageButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paying);

        btnBack=(ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPaying=(Button) findViewById(R.id.btn_paying);
        btnPaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(Paying.this);

                // 실제로 계산이 이루어지지 않습니다. millage 값을 0 이하로 바꾸면 교환 실패 메시지를 출력합니다.
                int millage=100;
                if (millage<0){
                    dlg.setTitle("교환 실패");
                    dlg.setMessage("마일리지가 부족합니다.");
                    dlg.setPositiveButton("확인",null);
                    dlg.show();
                }
                else {
                    dlg.setTitle("교환 완료");
                    dlg.setMessage("마일리지 교환이 정상적으로 완료되었습니다.");
                    dlg.setPositiveButton("확인",null);
                    dlg.show();
                }
            }
        });
    }
}
