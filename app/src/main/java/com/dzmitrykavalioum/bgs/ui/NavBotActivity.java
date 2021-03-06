package com.dzmitrykavalioum.bgs.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.ui.games.GamesFragment;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesFragment;
import com.dzmitrykavalioum.bgs.ui.mymeetings.MyMeetingsFragment;
import com.dzmitrykavalioum.bgs.ui.updateuser.UpdateUserActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NavBotActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private User user;
    private Bundle bundle;
    private  BottomNavigationView navView;
    Fragment fragment;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bot);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        navView = findViewById(R.id.nav_view);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            user = (User) arguments.getSerializable(User.class.getSimpleName());

        }

        fragment = new MyGamesFragment();
        bundle = new Bundle();
        bundle.putSerializable(User.class.getSimpleName(), user);
        fragment.setArguments(bundle);
        setTitle(R.string.menu_my_games);
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
                setTitle(R.string.menu_my_games);
                break;
            case R.id.item_my_meetings:
                fragment = new MyMeetingsFragment();
                fragment.setArguments(bundle);
                setTitle(R.string.menu_my_meetings);
                break;
            case R.id.item_games:
                fragment = new GamesFragment();
                fragment.setArguments(bundle);
                setTitle(R.string.menu_games);
                break;
//            case R.id.item_messages:
//                fragment = new MessagesFragment();
//                fragment.setArguments(bundle);
//                break;
//            case R.id.item_my_friends:
//                fragment = new MyFriendsFragment();
//                fragment.setArguments(bundle);
//                break;

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
                Intent intent = new Intent(NavBotActivity.this, UpdateUserActivity.class);
                intent.putExtra(User.class.getSimpleName(), user);
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
