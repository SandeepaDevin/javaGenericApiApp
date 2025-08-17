package com.lcrproject.lcrapp.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE,
    FEMALE;

    @JsonCreator
    public static Gender from(String value) {
        if (value == null) return null;

        switch (value.toLowerCase()) {
            case "male":
            case "1":
            case "xy":
                return MALE;
            case "female":
            case "0":
            case "xx":
                return FEMALE;

            default:
                throw new IllegalArgumentException("Invalid gender: " + value);
        }
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
