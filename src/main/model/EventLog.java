package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// represents a log of events
public class EventLog implements Iterable<Event> {
    /** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;


    // EFFECTS: creates an EventLog; singleton design pattern, prevent external construction
    private EventLog() {
        events = new ArrayList<Event>();
    }


    // EFFECTS: gets instance of EventLog; creates it if it doesn't already exist (Singleton Design Pattern)
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }


    // MODIFIES: this
    // EFFECTS: adds an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }


    // MODIFIES: this
    // EFFECTS: clears the event log and logs the event
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}