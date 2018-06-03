package com.example.lenovo.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignupPage extends AppCompatActivity {

    private String[] BloodGroup={"A+","A-","B+","B-","AB+","AB-","0+","0-"};

    public EditText name,pass,checkPass,blood,dob,email,phone;
    public Spinner spinn;
    public EncryptPass ency;
    public String nam,password,repaas,bloodGroup,dDOb,mail,phn;
    public TextView wrongPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        initialisation();
    }
    private void initialisation() {
        name = (EditText) findViewById(R.id.NameSignUpText);
        spinn = (Spinner) findViewById(R.id.BloodGroupSelect);
        pass = (EditText) findViewById(R.id.passtext);
        dob = (EditText) findViewById(R.id.DOBTExt);
        email = (EditText) findViewById(R.id.EmailTExt);
        checkPass = (EditText) findViewById(R.id.passre);
        phone = (EditText) findViewById(R.id.PhoneText);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, BloodGroup);
//set the spinners adapter to the previously created one.
        spinn.setAdapter(adapter);
        wrongPass=(TextView)findViewById(R.id.PasswrongText);
        wrongPass.setVisibility(View.INVISIBLE);
        spinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
               bloodGroup=arg0.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
    public void SignUp(View v) {
        int checkNum = 0;
        int loginAccess = 0;
        nam = name.getText().toString();
        password = pass.getText().toString();
        repaas = checkPass.getText().toString();
        dDOb = dob.getText().toString();
        mail = email.getText().toString();
        phn = phone.getText().toString();

        if (nam.equals("")) {
            checkNum = 1;
        }
        if (password.equals("")) {
            checkNum = 1;
        }
        if (repaas.equals("")) {
            checkNum = 1;
        }
        if (dDOb.equals("")) {
            checkNum = 1;
        }

        if (mail.equals("")) {
            checkNum = 1;
        }

        if (phn.equals("")) {
            checkNum = 1;
        }
        if (checkNum == 0) {
            if (password.equals(repaas)) {
                loginAccess = 1;
                wrongPass.setVisibility(View.INVISIBLE);
            } else {
                loginAccess = 0;
                wrongPass.setVisibility(View.VISIBLE);
            }
        }
        String encyPass= null;
        try {
            encyPass = ency.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (loginAccess == 1) {
            Toast.makeText(getApplicationContext(), nam + " " + encyPass + " " + dDOb + " " + mail + " " + phn + " " + bloodGroup, Toast.LENGTH_LONG).show();
        }
    }

    public void LoginPage(View v){

        Intent i =new Intent(SignupPage.this,LoginPage.class);
        startActivity(i);
    }
}
