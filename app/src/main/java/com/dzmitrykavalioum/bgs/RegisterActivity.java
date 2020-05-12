package com.dzmitrykavalioum.bgs;

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

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    //    private static final String KEY_LOGIN = "LOGIN";
//    private static final String KEY_PASSWORD = "PASSWORD";
    private EditText etName;
    private EditText etDateOfBurth;
    private EditText etLocation;
    private EditText etPassword;
    private Button btnSave;
    private String dateOfBirth;
    private String location;
    private Context context;
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = this;
        etName = (EditText) findViewById(R.id.etLoginR);
        etDateOfBurth = (EditText) findViewById(R.id.etAge);

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
        etDateOfBurth.setOnClickListener(new View.OnClickListener() {
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


        Intent intent = getIntent();
        String login = intent.getStringExtra(LoginActivity.KEY_LOGIN);
        String password = intent.getStringExtra(LoginActivity.KEY_PASSWORD);
        etName.setText(login);
        etPassword.setText(password);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
//                try {
//                    dateOfBirth = Integer.parseInt(etAge.getText().toString());
//
//
//                } catch (NumberFormatException e) {
//                    dateOfBirth = 0;
//
                dateOfBirth = etDateOfBurth.getText().toString();
                location = etLocation.getText().toString();
                UserResponse userResponse = new UserResponse();
                userResponse.setLogin(etName.getText().toString());
                userResponse.setPassword(etPassword.getText().toString());
                userResponse.setLocation(etLocation.getText().toString());
                userResponse.setDateOfBirth(dateOfBirth);
                Log.i("registration response", userResponse.toString());
                Call<String> user = NetworkService.users().registration(userResponse);
//                user.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        Log.i("registration response", response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        Log.i("registration response ", t.getMessage());
//                    }
//                });
                user.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        //Log.i("registration response ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        //Log.i("registration response ", t.getMessage());
                    }
                });
                startActivity(intent1);
            }
        });


    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";// "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDateOfBurth.setText(sdf.format(myCalendar.getTime()));
    }


}
