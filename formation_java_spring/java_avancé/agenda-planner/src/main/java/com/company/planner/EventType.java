package com.company.planner;

import java.time.Duration;

public enum EventType {
    TEAM_MEETING("Réunion d'équipe", Duration.ofMinutes(60)),
    CLIENT_CALL("Appel client", Duration.ofMinutes(30)),
    CODE_REVIEW("Revue de code", Duration.ofMinutes(45));

    private final String label;
    private final Duration defaultDuration;

    EventType(String label, Duration defaultDuration) {
        this.label = label;
        this.defaultDuration = defaultDuration;
    }

    public String getLabel() {
        return label;
    }

    public Duration getDefaultDuration() {
        return defaultDuration;
    }

    public static EventType fromLabel(String label) {
        for (EventType type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type inconnu : " + label);
    }
}
