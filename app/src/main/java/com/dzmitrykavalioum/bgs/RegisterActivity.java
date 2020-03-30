package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.UserApi;

import retrofit2.Call;

public class RegisterActivity extends AppCompatActivity {

    private static final String KEY_LOGIN = "LOGIN";
    private static final String KEY_PASSWORD = "PASSWORD";
    private EditText etName;
    private EditText etAge;
    private EditText etLocation;
    private EditText etPassword;
    private Button btnSave;
    private int age;
    private String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.etLoginR);
        etAge = (EditText) findViewById(R.id.etAge);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);


        Intent intent = getIntent();
        String login = intent.getStringExtra(KEY_LOGIN);
        String password = intent.getStringExtra(KEY_LOGIN);
        etName.setText(login);
        etPassword.setText(password);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                try {
                    age = Integer.parseInt(etAge.getText().toString());


                } catch (NumberFormatException e) {
                    age = 0;
                }
                location = etLocation.getText().toString();
                UserResponse userResponse = new UserResponse();
                userResponse.setAge(age);

                startActivity(intent1);
            }
        });


    }


}
