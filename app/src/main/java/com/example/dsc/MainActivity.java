package com.example.dsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String prefName = "prefs" ;
    SharedPreferences preferences;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.placeholder);
        preferences = getSharedPreferences(prefName, Context.MODE_PRIVATE);
        name.setText("Welcome home, " + preferences.getString("nameKey", "User"));
    }

    public void logOut(View view){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("loggedIn", false);
        editor.apply();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
