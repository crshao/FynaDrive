package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fynadriver.R;
import com.google.android.material.button.MaterialButton;

public class Information extends AppCompatActivity {

    public MaterialButton jenis_sampah, ketentuan_penjual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        jenis_sampah = findViewById(R.id.jenis_sampah);
        ketentuan_penjual = findViewById(R.id.ketentuan_penjual);

        jenis_sampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, JenisSampah.class);
                startActivity(intent);
            }
        });

        ketentuan_penjual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, KetentuanPenjual.class);
                startActivity(intent);
            }
        });
    }
}
