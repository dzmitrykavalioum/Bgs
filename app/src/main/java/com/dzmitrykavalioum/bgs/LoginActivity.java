package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String KEY_LOGIN = "LOGIN";
    private static final String KEY_PASSWORD = "PASSWORD";
    private EditText username_et;
    private EditText password_et;
    private Button login_btn;
    private Button register_btn;
    private TextView loginLocked_tv;
    private TextView attempts_tv;
    private  String login;
    private  String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        username_et = (EditText) findViewById(R.id.edit_user);
        password_et = (EditText) findViewById(R.id.edit_password);
        login_btn = (Button) findViewById(R.id.button_login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username_et.getText().toString().equals("admin") &&
                        password_et.getText().toString().equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "access denied", Toast.LENGTH_SHORT).show();
                }
            }


        });
        register_btn = (Button)findViewById(R.id.button_register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = username_et.getText().toString();
                password = password_et.getText().toString();
                Toast.makeText(getApplicationContext(),login+" registered",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra(KEY_LOGIN,login);
                intent.putExtra(KEY_PASSWORD,password);
                startActivity(intent);
        //TODO  set registration and autorization  by server
            }
        });
    }
}


