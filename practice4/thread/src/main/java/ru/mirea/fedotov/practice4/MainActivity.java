package ru.mirea.fedotov.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    EditText pair;
    EditText days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        // Меняем имя и выводим в текстовом поле
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());


    }


    public void onClick(View view) {
        pair = (EditText) findViewById(R.id.allPairsEdit);
        days = (EditText) findViewById(R.id.teachDaysEdit);

        String pairSome = pair.getText().toString();
        String daysSome = days.getText().toString();

        int first = Integer.parseInt(pairSome);
        int second = Integer.parseInt(daysSome);

        TextView textView;
        textView = (TextView) findViewById(R.id.textView);

        int avg = first / second;
        String res = Integer.toString(avg);

        textView.setText("Среднее кол-во пар в день: " + res);

        Runnable runnable = new Runnable() {
            public void run() {
                int numberThread = counter++;
                Log.i("ThreadProject", "Запущен поток № " + numberThread);
                long endTime = System.currentTimeMillis()
                        + 20 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime -
                                    System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток № " + numberThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

