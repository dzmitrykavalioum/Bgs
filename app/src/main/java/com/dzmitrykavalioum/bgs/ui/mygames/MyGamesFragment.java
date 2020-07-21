package com.dzmitrykavalioum.bgs.ui.mygames;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dzmitrykavalioum.bgs.adapters.GameRvAdapter;
import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.User;

import java.util.List;

public class MyGamesFragment extends Fragment implements MyGamesContract.ViewContract {


    private User user;
    private RecyclerView rvMyGames;
    private GameRvAdapter gameRvAdapter;
    private List<Game> games;
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
            user = (User) bundle.getSerializable(User.class.getSimpleName());
        }
        games = user.getGames();
        showGames(games);
    }

    @Override
    public void onResume() {
        super.onResume();
        games = myGamesPresenter.updateGames(user.getId());
    }

    @Override
    public void showGames(List<Game> games) {
        if (games != null) {
            gameRvAdapter = new GameRvAdapter(games, user, withBtn);
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
