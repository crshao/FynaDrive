package com.example.fynadriver.drivers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fynadriver.R;

public class MenuLoginRegisterDrive extends AppCompatActivity implements View.OnClickListener {

    private CardView login, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_login_register_drive);
        login = findViewById(R.id.sign_in_driver);
        signup = findViewById(R.id.sign_up_driver);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_driver:
                startActivity(new Intent(MenuLoginRegisterDrive.this, LoginDrive.class));
                break;
            case R.id.sign_up_driver:
                startActivity(new Intent(MenuLoginRegisterDrive.this, RegisterDrive.class));
                break;
        }
    }
}
