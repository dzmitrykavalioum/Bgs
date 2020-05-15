package com.dzmitrykavalioum.bgs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_LOGIN = "LOGIN";
    public static final String KEY_PASSWORD = "PASSWORD";
    private static final String KEY_USER_RESPONCE = "USER_RESPONCE";
    private EditText username_et;
    private EditText password_et;
    private Button login_btn;
    private Button register_btn;
    private TextView loginLocked_tv;
    private TextView attempts_tv;
    private String login;
    private String password;


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
                login = username_et.getText().toString();
                password = password_et.getText().toString();

                Call<UserResponse> user = NetworkService.users().signIn(login, password);
                Log.i("et ", login + " " + password);
                user.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        UserResponse userResponse = response.body();
                        if (userResponse.getLogin() != null) {

                            Log.i("response", userResponse.getLogin() + " " + userResponse.getPassword() + " id = " + userResponse.getId());
                            Intent intent = new Intent(LoginActivity.this, NavBotActivity.class);
                            intent.putExtra(UserResponse.class.getSimpleName(), userResponse);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Login or password not valid", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        UserResponse userResponse = new UserResponse();
                        userResponse.setLogin(login);
                        userResponse.setPassword(password);
                        Intent intent = new Intent(LoginActivity.this, NavBotActivity.class);
                        intent.putExtra(UserResponse.class.getSimpleName(), userResponse);
                        startActivity(intent);
                    }
                });

            }


        });
        register_btn = (Button) findViewById(R.id.button_register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = username_et.getText().toString();
                password = password_et.getText().toString();
                // Toast.makeText(getApplicationContext(), login + " registered", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra(KEY_LOGIN, login);
                intent.putExtra(KEY_PASSWORD, password);
                startActivity(intent);
                //TODO  set registration and autorization  by server
            }
        });
    }
}


