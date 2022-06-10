package com.example.mileage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Paper extends AppCompatActivity {
    ImageButton btnBack, ibCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper);

        final String[] trashList = {"가격표","골판지","광고전단지","명함","쌀포대","서류봉투","신문지","전단지","종이상자","치킨박스","탁상달력"};
        ListView list=(ListView) findViewById(R.id.tList);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,trashList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        btnBack=(ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ibCategory=(ImageButton) findViewById(R.id.ib_category);
        ibCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(Paper.this);
                dlg.setTitle("종이류 분류 방법");
                dlg.setMessage("책자, 노트\n비닐 코딩된 표지, 공책의 스프링 등을 제거한 후 배출.\n상자류\n테이프, 철핀 등을 제거한 후 압착하여 배출\n종이팩, 종이컵\n내용물을 비우고 물로 헹구어 압착하여 배출. 일반 종이류와 구별하여 종이팩 수거함으로 배출.");
                dlg.setPositiveButton("확인",null);
                dlg.show();
            }
        });

    }
}
