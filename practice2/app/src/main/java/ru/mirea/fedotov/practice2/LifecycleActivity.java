package ru.mirea.fedotov.practice2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStart()");
    }


}