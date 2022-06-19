package com.example.mileage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Writing extends Activity implements View.OnClickListener {
    FirebaseFirestore Dbase = FirebaseFirestore.getInstance();
    EditText writeTitle, writeContent;
    ImageButton btnBack;
    ImageView ivPicture;
    String id;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing);

        writeContent = (EditText) findViewById(R.id.edt_content);
        writeTitle = (EditText) findViewById(R.id.edt_title);
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        ivPicture = (ImageView) findViewById(R.id.iv_picture);

        findViewById(R.id.btn_register).setOnClickListener(this);


        // 뒤로가기 버튼
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 사진 첨부 클릭 했을 시 갤러리 연결
        ivPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    // 등록 버튼 클릭 함수
    @Override
    public void onClick(View v) {
        Map<String, Object> post = new HashMap<>();
        post.put("id", id);
        post.put("title", writeTitle.getText().toString());
        post.put("content", writeContent.getText().toString());

        /* 데이터베이스 생성이 되지않아 등록 에러 발생
        //board라는 컬렉션안의 post라는 문서를 추가하고 게시글 작성화면에서 입력한 title, content를 firebase에 저장
        //성공하면 "업로드 성공", 실패하면 "업로드 실패" Toast 띄움
        Dbase.collection("board").document(id).set(post)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Writing.this, "업로드 성공", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Writing.this, "업로드 실패", Toast.LENGTH_SHORT).show();
                    }
                }); */
    }
}
