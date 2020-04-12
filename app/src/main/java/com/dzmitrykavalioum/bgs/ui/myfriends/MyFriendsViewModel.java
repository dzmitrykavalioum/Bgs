package com.dzmitrykavalioum.bgs.ui.myfriends;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyFriendsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyFriendsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}