package com.dzmitrykavalioum.bgs.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.ui.NavBotActivity;
import com.dzmitrykavalioum.bgs.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.ViewContract {

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
    private LoginPresenter loginPresenter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginPresenter = new LoginPresenter(this);
        initViews();


    }

    private void initViews() {
        username_et = (EditText) findViewById(R.id.edit_user);
        password_et = (EditText) findViewById(R.id.edit_password);
        login_btn = (Button) findViewById(R.id.button_login);
        progressBar = findViewById(R.id.pb_loading_login);
        login_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                login = username_et.getText().toString();
                password = password_et.getText().toString();
                loginPresenter.login(login, password);

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

    @Override
    public void openMainScreen(UserResponse userResponse) {
        Intent intent = new Intent(LoginActivity.this, NavBotActivity.class);
        intent.putExtra(UserResponse.class.getSimpleName(), userResponse);
        startActivity(intent);
    }

    @Override
    public void showMessageError(String error) {
            Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);

    }
}


