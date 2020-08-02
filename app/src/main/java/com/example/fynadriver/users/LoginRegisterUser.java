package com.example.fynadriver.users;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fynadriver.MainActivity;
import com.example.fynadriver.R;
import com.example.fynadriver.drivers.server_connection.Driver_client;
import com.example.fynadriver.drivers.server_connection.Driver_interface;
import com.example.fynadriver.users.server_connection_user.ExampleLogin;
import com.example.fynadriver.users.server_connection_user.ResultLogin;

import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRegisterUser extends AppCompatActivity {
    private EditText phone_numbers, passwords;
    private TextView signup, forgets;
    private CardView logins;
    private ProgressBar progressBar;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_user);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
//        final String username = bundle.getString("username");

        init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginRegisterUser.this, RegisterUser.class));
            }
        });

        logins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nomor = phone_numbers.getText().toString();
                String passworda = passwords.getText().toString();
                if (!nomor.isEmpty() && !passworda.isEmpty()){
                    progressBar.setVisibility(View.VISIBLE);
                    Driver_interface driver_interface = Driver_client.getClient().create(Driver_interface.class);
                    Call<ExampleLogin> caller = driver_interface.loginUser(nomor, passworda);
                    caller.enqueue(new Callback<ExampleLogin>() {
                        @Override
                        public void onResponse(Call<ExampleLogin> call, Response<ExampleLogin> response) {
                            if (response.body().getResult() != null){
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(LoginRegisterUser.this, "Berhasil!" , Toast.LENGTH_LONG).show();

                                SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username", username);

                                Intent intent = new Intent(LoginRegisterUser.this, UserHomepage.class);
                                intent.putExtra("nohp", nomor);
                                startActivity(intent);
                                finish();
                            }else{
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(LoginRegisterUser.this, "Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ExampleLogin> call, Throwable t) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginRegisterUser.this, "Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }

    private void init(){
        phone_numbers = findViewById(R.id.phone_numbers);
        passwords = findViewById(R.id.passwords);
        signup = findViewById(R.id.pendaftaran);
        forgets = findViewById(R.id.lupa_password);
        logins = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.login_loading);
    }
}
