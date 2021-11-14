package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active = " + this.active);
        System.out.println("status = " + this.status);
        System.out.println("message = " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 745511, "Error1");
        Error error2 = new Error(false, -84557, "Error2");
        Error error3 = new Error(true, 4, "Error3");

        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
