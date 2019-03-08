package com.example.chatbox.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.chatbox.R;
import com.example.chatbox.ui.base.BaseFragment;

public class UserFragment extends BaseFragment implements UserMvpView {
    Button btnSubmit;
    UserPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        presenter = new UserPresenter();
        presenter.onAttach(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.toProcessToask();
            }
        });
        return view;
    }

    @Override
    public void showToask(String mess) {
        Toast.makeText(getContext(), mess, Toast.LENGTH_SHORT).show();
    }
}
