package com.example.chatbox.user;

import com.example.chatbox.ui.base.MvpPresenter;

public interface UserMvpPresenter<V extends UserMvpView> extends MvpPresenter<V> {
    void toProcessToask();
}
