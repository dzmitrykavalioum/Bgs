package com.dzmitrykavalioum.bgs.ui.login;

import com.dzmitrykavalioum.bgs.model.User;

public interface LoginContract {
    interface PresenterContract{
        User login(String login, String password);
    }
    interface  ViewContract{
        void openMainScreen (User user);

        void showMessageError(String error);

        void showLoading();

        void hideLoading();


    }

}
