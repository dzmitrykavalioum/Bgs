package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.adapters.MeetingAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameItemActivity extends AppCompatActivity {

    private GameCollection gameItem;
    private TextView tv_game_item_title;
    private TextView tv_game_item_gamers;
    private TextView tv_game_item_meetings;
    private MeetingAdapter meetingAdapter;
    private ListView lvMeetings;
    private List<Meeting> meetingList;
    private List<Meeting> userMeetingList;
    private List<GameCollection> updatedListGames;

    private UserResponse userResponse;
    private Button btn_del_game;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        context = this;
        tv_game_item_title = (TextView) findViewById(R.id.tv_game_item_title);
        lvMeetings = (ListView) findViewById(R.id.lv_item_meetings);
        btn_del_game = (Button)findViewById(R.id.btn_del_game);
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            gameItem = (GameCollection) arguments.getSerializable(GameCollection.class.getSimpleName());
            userResponse = (UserResponse) arguments.getSerializable(UserResponse.class.getSimpleName());
            Log.i("response", userResponse.getLogin()+ " is here");
            tv_game_item_title.setText(gameItem.getTitle());

            update(userResponse.getId());
//            meetingList = gameItem.getMeetings();
//            if (meetingList != null) {
//                meetingAdapter = new MeetingAdapter(this, (ArrayList<Meeting>) meetingList, userResponse);
//                lvMeetings.setAdapter(meetingAdapter);
//                //meetingAdapter.notifyDataSetChanged();
 //           }

        }
        btn_del_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<UserResponse> deleteCall = NetworkService.users().deleteGame(userResponse.getId(),gameItem.getId());
                deleteCall.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        btn_del_game.setText(R.string.done);
                        btn_del_game.setClickable(false);
                        Intent intent = new Intent();
                        UserResponse newUser = response.body();
                        intent.putExtra(UserResponse.class.getSimpleName(),newUser);
                        setResult(RESULT_OK,intent);

                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    public void update(int userId){
        Toast.makeText(this,"userId" + userId,Toast.LENGTH_SHORT).show();
        Call<List<GameCollection>> callGame = NetworkService.users().userGameList(userId);
        Call<List<Meeting>> callMeeting = NetworkService.users().userMeetingList(userId);
        callGame.enqueue(new Callback<List<GameCollection>>() {
            @Override
            public void onResponse(Call<List<GameCollection>> call, Response<List<GameCollection>> response) {
                updatedListGames = (List<GameCollection>) response.body();
                userResponse.setGameCollection(updatedListGames);                                           //game list correction

                for (GameCollection item: updatedListGames) {
                    Log.i("foreach",item.getTitle() +" "+item.getId() + " game Item "+ gameItem.getId());
                    if (item.getId()==gameItem.getId()){

                        meetingList = (ArrayList<Meeting>) item.getMeetings();
                        Log.i("foreach",item.getTitle()+"id ==" );

                        if (meetingList != null) {
                            Log.i("foreach", item.getTitle()+ "list not null");
                            meetingAdapter = new MeetingAdapter(context, (ArrayList<Meeting>) meetingList, userResponse);
                            lvMeetings.setAdapter(meetingAdapter);
                            meetingAdapter.notifyDataSetChanged();
                            break;
                        }
                    }
                }
                                                                                                            //here was foreach

            }

            @Override
            public void onFailure(Call<List<GameCollection>> call, Throwable t) {

            }
        });


        callMeeting.enqueue(new Callback<List<Meeting>>() {
            @Override
            public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {
                userMeetingList = response.body();
                userResponse.setMeetingSet(userMeetingList);
            }

            @Override
            public void onFailure(Call<List<Meeting>> call, Throwable t) {

            }
        });
//

    }
}
