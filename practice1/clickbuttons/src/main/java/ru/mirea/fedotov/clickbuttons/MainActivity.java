package ru.mirea.fedotov.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button buttonOk;
    private Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        buttonOk = (Button) findViewById(R.id.btnOk);
        buttonCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener ocBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tvOut.setText("Нажата кнопка ОК");
            }
        };

        View.OnClickListener ocBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tvOut.setText("Нажата кнопка Cancel");
            }
        };

        buttonOk.setOnClickListener(ocBtnOk);
        buttonCancel.setOnClickListener(ocBtnCancel);
    }
}