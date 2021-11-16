package ru.job4j.inheritance;

public class JSONReport extends TextReport{
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{" + ln
                + "\t\"name\" : \"Report's name\"," + ln
                + "\t\"body\" : \"Report's body\"" + ln
                + "}";
    }
}
