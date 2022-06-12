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
        view = inflater.inflate(R.layout.fragment_recycle_info, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageButton= (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Photo.class);
                startActivity(intent);
            }
        });

        searchView=view.findViewById(R.id.tSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //정확히 paper를 입력했을때
            public boolean onQueryTextSubmit(String s) {
                if(s.equals("paper"))
                {
                    Intent intent =new Intent(getActivity(), Paper.class);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        btnPaper=view.findViewById(R.id.btn_paper);
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Paper.class);
                startActivity(intent);
            }
        });

        return view;
    }
}