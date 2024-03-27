package org.gpiste.rocketprogram;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListUserInRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rvUserView;
    private UserListAdapter userListAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_recycle_view);

        rvUserView = findViewById(R.id.rvUserView);
        userListAdapter = new UserListAdapter(getApplicationContext(), UserStorage.getInstance().getUsers());
        rvUserView.setLayoutManager(new LinearLayoutManager(this));
        rvUserView.setAdapter(userListAdapter);


    }
}
