package com.example.fynadriver.drivers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fynadriver.R;
import com.example.fynadriver.drivers.server_connection.Driver_client;
import com.example.fynadriver.drivers.server_connection.Driver_interface;
import com.example.fynadriver.drivers.server_connection.register_bagian2.ExampleRegister2;
import com.example.fynadriver.drivers.server_connection.register_bagian_1.ExampleRegister1;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterDrive extends AppCompatActivity implements View.OnClickListener {
    private EditText nama, jenis_kelamin, phone_number, password, kendaraan, platnomor;
    private static EditText tanggal_lahir;
    private CheckBox oke;
    private CardView create;
    private ProgressBar progressBar;
    private Driver_interface driver_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_drive);
        inits();
    }

    private void inits(){
        nama = findViewById(R.id.nama);
        tanggal_lahir = findViewById(R.id.ttl);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        phone_number = findViewById(R.id.phone_number);
        password = findViewById(R.id.password_baru);
        kendaraan = findViewById(R.id.kendaraan);
        platnomor = findViewById(R.id.plat_nomor);
        progressBar = findViewById(R.id.loading1);

        oke = findViewById(R.id.agree);
        create = findViewById(R.id.create_account);

        oke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String namas = nama.getText().toString();
                String tanggal_lahirs = tanggal_lahir.getText().toString();
                String jenis_kelamins = jenis_kelamin.getText().toString();
                String phone_numbers = phone_number.getText().toString();
                if (!namas.isEmpty() && !tanggal_lahirs.isEmpty() && !jenis_kelamins.isEmpty() && !phone_numbers.isEmpty()){
                    oke.setEnabled(false);
                    register_pertama(namas, tanggal_lahirs, jenis_kelamins, phone_numbers);
                }else{
                    Toast.makeText(RegisterDrive.this, "Tolong lengkapi data dulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tanggal_lahir.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    date_pick();
                }
            }
        });
        create.setOnClickListener(this);
    }

    void date_pick(){
        DialogFragment temp = new DatePickerFragment();
        temp.show(getSupportFragmentManager(), "datePicker");
    }

    private void register_pertama(String nama, String ttl, String jenis_kelamin, String phone){
        progressBar.setVisibility(View.VISIBLE);
        driver_interface = Driver_client.getClient().create(Driver_interface.class);
        Call<ExampleRegister1> caller = driver_interface.postingDriver1(nama, ttl, jenis_kelamin, phone);
        caller.enqueue(new Callback<ExampleRegister1>() {
            @Override
            public void onResponse(Call<ExampleRegister1> call, Response<ExampleRegister1> response) {
                Toast.makeText(RegisterDrive.this, "Gagal", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ExampleRegister1> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create_account:
                if (oke.isChecked()){
                    String passwords = password.getText().toString();
                    if (passwords.matches("[0-9]+") && passwords.length() == 6){
                        String kendaraans = kendaraan.getText().toString();
                        String platnomors = platnomor.getText().toString();
                        if (!passwords.isEmpty() && !kendaraans.isEmpty() && !platnomors.isEmpty()){
                            register_kedua(passwords, kendaraans, platnomors);
                        }else{
                            Toast.makeText(RegisterDrive.this, "Tolong lengkapi data dulu", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        password.requestFocus();
                    }
                }else{
                    Toast.makeText(this, "Centang dulu", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void register_kedua(String password, String kendaraans, String plat_nomor){
        progressBar.setVisibility(View.VISIBLE);
        driver_interface = Driver_client.getClient().create(Driver_interface.class);
        Call<ExampleRegister2> caller = driver_interface.postingDriver2(password, kendaraans, plat_nomor);
        caller.enqueue(new Callback<ExampleRegister2>() {
            @Override
            public void onResponse(Call<ExampleRegister2> call, Response<ExampleRegister2> response) {
                Toast.makeText(RegisterDrive.this, "Gagal", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ExampleRegister2> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RegisterDrive.this, "Berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterDrive.this, HabisRegister.class));
                finish();
            }
        });
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            tanggal_lahir.setText(day + "-" + (month + 1) + "-" + year);

        }
    }
}
