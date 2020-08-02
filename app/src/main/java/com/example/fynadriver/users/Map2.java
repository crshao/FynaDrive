package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fynadriver.R;

public class Map2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);
    }

    public void move(View view)
    {
        Intent intent = new Intent(this, DriverTelepon.class);
        startActivity(intent);
    }
}
