package com.example.mileage;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class MileageMain extends Fragment {
    View view;
    TextView tvMileage;
    Button btnBar,btnToChal,btnStore;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mileage_main, container, false);
        tvMileage = view.findViewById(R.id.tv_mileage);
        btnBar= view.findViewById(R.id.btn_Bar);
        btnToChal=view.findViewById(R.id.btn_tochal);
        btnStore=view.findViewById(R.id.btn_store);

        // 데이터베이스의 마일리지 업데이트
        sqlDB = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT point FROM Mileage limit 1",null);

        String strPoint = cursor.getString(0);
        tvMileage.setText("내 보유 마일리지 : " + strPoint);

        cursor.close();
        sqlDB.close();

        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Mpoint.class);
                startActivity(intent);
            }
        });

        btnToChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Challenge.class);
                startActivity(intent);
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Store.class);
                startActivity(intent);
            }
        });

        return view;
    }
}