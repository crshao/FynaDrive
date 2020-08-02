package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fynadriver.R;

public class UserProfile extends AppCompatActivity {

    public TextView tv_username, tv_nohp;
    String username, nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        username = sharedPreferences.getString("username", "");

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        nohp = bundle.getString("nohp");

        tv_username = findViewById(R.id.username);
        tv_nohp = findViewById(R.id.nohp);

        tv_username.setText(username);
        tv_nohp.setText(nohp);
    }



}
