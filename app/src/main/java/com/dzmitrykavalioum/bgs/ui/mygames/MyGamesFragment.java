package com.dzmitrykavalioum.bgs.ui.mygames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dzmitrykavalioum.bgs.adapters.GameRvAdapter;
import com.dzmitrykavalioum.bgs.ui.gameitem.GameItemActivity;
import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.GameAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class MyGamesFragment extends Fragment implements MyGamesContract.ViewContract {


    private UserResponse userResponse;
    private RecyclerView rvMyGames;
    private GameRvAdapter gameRvAdapter;
    private List<GameCollection> games;
    private LinearLayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private MyGamesPresenter myGamesPresenter;
    private boolean isMy = true;
    private View root;

    private boolean withBtn = false;

    // TODO  game collection update
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_my_games, container, false);
        myGamesPresenter = new MyGamesPresenter(this,isMy);
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        rvMyGames = root.findViewById(R.id.rv_my_games);
        layoutManager = new LinearLayoutManager(root.getContext());
        itemAnimator = new DefaultItemAnimator();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userResponse = (UserResponse) bundle.getSerializable(UserResponse.class.getSimpleName());
        }
        games = userResponse.getGameCollection();
        showGames(games);
    }

    @Override
    public void onResume() {
        super.onResume();
        games = myGamesPresenter.updateGames(userResponse.getId());
    }

    @Override
    public void showGames(List<GameCollection> games) {
        if (games != null) {
            gameRvAdapter = new GameRvAdapter(games, userResponse, withBtn);
            rvMyGames.setAdapter(gameRvAdapter);
            rvMyGames.setLayoutManager(layoutManager);
            rvMyGames.setItemAnimator(itemAnimator);
        } else
            Toast.makeText(getActivity(), "List games is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
