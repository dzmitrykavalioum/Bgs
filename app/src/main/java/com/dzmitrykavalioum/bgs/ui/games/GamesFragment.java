package com.dzmitrykavalioum.bgs.ui.games;

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

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.GameRvAdapter;
import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesContract;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesPresenter;

import java.util.List;

public class GamesFragment extends Fragment implements MyGamesContract.ViewContract {

    private User user;
    private List<Game> games;

    private RecyclerView rvGames;
    private LinearLayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private GameRvAdapter gameRvAdapter;
    private boolean withBtn = true;
    private View root;
    private MyGamesPresenter myGamesPresenter;
    private boolean isMy = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_game, container, false);
        myGamesPresenter = new MyGamesPresenter(this, isMy);

        initViews(root);

        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable(User.class.getSimpleName());
        games = myGamesPresenter.updateGames(user.getId());
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        games = myGamesPresenter.updateGames(user.getId());
    }

    private void initViews(View root) {
        rvGames = root.findViewById(R.id.rv_unsubscrable_games);
        layoutManager = new LinearLayoutManager(root.getContext());
        itemAnimator = new DefaultItemAnimator();
    }

    @Override
    public void showGames(List<Game> games) {
        if (games != null) {
            gameRvAdapter = new GameRvAdapter(games, user.getId(), withBtn);
            rvGames.setAdapter(gameRvAdapter);
            rvGames.setLayoutManager(layoutManager);
            rvGames.setItemAnimator(itemAnimator);
        }
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
