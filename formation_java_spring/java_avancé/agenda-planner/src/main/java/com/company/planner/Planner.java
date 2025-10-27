package com.company.planner;

public class Planner {

    public static void planEvents(String organizer, Event... events) {
        System.out.println("🧑 Organisateur : " + organizer);
        System.out.println("📅 Événements :");
        int countOver1h = 0;
        Integer[] durations = new Integer[events.length];

        for (int i = 0; i < events.length; i++) {
            Event e = events[i];
            durations[i] = (int) e.getDuration().toMinutes();
            if (durations[i] > 60) countOver1h++;
            System.out.println(" - " + e);
        }

        System.out.println("🔎 Événements > 1h : " + countOver1h);
    }
}
