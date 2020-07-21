package com.dzmitrykavalioum.bgs.ui.gameitem;

import android.util.Log;

import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameItemPresenter implements GameItemContract.PresenterContract {

    private GameItemContract.ViewContract view;
    private List<Meeting> meetings;
    private List<Meeting> usersMeetings;
    private List<Game> games;
    private User user;


    public GameItemPresenter(GameItemContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void getUserMeetings(int userId) {
        //meetings = null;
        Call<List<Meeting>> callMeetings = NetworkService.users().userMeetingList(userId);
        view.showLoading();
        callMeetings.enqueue(new Callback<List<Meeting>>() {
            @Override
            public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {
                meetings = response.body();
                view.setMeetings(meetings);
                view.hideLoading();


            }

            @Override
            public void onFailure(Call<List<Meeting>> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());

            }
        });


    }

    @Override
    public void getUserGames(int userId, int gameId) {
        //games = null;

        Call<List<Game>> callGames = NetworkService.users().userGameList(userId);

        view.showLoading();
        callGames.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                games = response.body();
                if (games != null) {
                    // show meeting list by game item

                    //TODO
                    //get meetings from game
//                    for (Game item : games) {
//                        if (item.getId() == gameId) {
//                            meetings = (ArrayList<Meeting>) item.getMeetings();
//                            if (meetings != null) {
//                                //                  Log.i("foreach", item.getTitle() + "list not null");
//                                //view.updateMeetings(meetings, games);
//                                break;
//                            }
//                        }
//                    }

                    Call<List<Meeting>> callMeetings = NetworkService.users().userMeetingList(userId);
                    view.showLoading();
                    callMeetings.enqueue(new Callback<List<Meeting>>() {
                        @Override
                        public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {
                            usersMeetings = response.body();
                            view.updateMeetings(meetings,usersMeetings,games);
                        }

                        @Override
                        public void onFailure(Call<List<Meeting>> call, Throwable t) {
                            view.hideLoading();
                            view.showError(t.getMessage());

                        }
                    });

                } else
                    view.showMessage("list is empty");


                view.hideLoading();

                if (games != null) {
                    Log.i("getUserGamse", "games not nul");
                    view.showMessage("games not nul");
                } else {
                    Log.i("getUserGamse", "games is nul!!!!!!!!!!!");
                    view.showMessage("gamer is nullllllllll");
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
                Log.i("getUserGames", "onFailure");
            }
        });

    }

    @Override
    public User deleteGame(int userId, int gameId) {
        //userResponse = null;
        Call<User> callDelete = NetworkService.users().deleteGame(userId, gameId);
        view.showLoading();
        callDelete.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
        return user;
    }
}
