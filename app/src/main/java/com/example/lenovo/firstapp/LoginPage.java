package com.example.lenovo.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends Activity {

    public EditText username, password;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
     initialisation();
    }

    private void initialisation() {
        username=(EditText)findViewById(R.id.usernameText);
        password=(EditText)findViewById(R.id.PasswordText);
        login=(Button)findViewById(R.id.LoginBtn);

    }
    public  void SignIn(View v){

    }
    public void SignUpPage(View v){
        Intent i=new Intent(LoginPage.this,SignupPage.class);
        startActivity(i);
    }
    public void ForgotPass(View v){
        //send otp file
    }
}
