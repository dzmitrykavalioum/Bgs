package com.dzmitrykavalioum.bgs.ui.createmeeting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.ui.GameItemActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateMeetingActivity extends AppCompatActivity implements CreateMeetingContract.ViewContract {
    private TextView tvTitle;
    private EditText etLocation;
    private EditText etDate;
    private Button btnSave;
    private Button btnCancel;
    private int userId;
    private int gameId;
    private String gameTitle;
    private String location;
    private String date;
    private Context context;
    private final Calendar myCalendar = Calendar.getInstance();
    private CreateMeetingPresenter createMeetingPresenter;
    private Meeting meeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);
        createMeetingPresenter = new CreateMeetingPresenter(this);
        initViews();
    }

    private void initViews() {
        context = this;
        Bundle arguments = getIntent().getExtras();

        tvTitle = findViewById(R.id.tv_game_meeting);
        etLocation = findViewById(R.id.etLocationMeeting);
        etDate = findViewById(R.id.etDateMeeting);
        btnSave = findViewById(R.id.btnSaveMeeting);
        if (arguments != null) {
            tvTitle.setText(arguments.getString(GameItemActivity.KEY_GAME_TITLE));
            userId = arguments.getInt(GameItemActivity.KEY_USER_ID);
            gameId = arguments.getInt(GameItemActivity.KEY_GAME_ID);
        }
        btnCancel = findViewById(R.id.btnCancelCreateMeeting);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meeting = new Meeting();
                meeting.setLocation(etLocation.getText().toString());
                meeting.setDateTime(etDate.getText().toString());
                createMeetingPresenter.createMeeting(userId, gameId, meeting);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

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
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";// "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDate.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void openWithSuccess(int userId, int ganeId) {
        Toast.makeText(context, "Success. ", Toast.LENGTH_SHORT).show();
        finish();
    }
}
