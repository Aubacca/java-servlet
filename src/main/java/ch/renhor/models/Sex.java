package ch.renhor.models;

public enum Sex {
    MALE("m"),
    FEMALE("f");

    private String code;

    public String getCode() {
        return this.code;
    }

    Sex(String code) {
        this.code = code;
    }
}
