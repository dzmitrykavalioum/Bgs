package com.dzmitrykavalioum.bgs.ui.updateuser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.interfaces.LoadingView;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.ui.NavBotActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UpdateUserActivity extends AppCompatActivity implements UpdateUserView {
    private EditText etLogin;
    private EditText etDateOfBirth;
    private EditText etLocation;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnSave;
    private Button btnCancel;
    private String dateOfBirth;
    private String location;
    private Context context;
    private UserResponse userResponse;
    private final Calendar myCalendar = Calendar.getInstance();
    private UpdateUserPresenter updateUserPresenter;
    private LoadingView loadingView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            userResponse = (UserResponse) arguments.getSerializable(UserResponse.class.getSimpleName());
            //LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
            updateUserPresenter = new UpdateUserPresenter( this);
            initViews();
        }


    }

    private void initViews() {
        context = this;
        etLogin = (EditText) findViewById(R.id.etLoginR);
        etLogin.setText(userResponse.getLogin());
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword.setText(userResponse.getPassword());
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        etConfirmPassword.setText(userResponse.getPassword());
        etDateOfBirth = (EditText) findViewById(R.id.etDateOfBirth);
        etDateOfBirth.setText(userResponse.getDateOfBirth());
        etLocation = (EditText) findViewById(R.id.etLocation);
        etLocation.setText(userResponse.getLocation());
        progressBar = findViewById(R.id.pb_loading);

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
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etLocation = (EditText) findViewById(R.id.etLocation);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int id = userResponse.getId();
                    String login = etLogin.getText().toString();
                    String password = etPassword.getText().toString();
                    String confirmPassword = etConfirmPassword.getText().toString();
                    String dateOfBirth = etDateOfBirth.getText().toString();
                    String location = etLocation.getText().toString();
                    updateUserPresenter.tryUpdateUserData(id,login,password,confirmPassword,dateOfBirth,location);
            }
        });
        btnCancel = findViewById(R.id.btnExit);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";// "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void updateUserData(UserResponse userResponse) {
        Intent intent = new Intent(this, NavBotActivity.class);
        intent.putExtra(UserResponse.class.getSimpleName(),userResponse);
        startActivity(intent);
    }

    @Override
    public void showEmptyError() {
        Toast.makeText(this, "Empty login or password or confirm password", Toast.LENGTH_SHORT).show();//
    }

    @Override
    public void showErrorNotConfirm() {
        Toast.makeText(this, "Passwords not confirms", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        //loadingView.showLoading();
    }

    @Override
    public void hideLoading() {
       progressBar.setVisibility(ProgressBar.INVISIBLE);
        // loadingView.hideLoading();
    }
}
