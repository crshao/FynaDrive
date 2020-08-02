package com.example.fynadriver.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fynadriver.R;

public class MasukkanNomorHP extends AppCompatActivity {
    private EditText editText_nomor;
    private ImageView imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masukkan_nomor_hp);
        editText_nomor = findViewById(R.id.no_hps);
        imageViews = findViewById(R.id.lanjutss);
        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_hp = editText_nomor.getText().toString();
                if (!no_hp.isEmpty()){
                    Intent i = new Intent(MasukkanNomorHP.this, PhoneVerification.class);
                    i.putExtra("hp", no_hp);
                    startActivity(i);
                }
            }
        });
    }
}
