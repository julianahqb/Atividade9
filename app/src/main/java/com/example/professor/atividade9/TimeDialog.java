package com.example.professor.atividade9;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimeDialog extends AppCompatDialogFragment implements TimePickerDialog.OnTimeSetListener {

    private OnTimeSetListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnTimeSetListener)) {
            throw new IllegalArgumentException("Activity deve implementar TimeDialog.OnTimeSetListener");
        }

        this.listener = (OnTimeSetListener) context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        listener.onTimeSet(hourOfDay, minute);
    }

    public interface OnTimeSetListener{
        void onTimeSet(int hour, int minute);
    }
}
