package org.gpiste.rocketprogram;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class User implements Serializable, StartStop {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String degreeProgram;
//    protected ArrayList<RocketEngine> engines = new ArrayList<>();
    public static int userCounter = 0;

    public User() {
        this("F", "L", "E", "D");
    }

    public User(String firstName, String lastName, String email, String degreeProgram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;

        userCounter++;
    }

    //    ????
    public void start() {
        System.out.println(firstName + " starts");
//        for (RocketEngine engine : engines) {
//            engine.start();
//        }
    }

    public void stop() {
        System.out.println(firstName + " shuts down");
    }
    //    ????

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getDegreeProgram() {
        return degreeProgram;
    }

//    public ArrayList<RocketEngine> getEngines() {
//        return engines;
//    }

    public void printCountdown(int x) {
        if (x < 0) {
            System.out.println();
            return;
        }
        System.out.print(x + " ");
        printCountdown(x - 1);
    }
}