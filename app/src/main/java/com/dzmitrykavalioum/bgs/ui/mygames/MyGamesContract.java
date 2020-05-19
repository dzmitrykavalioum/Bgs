package com.dzmitrykavalioum.bgs.ui.mygames;

import com.dzmitrykavalioum.bgs.model.GameCollection;

import java.util.List;

public interface MyGamesContract {

    interface PresenterContract {
        List<GameCollection> updateGames(int userId);
    }

    interface ViewContract {
        void showGames(List<GameCollection> games);



        void showLoading();

        void hideLoading();

        void showMessage(String message);


        void showError(String message);


    }
}
