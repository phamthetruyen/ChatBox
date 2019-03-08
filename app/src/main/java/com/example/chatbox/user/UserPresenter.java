package com.example.chatbox.user;

import android.content.Context;

import com.example.chatbox.ui.base.BasePresenter;
import com.example.chatbox.ui.base.MvpView;
import com.example.chatbox.utils.CommonUtils;

import java.util.ArrayList;
import java.util.logging.Handler;


public class UserPresenter<V extends UserMvpView> extends BasePresenter<V> implements UserMvpPresenter<V> {


    @Override
    public void toProcessToask() {
        getMvpView().showLoading();
        try {
            Thread.sleep(2000);
            getMvpView().showToask("Hello Is Me !!!");
            getMvpView().hideLoading();

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }


}
