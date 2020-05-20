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
import com.dzmitrykavalioum.bgs.adapters.GameAdapter;
import com.dzmitrykavalioum.bgs.adapters.GameRvAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesContract;
import com.dzmitrykavalioum.bgs.ui.mygames.MyGamesPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesFragment extends Fragment implements MyGamesContract.ViewContract {

    private UserResponse userResponse;
    private List<GameCollection> games;

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
        userResponse = (UserResponse) bundle.getSerializable(UserResponse.class.getSimpleName());
        games = myGamesPresenter.updateGames(userResponse.getId());
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        games = myGamesPresenter.updateGames(userResponse.getId());
    }

    private void initViews(View root) {
        rvGames = root.findViewById(R.id.rv_unsubscrable_games);
        layoutManager = new LinearLayoutManager(root.getContext());
        itemAnimator = new DefaultItemAnimator();
    }

    @Override
    public void showGames(List<GameCollection> games) {
        if (games != null) {
            gameRvAdapter = new GameRvAdapter(games, userResponse.getId(), withBtn);
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
