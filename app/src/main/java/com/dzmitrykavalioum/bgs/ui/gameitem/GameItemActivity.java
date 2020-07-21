package com.dzmitrykavalioum.bgs.ui.gameitem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.MeetingAdapter;
import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.ui.createmeeting.CreateMeetingActivity;

import java.util.ArrayList;
import java.util.List;

public class GameItemActivity extends AppCompatActivity implements GameItemContract.ViewContract {

    public static String KEY_USER_ID = "KEY_USER_ID";
    public static String KEY_GAME_ID = "KEY_GAME_ID";
    public static String KEY_GAME_TITLE = "KEY_GAME_TITLE";
    private Game game;
    private TextView tv_game_item_title;
    private MeetingAdapter meetingAdapter;
    private ListView lvMeetings;
    private List<Meeting> userMeetingList;
    private List<Game> updatedListGames;
    private ProgressBar progressBar;
    private User user;
    private Button btn_del_game;
    private Button btn_create_meeting;
    private Context context;
    private GameItemPresenter gameItemPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        gameItemPresenter = new GameItemPresenter(this);
        initViews();
    }

    private void initViews() {
        context = this;
        tv_game_item_title = findViewById(R.id.tv_game_item_title);
        lvMeetings = findViewById(R.id.lv_item_meetings);
        progressBar = findViewById(R.id.pb_loading_game_item);
        btn_del_game = findViewById(R.id.btn_del_game);
        btn_create_meeting = findViewById(R.id.btn_create_meeting);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            game = (Game) arguments.getSerializable(Game.class.getSimpleName());
            user = (User) arguments.getSerializable(User.class.getSimpleName());
            Log.i("response", user.getLogin() + " is here");
            tv_game_item_title.setText(game.getTitle());
            setTitle(game.getTitle());
            gameItemPresenter.getUserGames(user.getId(), game.getId());
        }
        btn_del_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameItemPresenter.deleteGame(user.getId(), game.getId());
                finish();

            }
        });
        btn_create_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateMeetingActivity.class);
                intent.putExtra(KEY_USER_ID, user.getId());
                intent.putExtra(KEY_GAME_ID, game.getId());
                intent.putExtra(KEY_GAME_TITLE, game.getTitle());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameItemPresenter.getUserGames(user.getId(), game.getId());

    }

    public void update(int userId){
        gameItemPresenter.getUserGames(userId, game.getId());
    }

    @Override
    public void updateMeetings(List<Meeting> meetings,List<Meeting> userMeetings, List<Game> games) {

        user.setMeetings(userMeetings);
        user.setGames(games);
        meetingAdapter = new MeetingAdapter(context, (ArrayList<Meeting>) meetings, user);
        lvMeetings.setAdapter(meetingAdapter);
        meetingAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void setGames(List<Game> gamesUpd) {
        updatedListGames = gamesUpd;

    }

    @Override
    public void setMeetings(List<Meeting> meetingsUpd) {
            userMeetingList = meetingsUpd;
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
