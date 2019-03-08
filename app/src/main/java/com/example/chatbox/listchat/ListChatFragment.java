package com.example.chatbox.listchat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chatbox.R;
import com.example.chatbox.ui.base.BaseActivity;
import com.example.chatbox.ui.base.BaseFragment;


public class ListChatFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_chat, container, false);
        return view;
    }
}
