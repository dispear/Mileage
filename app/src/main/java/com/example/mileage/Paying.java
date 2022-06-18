package com.example.mileage;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Paying extends AppCompatActivity {
    Button btnPaying;
    ImageButton btnBack;
    TextView tvHave1, tvHave2, tvHave3;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paying);

        // 데이터베이스 관리 클래스
        dbHelper = new DBHelper(this, "Mileage", null, 1);
        // 현재 마일리지 표시
        sqlDB = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT point FROM Mileage limit 1", null);
        cursor.moveToFirst();

        int nowPoint = cursor.getInt(0);
        int i = 450;
        int nextPoint = nowPoint - i;

        cursor.close();
        sqlDB.close();

        tvHave1 = (TextView) findViewById(R.id.tv_have1);
        tvHave2 = (TextView) findViewById(R.id.tv_have2);
        tvHave3 = (TextView) findViewById(R.id.tv_have3);
        tvHave1.setText("보유 마일리지\n" + nowPoint);
        tvHave2.setText("결제할 마일리지\n" + "-" + i);
        tvHave3.setText("남을 마일리지 " + nextPoint);

        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPaying = (Button) findViewById(R.id.btn_paying);
        btnPaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Paying.this);

                // mileage 값을 0 미만으로 바꾸면 교환 실패 메시지를 출력합니다.
                if (nextPoint < 0) {
                    dlg.setTitle("교환 실패");
                    dlg.setMessage("마일리지가 부족합니다.");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                } else {
                    // mileage가 0이상 이면 업데이트
                    sqlDB = dbHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE Mileage SET point = point-'" + i + "';");
                    // 남은 마일리지 출력
                    Cursor cursor;
                    cursor = sqlDB.rawQuery("SELECT point FROM Mileage limit 1", null);
                    cursor.moveToFirst();
                    String strNowPoint = cursor.getString(0);

                    cursor.close();
                    sqlDB.close();

                    dlg.setTitle("교환 완료");
                    dlg.setMessage("마일리지 교환이 정상적으로 완료되었습니다.\n보유 마일리지 : " + strNowPoint);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dlg.show();
                }
            }
        });
    }
}
