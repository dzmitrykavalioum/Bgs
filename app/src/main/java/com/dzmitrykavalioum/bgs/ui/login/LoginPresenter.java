package com.dzmitrykavalioum.bgs.ui.login;

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.PresenterContract {

    private LoginContract.ViewContract view;
    private UserResponse userResponse;

    public LoginPresenter(LoginContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public UserResponse login(String login, String password) {
        if (login.equals("") || password.equals("")) {
            view.showMessageError("Login or password is empty");
            return null;
        }
        Call<UserResponse> callLogin = NetworkService.users().signIn(login, password);
        view.showLoading();
        callLogin.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                userResponse = response.body();
                if (userResponse.getLogin() != null) {
                    view.hideLoading();
                    view.openMainScreen(userResponse);
                } else {
                    view.hideLoading();
                    view.showMessageError("Login or password is wrong");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                view.hideLoading();
                view.showMessageError(t.getMessage());
            }
        });
        return userResponse;

    }
}
