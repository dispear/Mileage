package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class MileageMain extends Fragment {
    View view;
    Button btnToQR, btnToChal, btnStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프레그먼트 화면 뷰를 객체화
        view = inflater.inflate(R.layout.fragment_mileage_main, container, false);

        btnToQR = view.findViewById(R.id.btn_to_QR);
        btnToChal = view.findViewById(R.id.btn_to_chal);
        btnStore = view.findViewById(R.id.btn_store);

        // QR 코드 촬영
        btnToQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
        // 챌린지 목록으로 이동
        btnToChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Challenge.class);
                startActivity(intent);
            }
        });
        // 마일리지 상점으로 이동
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Store.class);
                startActivity(intent);
            }
        });

        return view;
    }
}