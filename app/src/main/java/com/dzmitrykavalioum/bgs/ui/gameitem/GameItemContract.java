package com.dzmitrykavalioum.bgs.ui.gameitem;

import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.List;

public interface GameItemContract {
    interface PresenterContract {
        void getUserMeetings(int userId);

        void getUserGames(int userId, int gameId);

        UserResponse deleteGame(int userId, int gameId);

    }

    interface ViewContract {
 //       void updateViews(int userId);

        void updateMeetings(List<Meeting> meetings,List<Meeting> userMeetings, List<GameCollection> games);

        void showLoading();

        void setGames(List<GameCollection> gamesUpd);

        void setMeetings(List<Meeting> meetingsUpd);

        void hideLoading();

        void showMessage(String message);


        void showError(String message);


    }
}
