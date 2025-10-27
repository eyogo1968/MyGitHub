package com.company.planner;

import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EventParser {

    public static Event parse(String typeLabel, String datetimeStr, String zoneId) {
        EventType type = EventType.fromLabel(typeLabel);
        LocalDateTime local = LocalDateTime.parse(datetimeStr); // format ISO 8601 : 2025-07-01T14:00
        ZonedDateTime zoned = ZonedDateTime.of(local, ZoneId.of(zoneId));
        return new Event(type, zoned);
    }
}
