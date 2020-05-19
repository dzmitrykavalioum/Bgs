package com.dzmitrykavalioum.bgs.ui.register;

import com.dzmitrykavalioum.bgs.model.UserResponse;

public interface RegisterContract {
    interface PresenterContract {
        String register(String login, String password, String confirmPassword, String dateOfBirth, String location);
    }

    interface ViewContract {
        void openLoginScreen();



        void showLoading();

        void hideLoading();

        void showMessage(String message);


        void showError(String message);


    }
}
