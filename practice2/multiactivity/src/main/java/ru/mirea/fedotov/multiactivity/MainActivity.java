package ru.mirea.fedotov.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNextActivity = (Button) findViewById(R.id.button);


        View.OnClickListener onBtnNextActivity = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_second);
            }
        };

        btnNextActivity.setOnClickListener(onBtnNextActivity);

    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}