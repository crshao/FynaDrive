package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fynadriver.R;
import com.google.android.material.button.MaterialButton;

public class PickUp extends AppCompatActivity {

    public MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PickUp.this, Map1.class);
                startActivity(intent);
            }
        });
        
    }
}
