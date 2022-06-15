package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class MileageMain extends Fragment {
    View view;
    Button btnBar,btnToChal,btnStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mileage_main, container, false);
        btnBar= view.findViewById(R.id.btn_Bar);
        btnToChal=view.findViewById(R.id.btn_tochal);
        btnStore=view.findViewById(R.id.btn_store);

        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Mpoint.class);
                startActivity(intent);
            }
        });

        btnToChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Challenge.class);
                startActivity(intent);
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), Store.class);
                startActivity(intent);
            }
        });

        return view;
    }
}