package ru.job4j.pojo;

public class Student {

    private String fio;
    private String group;
    private String date;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Dmitriev Oleg Vasilievich");
        System.out.println(student.getFio());
        student.setGroup("GIO/568-08");
        System.out.println(student.getGroup());
        student.setDate("01.09.2021");
        System.out.println(student.date);
    }
}
