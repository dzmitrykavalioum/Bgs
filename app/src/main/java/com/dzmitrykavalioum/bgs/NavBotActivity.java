package com.dzmitrykavalioum.bgs;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.ui.games.GamesFragment;
import com.dzmitrykavalioum.bgs.ui.messages.MessagesFragment;
import com.dzmitrykavalioum.bgs.ui.myfriends.MyFriendsFragment;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NavBotActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public TextView tv_name;
    private UserResponse userResponse;
    private Bundle bundle;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bot);


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
        switch (menuItem.getItemId()){
            case R.id.item_my_games:
                fragment = new MyGamesFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.item_my_friends:
                fragment = new MyFriendsFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.item_games:
                fragment = new GamesFragment();
                break;
            case R.id.item_messages:
                fragment = new MessagesFragment();

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
}
