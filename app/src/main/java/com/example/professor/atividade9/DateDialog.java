package com.example.professor.atividade9;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDateSetListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnDateSetListener)) {
            throw new IllegalArgumentException("Activity deve implementar DateDialog.OnDateSetListener");
        }

        this.listener = (OnDateSetListener) context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        listener.onDataSet(year, month, dayOfMonth);
    }

    public interface OnDateSetListener{
        void onDataSet(int year, int month, int day);
    }
}
