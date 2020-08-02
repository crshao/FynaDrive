package com.example.fynadriver.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.fynadriver.MainActivity;
import com.example.fynadriver.R;

public class HabisRegister extends AppCompatActivity {
    private FrameLayout lanjut_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habis_register);
        lanjut_ok = findViewById(R.id.benar);
        lanjut_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HabisRegister.this, MenuLoginRegisterDrive.class));
            }
        });
    }
}
