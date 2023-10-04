package com.example.mysecondapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    private EditText editSexo;
    private EditText editPeso;
    private EditText editAltura;
    private EditText editDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPrefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editSexo = findViewById(R.id.editSexo);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        editDataNascimento = findViewById(R.id.editDataNascimento);

        loadSavedSettings();
    }

    private void loadSavedSettings() {
        String savedPeso = sharedPrefs.getString("peso", "");
        String savedAltura = sharedPrefs.getString("altura", "");
        String savedDataNascimento = sharedPrefs.getString("dataNascimento", "");
        int savedSexo = sharedPrefs.getInt("sexo", -1);

        editPeso.setText(savedPeso);
        editAltura.setText(savedAltura);
        editDataNascimento.setText(savedDataNascimento);

        if (savedSexo != -1) {
            RadioButton radioButton = findViewById(savedSexo);
            radioButton.setChecked(true);
        }
    }

    private void saveSettings() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("peso", editPeso.getText().toString());
        editor.putString("altura", editAltura.getText().toString());
        editor.putString("dataNascimento", editDataNascimento.getText().toString());
        editor.putString("sexo", editSexo.getText().toString());
        editor.apply();
    }
}
