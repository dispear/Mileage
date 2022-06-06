package com.example.mileage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class store extends AppCompatActivity {
    ImageButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        Gallery gallery=(Gallery) findViewById(R.id.bGallery);
        MyGalleryAdapter galAdapter=new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);

        final String[] storeList = {"살림연구소 친환경 천연 설거지비누 3종","슈가랩 친환경 생분해 빨대","제로웨이스트 천연 수세미", "친환경 생분해성 비닐봉투", "친환경 대나무 칫솔"
        ,"살림연구소 제로웨이스트 천연생분해 대나무칫솔/혀클리너","살림연구소 전자레인지 3분! 재사용하는 친환경 제습제","친환경 종이 완충재/포장재","나무 식기 세트","친환경 밀짚 런치박스 도시락통"};
        ListView list=(ListView) findViewById(R.id.sList);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,storeList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent intent =new Intent(getApplicationContext(),purchase.class);
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

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;

        Integer[] brandId={};
        public MyGalleryAdapter(Context c){
            context=c;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }



}
