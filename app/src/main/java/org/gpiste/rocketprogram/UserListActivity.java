package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserListActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvRocketList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // RocketListAdapter displays the rocket information
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), storage.getUsers()));

    }
}