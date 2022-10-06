package com.example.plantonic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Objects;

public class main extends AppCompatActivity {
ImageView home, water, sun, settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        home = findViewById(R.id.home);
        water = findViewById(R.id.water);
        sun = findViewById(R.id.sun);
        settings = findViewById(R.id.settings);
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().replace(R.id.framel, home.class.newInstance(), "home").commit();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.framel)).getTag(), "home")){
                    fragmentManager.popBackStack();

                    home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#39C838")));

                    water.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                    sun.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                    settings.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));

                }
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.framel)).getTag(), "water")){
                    try {
                        fragmentManager.beginTransaction().setCustomAnimations(
                                        R.anim.slide_in,
                                        R.anim.fade_out,
                                        R.anim.fade_in,
                                        R.anim.slide_out
                                )
                                .replace(R.id.framel, water_plants.class.newInstance(), "water")
                                .addToBackStack(null)
                                .commit();

                        water.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#39C838")));

                        home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                        sun.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                        settings.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
         if (getSupportFragmentManager().findFragmentByTag("home") != null && Objects.requireNonNull(getSupportFragmentManager().findFragmentByTag("home")).isVisible()){
                home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#39C838")));

                water.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                sun.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                settings.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8572C075")));
                System.out.println("noa2");

            }else{
                System.out.println("noa");
            }
        }
    }

