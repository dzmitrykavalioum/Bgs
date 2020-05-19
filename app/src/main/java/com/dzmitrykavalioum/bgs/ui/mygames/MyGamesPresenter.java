package com.dzmitrykavalioum.bgs.ui.mygames;

import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyGamesPresenter implements MyGamesContract.PresenterContract {

    private MyGamesContract.ViewContract view;
    private List<GameCollection> games;
    private boolean isMyGames;

    public MyGamesPresenter(MyGamesContract.ViewContract view, boolean isMyGames) {
        this.view = view;
        this.isMyGames = isMyGames;
    }

    @Override
    public List<GameCollection> updateGames(int userId) {
        Call<List<GameCollection>> callGames;
        if (isMyGames)
            callGames = NetworkService.users().userGameList(userId);
        else
            callGames = NetworkService.users().unsubscribleGameList(userId);

        view.showLoading();
        callGames.enqueue(new Callback<List<GameCollection>>() {
            @Override
            public void onResponse(Call<List<GameCollection>> call, Response<List<GameCollection>> response) {
                games = response.body();
                view.hideLoading();
                view.showGames(games);

            }

            @Override
            public void onFailure(Call<List<GameCollection>> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });


        return games;
    }
}
