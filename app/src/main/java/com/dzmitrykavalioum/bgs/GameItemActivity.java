package com.dzmitrykavalioum.bgs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.dzmitrykavalioum.bgs.model.GameCollection;

public class GameItemActivity extends AppCompatActivity {

    GameCollection gameItem;
    TextView tv_game_item_title;
    TextView tv_game_item_gamers;
    TextView tv_game_item_meetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        tv_game_item_title = (TextView)findViewById(R.id.tv_game_item_title);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            gameItem = (GameCollection) arguments.getSerializable(GameCollection.class.getSimpleName());
            tv_game_item_title.setText(gameItem.getTitle());
        }


    }
}
