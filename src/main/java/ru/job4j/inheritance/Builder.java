package ru.job4j.inheritance;

public class Builder extends Engineer {
    String qualification;

    public Builder(String name, String surname, String education, String birthday, String department, String qualification) {
        super(name, surname, education, birthday, department);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
