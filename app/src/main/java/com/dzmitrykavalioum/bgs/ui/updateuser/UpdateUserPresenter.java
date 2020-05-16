package com.dzmitrykavalioum.bgs.ui.updateuser;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUserPresenter {

    //private final LifecycleHandler lifecycleHandler;
    private final UpdateUserView updateUserView;

    public UpdateUserPresenter( @NonNull UpdateUserView updateUserView) {   //@NonNull LifecycleHandler lifecycleHandler,
        //this.lifecycleHandler = lifecycleHandler;
        this.updateUserView = updateUserView;
    }

    public void tryUpdateUserData(int id,String login, String password, String confirmPassword, String dateOfBirth, String location) {
        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            updateUserView.showEmptyError();
        } else if (!password.equals(confirmPassword)) {
            updateUserView.showErrorNotConfirm();
        } else {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(id);
            userResponse.setLogin(login);
            userResponse.setPassword(password);
            userResponse.setLocation(location);
            userResponse.setDateOfBirth(dateOfBirth);
            updateUserView.showLoading();                           //show loading process
            Call<UserResponse> callUpdate = NetworkService.users().update(id,userResponse);
            callUpdate.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    UserResponse userResponse = response.body();
                    updateUserView.updateUserData(userResponse);
                    updateUserView.hideLoading();                   //hide loading process
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });
        }
    }
}
