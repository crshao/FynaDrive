package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fynadriver.R;

public class Map1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);
    }

    public void move(View view)
    {
        Intent intent = new Intent(this, Chatroom.class);
        startActivity(intent);
    }
}