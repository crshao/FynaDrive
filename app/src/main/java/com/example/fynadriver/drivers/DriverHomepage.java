package com.example.fynadriver.drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.fynadriver.R;
import com.example.fynadriver.users.LoginRegisterUser;
import com.google.firebase.auth.FirebaseAuth;

public class DriverHomepage extends AppCompatActivity {
    public static String nama_bapak;
    public static String plat_nomor;
    public static String kendaraan;
    public static String passwords;
    private ImageView logouts;
    private FirebaseAuth auths;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_homepage);
        init();

        logouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auths.signOut();
                startActivity(new Intent(DriverHomepage.this, MenuLoginRegisterDrive.class));
                finish();
            }
        });
    }

    private void init(){
        logouts = findViewById(R.id.logout);
        progressBar = findViewById(R.id.loadingss);
        auths = FirebaseAuth.getInstance();
    }
}
