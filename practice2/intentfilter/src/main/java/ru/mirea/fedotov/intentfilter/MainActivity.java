package ru.mirea.fedotov.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnUri;
    private Button btnSendInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnUri = (Button) findViewById(R.id.buttonUri);
        btnSendInfo = (Button) findViewById(R.id.buttonOther);

        View.OnClickListener onBtnUri = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("https://www.mirea.ru/");
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
            }
        };


        View.OnClickListener onBtnSendInfo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Федотов Владислав Сергеевич");
                startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
            }
        };

        btnUri.setOnClickListener(onBtnUri);
        btnSendInfo.setOnClickListener(onBtnSendInfo);



    }


}