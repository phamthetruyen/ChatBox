package com.example.chatbox.login_logup.presenter;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.chatbox.login_logup.model.User;
import com.example.chatbox.login_logup.view.IViewSignUp;
import com.example.chatbox.login_logup.view.Splash;
import com.google.android.gms.common.oob.SignUp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PresenterSignUp implements IPresenterSignUp {
    IViewSignUp iViewSignUp;

    public PresenterSignUp(IViewSignUp iViewSignUp) {
        this.iViewSignUp = iViewSignUp;
    }
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = database.getReference("User");
    @Override
    public void Register(final String name, final String phone, final String pass) {

        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Kiểm tra xem user tồn tại chưa
                if(dataSnapshot.child(phone).exists()){

                    iViewSignUp.SignUpSuccessfully();
                }
                else {

                    User user = new User(name,pass,phone);
                    table_user.child(phone).setValue(user);
                    iViewSignUp.SignUpFall();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
