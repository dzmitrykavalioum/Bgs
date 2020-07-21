package com.dzmitrykavalioum.bgs.ui.updateuser;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.dzmitrykavalioum.bgs.model.User;
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
            User user = new User();
            user.setId(id);
            user.setLogin(login);

            //TODO
            //change password

            //user.setPassword(password);
            user.setCity(location);
            user.setDateOfBirth(dateOfBirth);
            updateUserView.showLoading();                           //show loading process
            Call<User> callUpdate = NetworkService.users().update(id,user);
            callUpdate.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User userResponse = response.body();
                    
                    updateUserView.updateUserData(userResponse);
                    updateUserView.hideLoading();                   //hide loading process
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }
    }
}
