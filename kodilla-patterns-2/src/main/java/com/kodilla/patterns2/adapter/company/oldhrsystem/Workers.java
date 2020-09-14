package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    private String[][] workers = {
            {"909012312", "John", "Smith"},
            {"901112312", "Peter", "Parker"},
            {"990123112", "Jan", "Smithwowa"},
            {"909051212", "Jozek", "Smithunia"},
            {"901123312", "Janina", "Smithusia"}};

    private double[] salaries = {
            4500,
            333,
            3333,
            53333,
            5555};

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
