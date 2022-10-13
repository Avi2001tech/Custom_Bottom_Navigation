package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_bar = findViewById(R.id.bottom_bar);

        bottom_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.nav_home){
                    loadFrag(new home_fragement(),true);
                } else if(id == R.id.nav_challenge){
                    loadFrag(new Challenge_fragment(),false);
                } else if(id == R.id.nav_leaderboard){
                    loadFrag(new Leaderboard_fragment(),false);
                } else if(id == R.id.nav_create){
                    loadFrag(new Create_fragment(),false);
                }else{//avtar
                    loadFrag(new Avtar_fragment(),false);
                }
                return true;
            }
        });
        bottom_bar.setSelectedItemId(R.id.nav_home);


    }
    public void loadFrag(Fragment frag,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_screen,frag);
        ft.commit();
    }
}