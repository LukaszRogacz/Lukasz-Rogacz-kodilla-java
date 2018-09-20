package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"123456", "John", "Smith"},
            {"234567", "Ivone", "Novak"},
            {"345678", "Jessie", "Pinkman"},
            {"456789", "Walter", "White"},
    };

    private double[] salaries = {
            4500.00,
            3700.00,
            2500.00,
            6800.00
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
