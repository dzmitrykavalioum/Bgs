package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private static final String KEY_LOGIN = "LOGIN";
    private static final String KEY_PASSWORD = "PASSWORD";
    private EditText etName;
    private EditText etAge;
    private EditText etLocation;
    private EditText etPassword;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText)findViewById(R.id.etName);
        etAge = (EditText)findViewById(R.id.etAge);
        etLocation = (EditText)findViewById(R.id.etLocation);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);


        Intent intent = getIntent();
        String login = intent.getStringExtra(KEY_LOGIN);
        String password = intent.getStringExtra(KEY_LOGIN);
        etName.setText(login);
        etPassword.setText(password);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });


    }


}
