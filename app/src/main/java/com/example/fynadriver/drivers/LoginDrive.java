package com.example.fynadriver.drivers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.example.fynadriver.R;
import com.example.fynadriver.drivers.server_connection.Driver_client;
import com.example.fynadriver.drivers.server_connection.Driver_interface;
import com.example.fynadriver.drivers.server_connection.login_bagian1.ExampleLoginDriver;

import java.sql.DriverPropertyInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginDrive extends AppCompatActivity implements View.OnClickListener {
    private CardView number1, number2, number3, number4, number5, number6, number7, number8
            , number9, number0;
    private CardView back, ok, lupa;
    private PinEntryEditText password;
    private String setter = "";
    private Driver_interface driverInterface;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_drive);
        init();

        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        number0.setOnClickListener(this);

        back.setOnClickListener(this);
        ok.setOnClickListener(this);
        lupa.setOnClickListener(this);

    }

    void init(){
        number0 = findViewById(R.id.nol);
        number1 = findViewById(R.id.satu);
        number2 = findViewById(R.id.dua);
        number3 = findViewById(R.id.tiga);
        number4 = findViewById(R.id.empat);
        number5 = findViewById(R.id.lima);
        number6 = findViewById(R.id.enam);
        number7 = findViewById(R.id.tujuh);
        number8 = findViewById(R.id.delapan);
        number9 = findViewById(R.id.sembilan);
        back = findViewById(R.id.back);
        ok = findViewById(R.id.ok);
        lupa = findViewById(R.id.lupa);
        password = findViewById(R.id.txt_pin_entry);
        progressBar = findViewById(R.id.login_loading);
        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL){
                    if (setter != null && setter.length() > 0) {
                        setter = setter.substring(0, setter.length() - 1);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.satu:
                setter += "1";
                password.setText(setter);
                break;
            case R.id.dua:
                setter += "2";
                password.setText(setter);
                break;
            case R.id.tiga:
                setter += "3";
                password.setText(setter);
                break;
            case R.id.empat:
                setter += "4";
                password.setText(setter);
                break;
            case R.id.lima:
                setter += "5";
                password.setText(setter);
                break;
            case R.id.enam:
                setter += "6";
                password.setText(setter);
                break;
            case R.id.tujuh:
                setter += "7";
                password.setText(setter);
                break;
            case R.id.delapan:
                setter += "8";
                password.setText(setter);
                break;
            case R.id.sembilan:
                setter += "9";
                password.setText(setter);
                break;
            case R.id.nol:
                setter += "0";
                password.setText(setter);
                break;
            case R.id.back:
                startActivity(new Intent(LoginDrive.this, MenuLoginRegisterDrive.class));
                break;
            case R.id.ok:
                loginterm();
                break;
            case R.id.lupa:
                break;
        }
    }

    private void loginterm(){
        progressBar.setVisibility(View.VISIBLE);
        driverInterface = Driver_client.getClient().create(Driver_interface.class);
        String pass = password.getText().toString();
        DriverHomepage.passwords = pass;
        Call<ExampleLoginDriver> caller = driverInterface.postingDriver3(pass);
        caller.enqueue(new Callback<ExampleLoginDriver>() {
            @Override
            public void onResponse(Call<ExampleLoginDriver> call, Response<ExampleLoginDriver> response) {
                Toast.makeText(LoginDrive.this, "Berhasil;", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ExampleLoginDriver> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginDrive.this, "Berhasil;", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginDrive.this, MasukkanNomorHP.class));
            }
        });
    }
}
