package ru.mirea.fedotov.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private EditText editSave;
    private final String key = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickSave(View view) {
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(key, editSave.getText().toString());
        edit.apply();
    }

    public void onClickGet(View view) {
        editSave.setText(pref.getString(key, "Empty"));
    }

    private void init() {
        pref = getSharedPreferences("NoteBook", MODE_PRIVATE);
        editSave = (EditText) findViewById(R.id.editTextSave);
        editSave.setText(pref.getString(key, "Empty"));
    }
}