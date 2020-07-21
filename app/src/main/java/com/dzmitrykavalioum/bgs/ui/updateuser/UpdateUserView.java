package com.dzmitrykavalioum.bgs.ui.updateuser;

import com.dzmitrykavalioum.bgs.interfaces.LoadingView;
import com.dzmitrykavalioum.bgs.model.User;

public interface UpdateUserView extends LoadingView {

    void updateUserData (User userResponse);

    void showEmptyError();

    void showErrorNotConfirm();
}
