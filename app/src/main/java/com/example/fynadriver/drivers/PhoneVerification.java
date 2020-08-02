package com.example.fynadriver.drivers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.example.fynadriver.MainActivity;
import com.example.fynadriver.R;
import com.example.fynadriver.drivers.server_connection.Driver_client;
import com.example.fynadriver.drivers.server_connection.Driver_interface;
import com.example.fynadriver.drivers.server_connection.login_bagian1.ExampleLoginDriver2;
import com.example.fynadriver.drivers.server_connection.login_bagian1.ResultLogin2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneVerification extends AppCompatActivity implements View.OnClickListener {

    private PinEntryEditText verifikasi_code;
    private ImageView ok_lanjut, refreshs;
    private ProgressBar progressBar;
    private String mVerificationId;
    private static String nomor = "";
    //firebase auth object
    private FirebaseAuth mAuth;
    private static List<ExampleLoginDriver2> listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);
        mAuth = FirebaseAuth.getInstance();
        init();

        String mobiles = getIntent().getStringExtra("hp");
        //Toast.makeText(this, mobiles, Toast.LENGTH_SHORT).show();
        sendVerificationCode(mobiles);
        progressBar.setVisibility(View.VISIBLE);
        refreshs.setOnClickListener(this);
        ok_lanjut.setOnClickListener(this);
    }



    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+62" + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    //the callback to detect the verification status
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            progressBar.setVisibility(View.GONE);
            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                verifikasi_code.setText(code);
                //verifying the code
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(PhoneVerification.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            //storing the verification id that is sent to the user
            mVerificationId = s;
        }
    };


    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(PhoneVerification.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            Intent intent = new Intent(PhoneVerification.this, DriverHomepage.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {

                            //verification unsuccessful.. display an error message

                            String message = "Something is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }
                            Toast.makeText(PhoneVerification.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void init(){
        verifikasi_code = findViewById(R.id.txt_pin_entry);
        ok_lanjut = findViewById(R.id.lanjut);
        refreshs = findViewById(R.id.refresh);
        progressBar = findViewById(R.id.loading_verif);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.refresh:
                String mobiles = getIntent().getStringExtra("hp");
                //Toast.makeText(this, mobiles, Toast.LENGTH_SHORT).show();
                sendVerificationCode(mobiles);
                break;
            case R.id.lanjut:
                String code = verifikasi_code.getText().toString();
                if (code.isEmpty() || code.length() < 6) {
                    verifikasi_code.setError("Enter valid code");
                    verifikasi_code.requestFocus();
                    return;
                }
                verifyVerificationCode(code);
                break;
        }
    }
}
