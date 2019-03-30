package com.dhimas.absenapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dhimas.absenapp.home.HomeActivity;
import com.dhimas.absenapp.MethodUtils;
import com.dhimas.absenapp.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText userName;
    private EditText pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();
        initEvent();
        if (MethodUtils.isDeviceRooted() || MethodUtils.isEmulator()) {
            Toast.makeText(this, "Your device is rooted", Toast.LENGTH_LONG).show();
            Handler myHandler = new Handler();
            myHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        }
    }

    private void initComponent() {
        loginBtn = findViewById(R.id.loginBtn);
        userName = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
    }

    private void initEvent() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(userName.getText().toString()) && !TextUtils.isEmpty(pwd.getText().toString())) {
                    pushToHome();
                }
                 else {
                    MethodUtils.showDialog("Mohon lengkapi seluruh field", LoginActivity.this);
                }
            }
        });
    }

    private void pushToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
