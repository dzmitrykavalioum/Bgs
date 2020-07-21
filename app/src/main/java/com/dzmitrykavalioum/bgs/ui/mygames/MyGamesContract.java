package com.dzmitrykavalioum.bgs.ui.mygames;

import com.dzmitrykavalioum.bgs.model.Game;

import java.util.List;

public interface MyGamesContract {

    interface PresenterContract {
        List<Game> updateGames(int userId);
    }

    interface ViewContract {
        void showGames(List<Game> games);



        void showLoading();

        void hideLoading();

        void showMessage(String message);


        void showError(String message);


    }
}
