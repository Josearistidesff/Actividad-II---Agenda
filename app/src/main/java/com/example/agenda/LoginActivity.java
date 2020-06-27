package com.example.agenda;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String USER_NAME = "jmatos";
    public static final String PASSWORD = "Jose0422";

    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText)findViewById(R.id.usser);
        password = (EditText)findViewById(R.id.pass);

    }


    public void login(View view){
        // Usuario validado correctamente
        if(USER_NAME.equals(userName.getText().toString()) && PASSWORD.equals(password.getText().toString())){
            Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if(USER_NAME.equals("") && PASSWORD.equals("")){
            Toast.makeText(this,"Sorry, Username and Password Empty",Toast.LENGTH_SHORT).show();}
        else if(USER_NAME.equals("")) {
            Toast.makeText(this,"Sorry, Username is empty",Toast.LENGTH_SHORT).show(); }
        else if (PASSWORD.equals("")) {
            Toast.makeText(this,"Sorry, Password is empty",Toast.LENGTH_SHORT).show();}
        else {
            Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view){
        userName.setText("");
        password.setText("");
    }
}
