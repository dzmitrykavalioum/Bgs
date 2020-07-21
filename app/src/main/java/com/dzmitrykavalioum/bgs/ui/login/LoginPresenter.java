package com.dzmitrykavalioum.bgs.ui.login;

import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.PresenterContract {

    private LoginContract.ViewContract view;
    private User user;

    public LoginPresenter(LoginContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public User login(String login, String password) {
        if (login.equals("") || password.equals("")) {
            view.showMessageError("Login or password is empty");
            return null;
        }
        Call<User> callLogin = NetworkService.users().signIn(login, password);
        view.showLoading();
        callLogin.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                if (user.getLogin() != null) {
                    view.hideLoading();
                    view.openMainScreen(user);
                } else {
                    view.hideLoading();
                    view.showMessageError("Login or password is wrong");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.hideLoading();
                view.showMessageError(t.getMessage());
            }
        });

        return user;

    }
}
