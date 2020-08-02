package com.example.fynadriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fynadriver.drivers.MenuLoginRegisterDrive;
import com.example.fynadriver.users.LoginRegisterUser;

public class SplashScreenDrive extends AppCompatActivity {
    public static boolean IS_USER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_drive);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (IS_USER){
                    startActivity(new Intent(SplashScreenDrive.this, LoginRegisterUser.class));
                }else{
                    startActivity(new Intent(SplashScreenDrive.this, MenuLoginRegisterDrive.class));
                }
                finish();
            }
        }, 1500);
    }
}
