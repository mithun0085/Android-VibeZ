package com.example.calendar;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class EventDetailActivity extends AppCompatActivity
{
    private EditText timeEditText, descEditText;
    private Button deleteButton;
    private Event selectedEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        initWidgets();
        checkForEditEvent();
    }

    private void initWidgets()
    {
        timeEditText = findViewById(R.id.timeEditText);
        descEditText = findViewById(R.id.descriptionEditText);
        deleteButton = findViewById(R.id.deleteEventButton);
    }

    private void checkForEditEvent()
    {
        Intent previousIntent = getIntent();

        int passedNoteID = previousIntent.getIntExtra(Event.EVENT_EDIT_EXTRA, -1);
        selectedEvent = Event.getEventForID(passedNoteID);

        if (selectedEvent != null)
        {
            timeEditText.setText(selectedEvent.getTime());
            descEditText.setText(selectedEvent.getDescription());
        }
        else
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    public void saveEvent(View view)
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String time = String.valueOf(timeEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedEvent == null)
        {
            int id = Event.eventArrayList.size();
            Event newEvent = new Event(id, time, desc);
            Event.eventArrayList.add(newEvent);
            sqLiteManager.addEventToDatabase(newEvent);
        }
        else
        {
            selectedEvent.setTime(time);
            selectedEvent.setDescription(desc);
            sqLiteManager.updateEventInDB(selectedEvent);
        }

        finish();
    }

    public void deleteEvent(View view)
    {
        selectedEvent.setDeleted(new Date());
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.updateEventInDB(selectedEvent);
        finish();
    }
}