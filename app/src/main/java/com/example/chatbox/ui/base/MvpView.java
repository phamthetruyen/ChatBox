package com.example.chatbox.ui.base;

public interface MvpView {
    void showLoading();

    void hideLoading();

    void onError(String message);

    void showMessage(String message);


    boolean isNetworkConnected();
}
