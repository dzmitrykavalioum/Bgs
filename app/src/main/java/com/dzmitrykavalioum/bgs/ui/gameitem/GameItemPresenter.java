package com.dzmitrykavalioum.bgs.ui.gameitem;

import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameItemPresenter implements GameItemContract.PresenterContract {

    private GameItemContract.ViewContract view;
    private List<Meeting> meetings;
    private List<GameCollection> games;
    private UserResponse userResponse;

    public GameItemPresenter(GameItemContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public List<Meeting> getUserMeetings(int userId) {
        //meetings = null;
        Call<List<Meeting>> callMeetings = NetworkService.users().userMeetingList(userId);
        view.showLoading();
        callMeetings.enqueue(new Callback<List<Meeting>>() {
            @Override
            public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {
                meetings = response.body();
                view.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Meeting>> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());

            }
        });

        return meetings;
    }

    @Override
    public List<GameCollection> getUserGames(int userId) {
        //games = null;
        Call<List<GameCollection>> callGames = NetworkService.users().userGameList(userId);
        view.showLoading();
        callGames.enqueue(new Callback<List<GameCollection>>() {
            @Override
            public void onResponse(Call<List<GameCollection>> call, Response<List<GameCollection>> response) {
                games = response.body();
                view.hideLoading();
                if (games!=null){
                    view.showMessage("games not nul");
                }
                else {
                    view.showMessage("gamer is nullllllllll");
                }
            }

            @Override
            public void onFailure(Call<List<GameCollection>> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
        return games;
    }

    @Override
    public UserResponse deleteGame(int userId, int gameId) {
        //userResponse = null;
        Call<UserResponse> callDelete = NetworkService.users().deleteGame(userId,gameId);
        view.showLoading();
        callDelete.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                userResponse = response.body();
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
        return userResponse;
    }
}
