package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MileageMain extends Fragment {
    Button btnToQR,btnToChal,btnStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment_mileage_main,container,false);
        btnToQR=rootView.findViewById(R.id.btn_toQR);
        btnToChal=rootView.findViewById(R.id.btn_tochal);
        btnStore=rootView.findViewById(R.id.btn_store);

        btnToQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),paper.class);
                startActivity(intent);
            }
        });

        btnToChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),challenge.class);
                startActivity(intent);
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),store.class);
                startActivity(intent);
            }
        });

        return inflater.inflate(R.layout.fragment_mileage_main, container, false);
    }
}