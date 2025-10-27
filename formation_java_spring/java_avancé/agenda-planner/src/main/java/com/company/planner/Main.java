package com.company.planner;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // Création manuelle
        Event e1 = new Event(EventType.TEAM_MEETING, ZonedDateTime.of(2025, 7, 1, 14, 0, 0, 0, ZoneId.of("Europe/Paris")));
        Event e2 = new Event(EventType.CODE_REVIEW, ZonedDateTime.of(2025, 7, 1, 16, 0, 0, 0, ZoneId.of("Europe/Paris")));
        Event e3 = new Event(EventType.CLIENT_CALL, ZonedDateTime.of(2025, 7, 1, 18, 0, 0, 0, ZoneId.of("America/New_York")));

        // Affichage avec varargs
        Planner.planEvents("Alice", e1, e2, e3);

        // Création avec parsing
        Event e4 = EventParser.parse("Appel client", "2025-07-02T10:00", "Asia/Tokyo");
        System.out.println("\n📥 Événement parsé :\n" + e4);
    }
}
