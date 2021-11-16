package ru.job4j.inheritance;

public class Engineer extends Profession{
    String department;
    public Engineer(String name, String surname, String education, String birthday, String department) {
        super(name, surname, education, birthday);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
