package com.dzmitrykavalioum.bgs.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.ui.games.GamesFragment;
import com.dzmitrykavalioum.bgs.ui.messages.MessagesFragment;
import com.dzmitrykavalioum.bgs.ui.myfriends.MyFriendsFragment;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesFragment;
import com.dzmitrykavalioum.bgs.ui.mymeetings.MyMeetingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NavBotActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public TextView tv_name;
    private UserResponse userResponse;
    private Bundle bundle;
    Fragment fragment;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bot);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            userResponse = (UserResponse) arguments.getSerializable(UserResponse.class.getSimpleName());

        }

        fragment = new MyGamesFragment();
        bundle = new Bundle();

        bundle.putSerializable(UserResponse.class.getSimpleName(), userResponse);
        fragment.setArguments(bundle);
        loadFragment(fragment);

        navView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.item_my_games:
                fragment = new MyGamesFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.item_my_meetings:
                fragment = new MyMeetingsFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.item_games:
                fragment = new GamesFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.item_messages:
                fragment = new MessagesFragment();
                break;
            case R.id.item_my_friends:
                fragment = new MyFriendsFragment();
                fragment.setArguments(bundle);
                break;

        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("onActivity", "Activity");
        Toast.makeText(this, "on activity result", Toast.LENGTH_SHORT).show();
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.item_my_games);
//
//        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(NavBotActivity.this, UserDataActivity.class);
                intent.putExtra(UserResponse.class.getSimpleName(), userResponse);
                startActivity(intent);
                break;
            case R.id.action_exit:
                exit();
        }
        return true;

    }

    private void exit() {
        finish();
    }
}
