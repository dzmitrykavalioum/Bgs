package com.dzmitrykavalioum.bgs.ui.mygames;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyGamesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyGamesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is my game fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}