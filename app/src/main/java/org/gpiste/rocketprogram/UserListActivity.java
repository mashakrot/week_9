package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

public class UserListActivity extends AppCompatActivity {

    private UserStorage storage;
    private RecyclerView recyclerView;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        storage = UserStorage.getInstance();

        recyclerView = findViewById(R.id.rvRocketList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // RocketListAdapter displays the rocket information
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), storage.getUsers()));
//        storage.loadUsers(context);

    }
}