package com.example.calendar;


import java.util.ArrayList;
import java.util.Date;

public class Event
{
    public static ArrayList<Event> eventArrayList = new ArrayList<>();
    public static String EVENT_EDIT_EXTRA =  "eventEdit";

    private int id;
    private String time;
    private String description;
    private Date deleted;

    public Event(int id, String time, String description, Date deleted)
    {
        this.id = id;
        this.time = time;
        this.description = description;
        this.deleted = deleted;
    }

    public Event(int id, String time, String description)
    {
        this.id = id;
        this.time = time;
        this.description = description;
        deleted = null;
    }

    public static Event getEventForID(int passedEventID)
    {
        for (Event event : eventArrayList)
        {
            if(event.getId() == passedEventID)
                return event;

        }


        return null;
    }

    public static ArrayList<Event> nonDeletedEvents()
    {
        ArrayList<Event> nonDeleted = new ArrayList<>();
        for(Event event : eventArrayList)
        {
            if(event.getDeleted() == null)
                nonDeleted.add(event);
        }

        return nonDeleted;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Date deleted)
    {
        this.deleted = deleted;
    }
}