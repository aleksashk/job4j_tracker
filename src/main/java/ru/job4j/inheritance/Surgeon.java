package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    String qualification;

    public Surgeon(String name, String surname, String education, String birthday, String type, String qualification) {
        super(name, surname, education, birthday, type);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}