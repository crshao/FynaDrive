package com.example.fynadriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fynadriver.users.LoginRegisterUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button driver, pengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        driver = findViewById(R.id.driver);
        pengguna = findViewById(R.id.pengguna);

        driver.setOnClickListener(this);
        pengguna.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.driver:
                startActivity(new Intent(MainActivity.this, SplashScreenDrive.class));
                SplashScreenDrive.IS_USER = false;
                break;
            case R.id.pengguna:
                startActivity(new Intent(MainActivity.this, SplashScreenDrive.class));
                SplashScreenDrive.IS_USER = true;
                break;
        }
    }
}
