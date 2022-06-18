package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Photo extends AppCompatActivity {
    Button btnBack, btnRetry;
    ImageView ivPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnRetry = (Button) findViewById(R.id.btn_retry);
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 카메라로 이동
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    // 카메라 재촬영 클릭 이벤트
                    case R.id.btn_retry:
                        // 카메라 기능을 Intent
                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i, 0);
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 카메라 촬영을 하면 이미지뷰에 찍은 사진을 삽입
        if (requestCode == 0 && resultCode == RESULT_OK) {

            // Bundle로 데이터를 입력
            /* Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 이미지뷰에 Bitmap으로 이미지를 입력
            ivPhoto.setImageBitmap(imageBitmap); */
        }
    }
}
