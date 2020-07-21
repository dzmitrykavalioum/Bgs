package com.dzmitrykavalioum.bgs.ui.register;


import android.text.TextUtils;

import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.PresenterContract {

    private RegisterContract.ViewContract view;

    public RegisterPresenter(RegisterContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public String register(String login, String password, String confirmPassword, String dateOfBirth, String location) {
        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            view.showError("Empty login, password, date of birth or location");
        } else if (!password.equals(confirmPassword)) {
            view.showError("Passwords don't match");
        } else {
            User user = new User();
            user.setLogin(login);
           // userResponse.setPassword(password);
            user.setCity(location);
            user.setDateOfBirth(dateOfBirth);
            Call<String> callRegistration = NetworkService.users().registration(user);
            callRegistration.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    view.showMessage(response.body());
                    view.openLoginScreen();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.showError(t.getMessage());
                }
            });

        }

        return null;
    }
}
