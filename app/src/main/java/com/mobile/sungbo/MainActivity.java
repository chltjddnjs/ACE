package com.mobile.sungbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        Button search = findViewById(R.id.search);
        ImageView kakaotalk1 = findViewById(R.id.kakaotalk1);
        ImageView kakaotalk2 = findViewById(R.id.kakaotalk2);
        ImageView kakaotalk3 = findViewById(R.id.kakaotalk3);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, factory.class);
                startActivity(intent);
            }
        });
        kakaotalk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.kakao.com/o/sRzv2Qqe"));
                startActivity(intent2);
            }
        });
        kakaotalk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01099554862"));
                startActivity(intent3);
            }
        });
        kakaotalk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01088614949"));
                startActivity(intent5);
            }
        });
    }
}