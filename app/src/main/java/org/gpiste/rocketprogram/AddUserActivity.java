package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Here we can add new rockets. See activity_add_rocket.xml for the UI design
 *
 */
public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    /**
     * In activity_add_rocket.xml ->
     * btnAddRocket "onClick" attribute points to this method
     */
    User newUser = null;
    public void addUser(View view) {
        String degree = "";

        EditText Fname = findViewById(R.id.editFirstName);
        EditText Lname = findViewById(R.id.editLastName);
        EditText email = findViewById(R.id.editEmail);
        RadioGroup rgRocketType = findViewById(R.id.radioDegreeProgram);

        String FirstName = Fname.getText().toString();
        String LastName = Lname.getText().toString();
        String Email = email.getText().toString();

        switch (rgRocketType.getCheckedRadioButtonId()) {
            case R.id.seRadioButton:
                degree = "Software Engineering";
                break;
            case R.id.imRadioButton:
                degree = "Industrial Management";
                break;
            case R.id.ceRadioButton:
                degree = "Computational Engineering";
                break;
            case R.id.eeRadioButton:
                degree = "Electrical Engineering";
                break;
        }

        newUser = new User(FirstName, LastName, Email, degree);
        UserStorage.getInstance().addUser(newUser);

        }
}