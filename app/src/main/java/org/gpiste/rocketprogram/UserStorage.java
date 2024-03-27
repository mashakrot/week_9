package org.gpiste.rocketprogram;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users;

    private String filename = "users.data";
    File f = new File(filename);
    private static UserStorage instance;
    private UserStorage(String filename) {
        users = new ArrayList<>();
        this.filename = filename;
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage("users.data");
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            Log.d("UsersApp: Storage", "Saving users failed");
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            Log.d("UsersApp: Storage","Reading users was unsuccessful");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("UsersApp: Storage","Reading users was unsuccessful");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.d("UsersApp: Storage","Reading users was unsuccessful");
            e.printStackTrace();
        }
    }

    public void listUser() {
        int i = 0;
        for (User user : users) {
            System.out.println(i++ + ": " + user.getFirstName() + " " + user.getLastName());
        }
    }


}