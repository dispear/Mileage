package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Store extends AppCompatActivity {
    ImageButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        //listview 내용입니다.
        final String[] storeList = {"살림연구소 친환경 천연 설거지비누 3종","슈가랩 친환경 생분해 빨대","제로웨이스트 천연 수세미",
                "친환경 생분해성 비닐봉투", "친환경 대나무 칫솔","살림연구소 제로웨이스트 천연생분해 대나무칫솔/혀클리너",
                "살림연구소 전자레인지 3분! 재사용하는 친환경 제습제","친환경 종이 완충재/포장재","나무 식기 세트",
                "친환경 밀짚 런치박스 도시락통"};
        ListView list=(ListView) findViewById(R.id.sList);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,storeList);
        list.setAdapter(adapter);

        // list 선택시 구매 화면으로 이동
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //첫번째 listview 내용 선택 시에만 작동합니다.
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent intent =new Intent(getApplicationContext(), Purchase.class);
                    startActivity(intent);
                }
            }
        });

        btnBack=(ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    }

