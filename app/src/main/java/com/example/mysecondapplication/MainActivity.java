package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_profile = findViewById(R.id.button_profile);
        Button button_settings = findViewById(R.id.button_settings);
        Button button_about = findViewById(R.id.button_about);
        Button button_exer = findViewById(R.id.button_exer);
        Button button_history = findViewById(R.id.button_history);

        button_profile.setOnClickListener(this);
        button_settings.setOnClickListener(this);
        button_about.setOnClickListener(this);
        button_exer.setOnClickListener(this);
        button_history.setOnClickListener(this);

        sharedPrefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_profile) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }
        if (id == R.id.button_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        }
    }
}