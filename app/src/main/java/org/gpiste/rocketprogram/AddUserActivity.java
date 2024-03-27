package org.gpiste.rocketprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Here we can add new rockets. See activity_add_rocket.xml for the UI design
 *
 */
public class AddUserActivity extends AppCompatActivity {
    private EditText editFirstName, editLastName, editEmail;
    private RadioGroup radioDegreeProgram;
    private LinearLayout radioDegreeLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.textFirstName);
        editLastName = findViewById(R.id.textLastName);
        editEmail = findViewById(R.id.textEmail);
        radioDegreeProgram = findViewById(R.id.textDegreeProgram);

        radioDegreeLevel = findViewById(R.id.textUserDegrees);
    }

//    User newUser = null;
    public void addUser(View view) {
        String degree = "";

        String FirstName = editFirstName.getText().toString();
        String LastName = editLastName.getText().toString();
        String Email = editEmail.getText().toString();

        switch (radioDegreeProgram.getCheckedRadioButtonId()) {
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

//        int selectedId = radioDegreeProgram.getCheckedRadioButtonId();
//        if (selectedId != -1) {
//            RadioButton radioButton = findViewById(selectedId);
//            degreeProgram = radioButton.getText().toString();
//        }

        User newUser = new User(FirstName, LastName, Email, degree);
        UserStorage.getInstance().addUser(newUser);

        finish();
        }
}

