package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;


public class RecycleInfo extends Fragment {
    View view;
    ImageButton imageButton;
    Button btnPaper;
    ImageView imageView;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프레그먼트 화면 뷰를 객체화
        view = inflater.inflate(R.layout.fragment_recycle_info, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        searchView = view.findViewById(R.id.tSearch);
        btnPaper = view.findViewById(R.id.btn_paper);

        // 촬영기능 화면으로 이동
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Photo.class);
                startActivity(intent);
            }
        });
        // 분류법 검색시 해당 화면으로 이동
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.equals("paper")) {
                    Intent intent = new Intent(getActivity(), Paper.class);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        // 클릭시에도 해당 화면으로 이동
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Paper.class);
                startActivity(intent);
            }
        });

        return view;
    }
}