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

public class SignupActivity extends AppCompatActivity {
    TextView goToLogin;
    public static final String prefName = "prefs" ;
    public static final String Name = "nameKey";
    public static final String Mobile = "mobileKey";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";
    public static final String loggedIn = null;
    SharedPreferences sharedPreferences;
    EditText email, password, name, mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        goToLogin = findViewById(R.id.login_link);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.number);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        sharedPreferences = getSharedPreferences(prefName, Context.MODE_PRIVATE);

    }

    private boolean checkEmpty(EditText fields[]) {
        for(EditText textField : fields){
            if(textField.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }

    public void goToLogin(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void signup(View v){
        EditText array[] = {email, password, mobile, name};
        if(checkEmpty(array)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Name, name.getText().toString());
            editor.putString(Email, email.getText().toString());
            editor.putString(Password, password.getText().toString());
            editor.putString(Mobile, mobile.getText().toString());
            editor.putBoolean("loggedIn", true);
            editor.apply();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
