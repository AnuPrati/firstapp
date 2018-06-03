package com.example.lenovo.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    public Button submit, total;
    public EditText textValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startIntialization();
    }

    private void startIntialization() {
        submit = (Button) findViewById(R.id.Submit_expenses);
        total=(Button)findViewById(R.id.ViewTotalExpenses);
        textValue=(EditText)findViewById(R.id.TextFirst);

    }
    public void Total (View v){
        int x=0;
        x= Integer.parseInt(textValue.getText().toString());
        Intent i;
        i= new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }
}