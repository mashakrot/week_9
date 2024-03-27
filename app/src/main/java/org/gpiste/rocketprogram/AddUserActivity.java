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
    private EditText editFirstName, editLastName, editEmail;
    private RadioGroup radioDegreeProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
    }

    /**
     * In activity_add_rocket.xml ->
     * btnAddRocket "onClick" attribute points to this method
     */
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
//
//        Degree level: textUserDegrees
//
//        Check box ids for degree levels:
//        Bachelor's check box: bcCheckBox
//        Master's check box: msCheckBox
//        Licenciate check box: lciCheckBox
//        PhD check box: phdCheckBox

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

