//package org.gpiste.rocketprogram;
//
//import java.io.Serializable;
//
//public class RocketEngine implements Serializable, StartStop {
//    private String name;
//    private int power;
//    private static final long serialVersionUID = 95732453L;
//
//    public RocketEngine(String name, int power) {
//        this.name = name;
//        this.power = power;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public void printSpecs() {
//        System.out.println(name + ": " + power + "kN");
//    }
//
//    public void start() {
//        System.out.println(name + " starts");
//    }
//
//    public void stop() {
//        System.out.println(name + " shuts down");
//    }
//}
