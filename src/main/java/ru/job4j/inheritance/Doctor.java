package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String type;

    public Doctor(String name, String surname, String education, String birthday, String type) {
        super(name, surname, education, birthday);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
