package com.company.planner;

import java.time.Duration;
import java.time.ZonedDateTime;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Event {
    private final EventType type;
    private final ZonedDateTime start;
    private final Duration duration;

    public Event(EventType type, ZonedDateTime start) {
        this.type = type;
        this.start = start;
        this.duration = type.getDefaultDuration();
    }

    public EventType getType() {
        return type;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public Duration getDuration() {
        return duration;
    }

    public ZonedDateTime getEnd() {
        return start.plus(duration);
    }

    @Override
    public String toString() {
        return EventFormatter.formatEvent(this);
    }
}
