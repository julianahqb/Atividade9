package com.example.professor.atividade9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DateDialog.OnDateSetListener, TimeDialog.OnTimeSetListener {

    private TextView txtDateTime;
    String data = "", hora = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDateTime = findViewById(R.id.txtDatetime);

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        data = String.format("%02d/%02d/%d", day, month+1, year);
        hora = String.format("%02d:%02d", hour, minute);
        txtDateTime.setText(data + " " + hora);

        Button btnData = findViewById(R.id.btnData);
        Button btnHora = findViewById(R.id.btnHora);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog dialog = new DateDialog();
                dialog.show(getSupportFragmentManager(), "dateDialog");
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeDialog dialog = new TimeDialog();
                dialog.show(getSupportFragmentManager(), "timeDialog");
            }
        });
    }

    @Override
    public void onDataSet(int year, int month, int day) {
        data = String.format("%02d/%02d/%d", day, month+1, year);
        txtDateTime.setText(data + " " + hora);
    }

    @Override
    public void onTimeSet(int hour, int minute) {
        hora = String.format("%02d:%02d", hour, minute);
        txtDateTime.setText(data + " " + hora);
    }

}
