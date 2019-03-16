package com.example.dsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.dsc.SignupActivity.prefName;

public class LoginActivity extends AppCompatActivity {
    TextView goToSignup;
    EditText email, password;
    SharedPreferences sharedPreferences;
    public static final String prefName = "prefs" ;
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";
    String storedEmail, storedPassword;
    Boolean loggedIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        goToSignup = findViewById(R.id.signup_link);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sharedPreferences = getSharedPreferences(prefName, Context.MODE_PRIVATE);
        loggedIn = sharedPreferences.getBoolean("loggedIn", false);
        storedEmail = sharedPreferences.getString(Email, null);
        storedPassword = sharedPreferences.getString(Password, null);
        checkLogin();
    }

    private void checkLogin() {
        if(loggedIn){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    public void login(View view){
        if(email.getText().toString().equals(storedEmail) && password.getText().toString().equals(storedPassword)){
            startActivity(new Intent(this, MainActivity.class));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("loggedIn", true);
            editor.apply();
            finish();
        }
        else{
            Toast.makeText(this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToSignup(View view){
        startActivity(new Intent(this, SignupActivity.class));

    }
}
