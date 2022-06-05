package com.example.mileage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity{
    Home fragment_home;
    RecycleInfo fragment_recycle_info;
    comunity fragment_comunity;
    MileageMain fragment_milage_main;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new Home();
        fragment_recycle_info = new RecycleInfo();
        fragment_comunity = new comunity();
        fragment_milage_main = new MileageMain();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_home).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫 번째 탭이 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_home).commit();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "두 번째 탭이 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_recycle_info).commit();
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세 번째 탭이 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_comunity).commit();
                        return true;
                    case R.id.tab4:
                        Toast.makeText(getApplicationContext(), "네 번째 탭이 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_milage_main).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
