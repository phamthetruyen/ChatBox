package com.example.chatbox.login_logup.presenter;

import android.support.annotation.NonNull;

import com.example.chatbox.login_logup.model.User;
import com.example.chatbox.login_logup.view.IViewSignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PresenterSignIn implements IPresenterSignIn {
    IViewSignIn iViewSignIn;
    public PresenterSignIn (IViewSignIn iViewSignIn){
        this.iViewSignIn = iViewSignIn;
    }
    @Override
    public void CheckSignIn(final String username, final String password) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Kiểm tra xem user tồn tại k
                if (dataSnapshot.child(username).exists()) {
                    // Lấy thông tin user
                    User user = dataSnapshot.child(username).getValue(User.class);
                    user.setPhone(username);//set Phone
                    if (user.getPassword().equals(password)) {
                       iViewSignIn.SignInSuccessfully();
//                                Intent homeIntent = new Intent(Splash.this,Home.class);
//                                Common.currentUser = user;
//                                startActivity(homeIntent);
//                                finish();

                    } else iViewSignIn.SignInFall();
                }
                else {

                    iViewSignIn.SignInFall();
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
