package com.example.lavinia.eventsapp.dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<EventClass> items = new ArrayList<EventClass>();

    /**
     * A map of sample (dummy) items, by ID.
     */
   // public static final Map<String, DummyItem> item_map = new HashMap<String, DummyItem>();

   //private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
        addItem(new EventClass(0, "Quiz Night Zorki" , "In the 2nd of December we are waiting for an amusing night for all you smarties out there "));
        addItem(new EventClass(1, "Temps D'Images" , "Art yourself up. A week full of concerts, plays and cinema events are about to happen in the second edition of Temps D'Images "));
    }

    private static void addItem(EventClass item) {
        items.add(item);
        //item_map.put(item.id, item);
    }


    public static EventClass getObjectById(int id){
        for (EventClass ev : items){
            if (ev.getId()==id){
                return ev;
            }
        }
        return null;
    }

    public static String getDetailsById(int id){
        for (EventClass ev : items){
            if (ev.getId()==id){
                return ev.getDetails();
            }
        }
        return "";
    }
//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }
//
//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class EventClass {
        public final int id;
        public final String title;
        public final String details;

        public EventClass(int id, String title, String details) {
            this.id = id;
            this.title = title;
            this.details = details;
        }

        public String getDetails(){
            return this.details;
        }
        public String getTitle(){
            return this.title;
        }

        public int getId(){
            return this.id;
        }
        @Override
        public String toString() {
            return title;
        }
    }
}
