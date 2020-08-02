package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fynadriver.R;

public class UserHomepage extends AppCompatActivity {

    ImageView information, pickup;
    String username, nohp;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        SharedPreferences preference = getSharedPreferences("pref", MODE_PRIVATE);
        username = preference.getString("username", "");

        nohp = bundle.getString("nohp");

        information = findViewById(R.id.information);
        pickup = findViewById(R.id.pickup);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        try {
            tv1.setText(username);
            tv2.setText(nohp);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHomepage.this, Information.class);
                startActivity(intent);
            }
        });

        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHomepage.this, PickUp.class);
                startActivity(intent);
            }
        });
    }

    public void move_to_profile(View view)
    {
        Intent intent = new Intent(this, UserProfile.class);
        intent.putExtra("nohp", nohp);
        startActivity(intent);
    }
}
