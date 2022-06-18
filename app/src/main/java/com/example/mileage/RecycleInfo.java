package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;


public class RecycleInfo extends Fragment {
    View view;
    ImageButton imageButton;
    Button btnPaper;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recycle_info, container, false);

        // 적립 완료 화면으로 이동
        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Mpoint.class);
                startActivity(intent);
            }
        });

        // searchView로 검색해 이동
        searchView = view.findViewById(R.id.tSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //정확히 paper를 입력했을때
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

        // 종이류 버튼 클릭으로 이동
        btnPaper = view.findViewById(R.id.btn_paper);
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