package com.example.mileage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Challenge extends Activity {
    ImageButton btnBack;
    Button btnDaily1, btnDaily2, btnDaily3, btnWeekly1, btnWeekly2, btnWeekly3;
    ProgressBar pb1, pb2, pb3, pb4, pb5, pb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge);

        btnDaily1 = (Button) findViewById(R.id.btn_daily1);
        btnDaily2 = (Button) findViewById(R.id.btn_daily2);
        btnDaily3 = (Button) findViewById(R.id.btn_daily3);
        btnWeekly1 = (Button) findViewById(R.id.btn_weakly1);
        btnWeekly2 = (Button) findViewById(R.id.btn_weakly2);
        btnWeekly3 = (Button) findViewById(R.id.btn_weakly3);
        pb1 = (ProgressBar) findViewById(R.id.progressBar1);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
        pb3 = (ProgressBar) findViewById(R.id.progressBar3);
        pb4 = (ProgressBar) findViewById(R.id.progressBar4);
        pb5 = (ProgressBar) findViewById(R.id.progressBar5);
        pb6 = (ProgressBar) findViewById(R.id.progressBar6);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (pb1.getProgress() == 100) {
            btnDaily1.setEnabled(true);
            btnDaily1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 100 마일리지 획득");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnDaily1.setEnabled(false);
                            btnDaily1.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
    }
}
