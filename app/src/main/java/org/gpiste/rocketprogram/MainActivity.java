package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUserCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserCounter = findViewById(R.id.txtRocketCounter);

        UserStorage s = UserStorage.getInstance();

//        s.addRocket(new Starship());
//        s.addRocket(new Starship());
//        s.addRocket(new Sls());
//        s.addRocket(new Starship());

        txtUserCounter.setText("The User count is: " + User.userCounter);
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToUserList(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    public void updateUserCounterNumber(View view) {
        txtUserCounter.setText("The User count is: " + User.userCounter);

    }

}