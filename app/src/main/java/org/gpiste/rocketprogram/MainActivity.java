package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private TextView txtUserCounter;
    private Context context;
    private UserStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserCounter = findViewById(R.id.txtRocketCounter);

        UserStorage s = UserStorage.getInstance();

        txtUserCounter.setText("The User count is: " + User.userCounter);
//        UserStorage.getInstance().loadUsers(context);
    }

    public void addUser(View view) {
        Intent intent = new Intent(this, org.gpiste.rocketprogram.AddUserActivity.class);
        startActivity(intent);
//        UserStorage.getInstance().saveUsers(context);
        storage = UserStorage.getInstance();

        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(this.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(storage.getUsers());
            userWriter.close();
        } catch (IOException e) {
            Log.d("UsersApp: Storage", "Saving users failed");
        }

    }

    public void viewUsers(View view) {
        Intent intent = new Intent(this, ListUserInRecycleViewActivity.class);
        startActivity(intent);
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToUserList(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

//    add = findViewById(R.id.plusButton);
//
//    add.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            double a = Double.parseDouble(no1.getText().toString());
//            double b = Double.parseDouble(no2.getText().toString());
//            result = a + b;
//            String outputText = String.valueOf(result);
//            answer.setText(outputText);
//            result = 0;
//        }
//    });

    public void updateUserCounterNumber(View view) {
        txtUserCounter.setText("The User count is: " + User.userCounter);

    }

    public void saveRockets(View view) {
        UserStorage.getInstance().saveUsers(context);
    }

    public void loadRockets(View view) {
        UserStorage.getInstance().loadUsers(context);
    }

}