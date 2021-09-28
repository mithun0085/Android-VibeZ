package com.example.calendar;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        loadFromDBToMemory();
        setEventAdapter();
        setOnClickListener();
    }


    private void initWidgets()
    {
        eventListView = findViewById(R.id.eventListView);
    }

    private void loadFromDBToMemory()
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateEventListArray();
    }

    private void setEventAdapter()
    {
        com.example.calendar.EventAdapter eventAdapter = new com.example.calendar.EventAdapter(getApplicationContext(), Event.nonDeletedEvents());
        eventListView.setAdapter(eventAdapter);
    }


    private void setOnClickListener()
    {
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Event selectedEvent = (Event) eventListView.getItemAtPosition(position);
                Intent editEventIntent = new Intent(getApplicationContext(), EventDetailActivity.class);
                editEventIntent.putExtra(Event.EVENT_EDIT_EXTRA, selectedEvent.getId());
                startActivity(editEventIntent);
            }
        });
    }




    public void newEvent(View view)
    {
        Intent newEventIntent = new Intent(this, EventDetailActivity.class);
        startActivity(newEventIntent);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdapter();
    }
}