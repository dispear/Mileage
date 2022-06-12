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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper);

        final String[] trashList = {"가격표", "골판지", "광고전단지", "명함", "쌀포대", "서류봉투", "신문지", "전단지", "종이상자", "치킨박스", "탁상달력"};
        ListView list = (ListView) findViewById(R.id.tList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trashList);
        list.setAdapter(adapter);

        // 종이류 리스트
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        AlertDialog.Builder dlg1 = new AlertDialog.Builder(Paper.this);
                        dlg1.setTitle("가격표");
                        dlg1.setMessage("종이류 분리배출 장소에 배출합니다.");
                        dlg1.setPositiveButton("확인", null);
                        dlg1.show();
                        break;
                    case 1:
                        AlertDialog.Builder dlg2 = new AlertDialog.Builder(Paper.this);
                        dlg2.setTitle("골판지");
                        dlg2.setMessage("압착하여 종이류 분리배출 장소에 배출합니다.");
                        dlg2.setPositiveButton("확인", null);
                        dlg2.show();
                        break;
                    case 2:
                        AlertDialog.Builder dlg3 = new AlertDialog.Builder(Paper.this);
                        dlg3.setTitle("광고전단지");
                        dlg3.setMessage("종이류 분리배출 방법대로 배출하되, 비닐코팅된 종이는 일반쓰레기로 배출합니다.");
                        dlg3.setPositiveButton("확인", null);
                        dlg3.show();
                        break;
                }
            }
        });

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // 종이류 분류법 보기
        ibCategory = (ImageButton) findViewById(R.id.ib_category);
        ibCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Paper.this);
                dlg.setTitle("종이류 분류 방법");
                dlg.setMessage("책자, 노트\n비닐 코딩된 표지, 공책의 스프링 등을 제거한 후 배출.\n상자류\n테이프, 철핀 등을 제거한 후 압착하여 배출\n종이팩, 종이컵\n내용물을 비우고 물로 헹구어 압착하여 배출. 일반 종이류와 구별하여 종이팩 수거함으로 배출.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

    }
}
