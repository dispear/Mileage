package com.example.mileage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Notice extends Activity {
    ImageButton btnBack, ibLink1, ibLink2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        ibLink1 = (ImageButton) findViewById(R.id.ib_link1);
        ibLink2 = (ImageButton) findViewById(R.id.ib_link2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/seoulkfem/222756495474"));
                startActivity(intent);
            }
        });

        ibLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/seoulfamilyc/222756296821"));
                startActivity(intent);
            }
        });
    }

}
