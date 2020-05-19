package com.dzmitrykavalioum.bgs.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;
import com.dzmitrykavalioum.bgs.ui.login.LoginActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.ViewContract {


    private EditText etLogin;
    private EditText etDateOfBirth;
    private EditText etLocation;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnSave;
    private ProgressBar progressBar;
    private String dateOfBirth;
    private String location;
    private String login;
    private String password;
    private String confirmPassword;

    //   private Context context;
    private RegisterPresenter registerPresenter;
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this);
        initViews();


        //       context = this;


    }

    private void initViews() {
        etLogin = (EditText) findViewById(R.id.etLoginR);
        etDateOfBirth = (EditText) findViewById(R.id.etDateOfBirth);
        progressBar = findViewById(R.id.pb_loading_register);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(view.getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etLocation = findViewById(R.id.etLocation);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSave = (Button) findViewById(R.id.btnSave);


        Intent intent = getIntent();
        login = intent.getStringExtra(LoginActivity.KEY_LOGIN);
        password = intent.getStringExtra(LoginActivity.KEY_PASSWORD);
        etLogin.setText(login);
        etPassword.setText(password);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                dateOfBirth = etDateOfBirth.getText().toString();
                location = etLocation.getText().toString();
                login = etLogin.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                registerPresenter.register(login,password,confirmPassword,dateOfBirth,location);
//                UserResponse userResponse = new UserResponse();
//                userResponse.setLogin(etName.getText().toString());
//                userResponse.setPassword(etPassword.getText().toString());
//                userResponse.setLocation(etLocation.getText().toString());
//                userResponse.setDateOfBirth(dateOfBirth);
//                Call<String> user = NetworkService.users().registration(userResponse);
//                user.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        //Log.i("registration response ", response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        //Log.i("registration response ", t.getMessage());
//                    }
//                });
//                startActivity(intent1);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";// "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void openLoginScreen() {
        finish();
    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
