package com.company.planner;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EventFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm (z)", Locale.FRANCE);

    public static String format(ZonedDateTime datetime) {
        return datetime.format(FORMATTER);
    }

    public static String formatEvent(Event event) {
        return String.format("%s : %s → %s",
                event.getType().getLabel(),
                format(event.getStart()),
                format(event.getEnd()));
    }
}