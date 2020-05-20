package com.dzmitrykavalioum.bgs.ui.gameitem;

import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.List;

public interface GameItemContract {
    interface PresenterContract{
        List<Meeting> getUserMeetings(int userId);
        List<GameCollection> getUserGames (int UserId);
        UserResponse deleteGame(int userId, int gameId);

    }
    interface ViewContract{
        void updateViews(int userId);
        void showLoading();

        void hideLoading();

        void showMessage(String message);


        void showError(String message);


    }
}
