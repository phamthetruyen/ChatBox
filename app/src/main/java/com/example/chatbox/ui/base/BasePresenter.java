package com.example.chatbox.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
