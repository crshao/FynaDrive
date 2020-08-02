package com.example.fynadriver.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fynadriver.R;
import com.example.fynadriver.drivers.server_connection.Driver_client;
import com.example.fynadriver.drivers.server_connection.Driver_interface;
import com.example.fynadriver.users.server_connection_user.ExampleUser;

import java.sql.PreparedStatement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {
    private EditText nama_user, email_user, hp_user, password_user;
    private CardView creat;
    private CheckBox check;
    private ProgressBar progressBar;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        nama_user = findViewById(R.id.namas);
        email_user = findViewById(R.id.emails);
        check = findViewById(R.id.agrees);
        progressBar = findViewById(R.id.loading1);
        hp_user = findViewById(R.id.phone_number);
        password_user = findViewById(R.id.passworda);
        creat = findViewById(R.id.create_accountss);
        creat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = nama_user.getText().toString();
                String emails = email_user.getText().toString();
                String hhphp_user = hp_user.getText().toString();
                String passwords = password_user.getText().toString();

                if (!nama.isEmpty() && !emails.isEmpty() && !hhphp_user.isEmpty() && !passwords.isEmpty() && check.isChecked()){
                    panggil(nama, emails, hhphp_user, passwords);
                }
            }
        });
    }

    void panggil(String name, String email, String no_hp, String password){
        progressBar.setVisibility(View.VISIBLE);
        Driver_interface driver_interface = Driver_client.getClient().create(Driver_interface.class);
        Call<ExampleUser> caller = driver_interface.postingUser(name, email, no_hp, password);
        caller.enqueue(new Callback<ExampleUser>() {
            @Override
            public void onResponse(Call<ExampleUser> call, Response<ExampleUser> response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RegisterUser.this, "Berhasil!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterUser.this, LoginRegisterUser.class);

                SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", nama);
                editor.apply();
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<ExampleUser> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RegisterUser.this, "Gagal!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterUser.this, LoginRegisterUser.class));
                finish();
            }
        });
    }
}
