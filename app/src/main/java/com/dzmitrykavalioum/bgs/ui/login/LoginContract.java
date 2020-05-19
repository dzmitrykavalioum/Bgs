package com.dzmitrykavalioum.bgs.ui.login;

import com.dzmitrykavalioum.bgs.interfaces.LoadingView;
import com.dzmitrykavalioum.bgs.model.UserResponse;

public interface LoginContract {
    interface PresenterContract{
        UserResponse login(String login, String password);
    }
    interface  ViewContract{
        void openMainScreen (UserResponse userResponse);

        void showMessageError(String error);

        void showLoading();

        void hideLoading();


    }

}
