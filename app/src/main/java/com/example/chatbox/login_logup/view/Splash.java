package com.example.chatbox.login_logup.view;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatbox.Main2Activity;
import com.example.chatbox.R;
import com.example.chatbox.login_logup.presenter.PresenterSignIn;
import com.example.chatbox.login_logup.presenter.PresenterSignUp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Splash extends AppCompatActivity implements  IViewSignIn,View.OnClickListener,IViewSignUp{
    EditText edtPhone,edtPassword;
    Button btnSingIn;
    PresenterSignIn presenterSignIn;
    String phone,pass,name;
    TextView txtSignUp;
    PresenterSignUp presenterSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        btnSingIn = (Button) findViewById(R.id.btnSignIn);
        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        // Khai báo Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        //
        presenterSignIn = new PresenterSignIn(this);
        presenterSignUp =  new PresenterSignUp(this);
        btnSingIn.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignIn:
                final String username,password;
                username = edtPhone.getText().toString();
                password = edtPassword.getText().toString();
                presenterSignIn.CheckSignIn(username,password);
                break;
            case R.id.txtSignUp:
                final Dialog dialog = new Dialog(Splash.this);
                dialog.setCancelable(false);
                dialog.setTitle("Đăng ký");
                dialog.setContentView(R.layout.activity_sign_up);
                final EditText edtPhone1 = (EditText) dialog.findViewById(R.id.edtPhone);
                final EditText edtPass1 = (EditText) dialog.findViewById(R.id.edtPass);
                final EditText edtName1 = (EditText) dialog.findViewById(R.id.edtName);
                Button btnSignUp = (Button) dialog.findViewById(R.id.btnSignUp);
                Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
                btnSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        phone = edtPhone1.getText().toString().trim();
                        pass = edtPass1.getText().toString();
                        name = edtName1.getText().toString();
                        presenterSignUp.Register(name,phone,pass);
                        dialog.cancel();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;

        }
    }

    @Override
    public void SignInSuccessfully() {
        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
        Intent activity2 = new Intent(Splash.this, Main2Activity.class);
        startActivity(activity2);
    }

    @Override
    public void SignInFall() {
        Toast.makeText(this, "Fall", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void SignUpSuccessfully() {

    }

    @Override
    public void SignUpFall() {

    }
}
