package com.example.chatbox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.signin.SignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Splash extends AppCompatActivity implements  IViewSignIn,View.OnClickListener{
    EditText edtPhone,edtPassword;
    Button btnSingIn;
    PresenterSignIn presenterSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        btnSingIn = (Button) findViewById(R.id.btnSignIn);

        // Khai báo Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        //
        presenterSignIn = new PresenterSignIn(this);
        btnSingIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignIn:
                String username,password;
                username = edtPhone.getText().toString();
                password = edtPassword.getText().toString();
                presenterSignIn.CheckSignIn(username,password);
        }
    }

    @Override
    public void SignInSuccessfully() {
        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignInFall() {
        Toast.makeText(this, "Fall", Toast.LENGTH_SHORT).show();

    }
}
