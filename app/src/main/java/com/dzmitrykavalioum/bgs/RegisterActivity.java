package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

//    private static final String KEY_LOGIN = "LOGIN";
//    private static final String KEY_PASSWORD = "PASSWORD";
    private EditText etName;
    private EditText etAge;
    private EditText etLocation;
    private EditText etPassword;
    private Button btnSave;
    private String dateOfBirth;
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
        String login = intent.getStringExtra(LoginActivity.KEY_LOGIN);
        String password = intent.getStringExtra(LoginActivity.KEY_PASSWORD);
        etName.setText(login);
        etPassword.setText(password);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
//                try {
//                    dateOfBirth = Integer.parseInt(etAge.getText().toString());
//
//
//                } catch (NumberFormatException e) {
//                    dateOfBirth = 0;
//
                dateOfBirth = etAge.getText().toString();
                location = etLocation.getText().toString();
                UserResponse userResponse = new UserResponse();
                userResponse.setLogin(etName.getText().toString());
                userResponse.setPassword(etPassword.getText().toString());
                userResponse.setLocation(etLocation.getText().toString());
                userResponse.setDateOfBirth(dateOfBirth);
                Log.i("registration response",userResponse.toString());
                Call<UserResponse> user = NetworkService.users().registration(userResponse);
                user.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                        Log.i("registration response ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
  //                      Log.i("registration respomse ", t.getMessage());
                    }
                });
                startActivity(intent1);
            }
        });


    }


}
