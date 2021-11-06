package Lesson3;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    MALE("M"),
    FEMALE("F");

    public final String label;

    private Sex(String label) {
        this.label = label;
    }

    private static final Map<String, Sex> lookup = new HashMap<String, Sex>();

    static {
        for (Sex s : Sex.values()) {
            lookup.put(s.getLabel(), s);
        }
    }

    public String getLabel() {
        return label;
    }

    public static Sex get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
