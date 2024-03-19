package org.gpiste.rocketprogram;

import java.util.ArrayList;

public class Storage {
     private ArrayList<User> users = new ArrayList<>();

     // Singleton pattern: static instance of Storage
     private static Storage storage = null;


    private Storage() {
        // We are using Singleton design pattern here:
        // default constructor is set to private,
        // so that new instances cannot be created
    }

    /**
     * Singleton pattern:
     * getInstance returns the only instance of Storage
     *
     * @return the single instance of Storage
     */
    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void listUser() {
        int i = 0;
        for (User user : users) {
            System.out.println(i++ + ": " + user.getFirstName() + " " + user.getLastName());
        }
    }


}
