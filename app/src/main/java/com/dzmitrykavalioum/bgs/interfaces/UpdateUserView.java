package com.dzmitrykavalioum.bgs.interfaces;

import com.dzmitrykavalioum.bgs.model.UserResponse;

public interface UpdateUserView extends LoadingView {

    void updateUserData(UserResponse userResponse);

    void showEmptyError();

    void showErrorNotConfirm();
}
