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
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;
import com.dzmitrykavalioum.bgs.ui.createmeeting.CreateMeetingActivity;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameItemActivity extends AppCompatActivity implements GameItemContract.ViewContract {

    public static String KEY_USER_ID = "KEY_USER_ID";
    public static String KEY_GAME_ID = "KEY_GAME_ID";
    public static String KEY_GAME_TITLE = "KEY_GAME_TITLE";
    private GameCollection gameItem;
    private TextView tv_game_item_title;
    private MeetingAdapter meetingAdapter;
    private ListView lvMeetings;
    private List<Meeting> userMeetingList;
    private List<GameCollection> updatedListGames;
    private ProgressBar progressBar;
    private UserResponse userResponse;
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
            gameItem = (GameCollection) arguments.getSerializable(GameCollection.class.getSimpleName());
            userResponse = (UserResponse) arguments.getSerializable(UserResponse.class.getSimpleName());
            Log.i("response", userResponse.getLogin() + " is here");
            tv_game_item_title.setText(gameItem.getTitle());
            setTitle(gameItem.getTitle());
            gameItemPresenter.getUserGames(userResponse.getId(),gameItem.getId());
        }
        btn_del_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameItemPresenter.deleteGame(userResponse.getId(), gameItem.getId());
                finish();

            }
        });
        btn_create_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateMeetingActivity.class);
                intent.putExtra(KEY_USER_ID, userResponse.getId());
                intent.putExtra(KEY_GAME_ID, gameItem.getId());
                intent.putExtra(KEY_GAME_TITLE, gameItem.getTitle());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameItemPresenter.getUserGames(userResponse.getId(),gameItem.getId());

    }

    public void update(int userId){
        gameItemPresenter.getUserGames(userId,gameItem.getId());
    }

    @Override
    public void updateMeetings(List<Meeting> meetings,List<Meeting> userMeetings, List<GameCollection> games) {

        userResponse.setMeetingSet(userMeetings);
        userResponse.setGameCollection(games);
        meetingAdapter = new MeetingAdapter(context, (ArrayList<Meeting>) meetings, userResponse);
        lvMeetings.setAdapter(meetingAdapter);
        meetingAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void setGames(List<GameCollection> gamesUpd) {
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
