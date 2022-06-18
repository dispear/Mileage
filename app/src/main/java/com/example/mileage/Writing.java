package com.example.mileage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
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

        // 사진 첨부 눌렀을 때 갤러리 연결
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

    @Override
    public void onClick(View v) {
        Map<String, Object> post = new HashMap<>();
        post.put("id",id);
        post.put("title",writeTitle.getText().toString());
        post.put("content",writeContent.getText().toString());

        Dbase.collection("board").add(post).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Writing.this,"업로드 성공",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Writing.this,"업로드 실패",Toast.LENGTH_SHORT).show();
            }
        });

        Dbase.collection("board").document(id).set(post)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Writing.this,"업로드 성공",Toast.LENGTH_SHORT).show();
                    }
            }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Writing.this,"업로드 실패",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
