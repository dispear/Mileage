package com.example.mileage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mpoint extends AppCompatActivity {

    Button btnBack, btnRecycle;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mpoint);

        // 데이터베이스 관리 클래스
        dbHelper = new DBHelper(this, "Mileage", null, 1);

        // 데이터베이스의 마일리지 업데이트
        sqlDB = dbHelper.getWritableDatabase();
        int number = 3;
        sqlDB.execSQL("UPDATE Mileage SET point = point+'"+number+"';");
        sqlDB.close();

        // 카메라 이벤트
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 분리수거 확인 방법 화면으로 이동
        btnRecycle = (Button) findViewById(R.id.btn_recycle);
        btnRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                startActivity(intent);
            }
        });

    }
}
