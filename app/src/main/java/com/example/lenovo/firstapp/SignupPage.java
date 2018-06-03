package com.example.lenovo.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupPage extends AppCompatActivity {

    private String[] BloodGroup={"A+","A-","B+","B-","AB+","AB-","0+","0-"};

    public EditText name,pass,checkPass,blood,dob,email,phone;
    public Spinner spinn;
    public CalendarView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        initialisation();
    }
    private void initialisation(){
        name=(EditText)findViewById(R.id.NameSignUpText);
        spinn=(Spinner)findViewById(R.id.BloodGroupSelect);
        pass=(EditText)findViewById(R.id.passtext);
        checkPass=(EditText)findViewById(R.id.passre);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, BloodGroup);
//set the spinners adapter to the previously created one.
        spinn.setAdapter(adapter);
        calender=(CalendarView)findViewById(R.id.CalenderDOB);
        calender.setVisibility(View.INVISIBLE);
    }
    public void OpenCalender(View v){
         if(calender.getVisibility()==View.VISIBLE){
        calender.setVisibility(View.INVISIBLE);
         }
        else{
             calender.setVisibility(View.VISIBLE);
             }

    }
    public void LoginPage(View v){
        Intent i =new Intent(SignupPage.this,LoginPage.class);
        startActivity(i);
    }
}
