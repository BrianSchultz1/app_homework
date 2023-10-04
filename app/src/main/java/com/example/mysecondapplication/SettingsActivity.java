package com.example.mysecondapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        sharedPrefs = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        loadSavedSettings();
    }

    private void loadSavedSettings() {
        int savedExerciseType = sharedPrefs.getInt("exerciseType", -1);

        if (savedExerciseType != -1) {
            RadioButton radioButton = findViewById(savedExerciseType);
            radioButton.setChecked(true);
        }
    }

    private void saveSettings() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.apply();
    }
}
