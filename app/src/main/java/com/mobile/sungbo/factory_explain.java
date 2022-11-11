package com.mobile.sungbo;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class factory_explain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factory_explain);
        ImageView factory_image =findViewById(R.id.factory_image);
        TextView factory = findViewById(R.id.factory);
        Button call = findViewById(R.id.call);
        TextView company = findViewById(R.id.company);
        TextView car = findViewById(R.id.car);
        TextView address = findViewById(R.id.address);
        TextView pickup = findViewById(R.id.pickup);
        Button back = findViewById(R.id.back);
        Button copyaddress = findViewById(R.id.copyaddress);

        Intent get_explain = getIntent();
        factory_image.setImageResource(get_explain.getIntExtra("factory_image",0));
        factory.setText(get_explain.getStringExtra("factory"));
        company.setText(get_explain.getStringExtra("company"));
        car.setText(get_explain.getStringExtra("car"));
        address.setText(get_explain.getStringExtra("address"));
        String number = get_explain.getStringExtra("number");
        pickup.setText(get_explain.getStringExtra("etc"));
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(call_intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_intent = new Intent(factory_explain.this,factory.class);
                startActivity(back_intent);
            }
        });
        copyaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("주소",address.getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),"복사되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
