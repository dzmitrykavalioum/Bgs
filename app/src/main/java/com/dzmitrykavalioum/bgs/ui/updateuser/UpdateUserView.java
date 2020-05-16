package com.dzmitrykavalioum.bgs.ui.updateuser;

import com.dzmitrykavalioum.bgs.interfaces.LoadingView;
import com.dzmitrykavalioum.bgs.model.UserResponse;

public interface UpdateUserView extends LoadingView {

    void updateUserData (UserResponse userResponse);

    void showEmptyError();

    void showErrorNotConfirm();
}
