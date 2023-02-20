package com.basic.demo.verticalBanner;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;


import com.basic.demo.R;

import java.util.ArrayList;
import java.util.List;

public class TextBannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_banner);

        List<Model01> datas01 = new ArrayList<>();
        datas01.add(new Model01("白日依山尽白日依日依山尽日山尽白日依山尽白日依山尽","--->白日依山尽"));
        datas01.add(new Model01("黄河入海流","--->黄河入海流"));
        datas01.add(new Model01("欲穷千里目","--->欲穷千里目"));
        datas01.add(new Model01("更上一层楼","--->更上一层楼"));

        final SampleAdapter01 adapter01 = new SampleAdapter01(datas01);
        final VerticalBannerView banner01 = findViewById(R.id.banner_1);
        banner01.setAdapter(adapter01);
        banner01.start();


    }

}






















