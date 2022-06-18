package com.example.mileage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Challenge extends Activity {
    ImageButton btnBack;
    Button btnDaily1, btnDaily2, btnDaily3, btnWeekly1, btnWeekly2, btnWeekly3;
    ProgressBar pb1, pb2, pb3, pb4, pb5, pb6;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;

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
        dbHelper = new DBHelper(this,"Mileage",null,1);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 첫번째 일일 챌린지
        if (pb1.getProgress() == 100) {
            btnDaily1.setEnabled(true);
            btnDaily1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 100 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 100;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
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
        // 두번째 일일 챌린지
        if (pb2.getProgress() == 100) {
            btnDaily2.setEnabled(true);
            btnDaily2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 100 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 100;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnDaily2.setEnabled(false);
                            btnDaily2.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
        // 세번째 일일 챌린지
        if (pb3.getProgress() == 100) {
            btnDaily3.setEnabled(true);
            btnDaily3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 100 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 100;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnDaily3.setEnabled(false);
                            btnDaily3.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
        // 첫번째 주간 챌린지
        if (pb4.getProgress() == 100) {
            btnWeekly1.setEnabled(true);
            btnWeekly1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 500 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 500;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnWeekly1.setEnabled(false);
                            btnWeekly1.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
        // 두번째 주간 챌린지
        if (pb5.getProgress() == 100) {
            btnWeekly2.setEnabled(true);
            btnWeekly2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 500 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 500;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnWeekly2.setEnabled(false);
                            btnWeekly2.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
        // 세번째 주간 챌린지
        if (pb6.getProgress() == 100) {
            btnWeekly3.setEnabled(true);
            btnWeekly3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Challenge.this);
                    dlg.setMessage("챌린지 완료, 500 마일리지 획득");
                    // 데이터베이스의 마일리지 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    int i = 500;
                    sqlDB.execSQL("UPDATE Mileage SET point = point+'"+i+"';");
                    sqlDB.close();
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            btnWeekly3.setEnabled(false);
                            btnWeekly3.setText("이미 완료한 챌린지");
                        }
                    });
                    dlg.show();
                }
            });
        }
    }
}
