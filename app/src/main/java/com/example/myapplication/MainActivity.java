package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPagerImage);
        List<SlidersItam> slidersItams = new ArrayList<>();
        slidersItams.add(new SlidersItam(R.drawable.obraz1));
        slidersItams.add(new SlidersItam(R.drawable.obraz2));
        slidersItams.add(new SlidersItam(R.drawable.obraz4));
        viewPager2.setAdapter(new SliderAdapter(slidersItams, viewPager2));
    }
}