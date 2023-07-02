package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class Education extends AppCompatActivity {

    private CheckBox elementary;
    private LinearLayout elementaryLayout;
    private EditText elementarySchool;
    private EditText elementaryEducation;

    private CheckBox secondary;
    private LinearLayout secondaryLayout;
    private EditText secondarySchool;
    private EditText secondaryEducation;

    private CheckBox vocational;
    private LinearLayout vocationalLayout;
    private EditText vocationalSchool;
    private EditText vocationalEducation;

    private CheckBox college;
    private LinearLayout collegeLayout;
    private EditText collegeSchool;
    private EditText collegeEducation;

    private CheckBox graduate;
    private LinearLayout graduateLayout;
    private EditText graduateSchool;
    private EditText graduateEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        setTitle("Education Background");

        elementary = findViewById(R.id.elementary);
        elementaryLayout = findViewById(R.id.elementaryLayout);

        elementarySchool = findViewById(R.id.elementarySchool);
        elementaryEducation = findViewById(R.id.elementaryEducation);

        secondary = findViewById(R.id.secondary);
        secondaryLayout = findViewById(R.id.secondaryLayout);

        secondarySchool = findViewById(R.id.secondarySchool);
        secondaryEducation = findViewById(R.id.secondaryEducation);

        vocational = findViewById(R.id.vocational);
        vocationalLayout = findViewById(R.id.vocationalLayout);

        vocationalSchool = findViewById(R.id.vocationalSchool);
        vocationalEducation = findViewById(R.id.vocationalEducation);

        college = findViewById(R.id.college);
        collegeLayout = findViewById(R.id.collegeLayout);

        collegeSchool = findViewById(R.id.collegeSchool);
        collegeEducation = findViewById(R.id.collegeEducation);

        graduate = findViewById(R.id.graduate);
        graduateLayout = findViewById(R.id.graduateLayout);

        graduateSchool = findViewById(R.id.graduateSchool);
        graduateEducation = findViewById(R.id.graduateEducation);

        Button submit = findViewById(R.id.submit);

        elementary.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                elementaryLayout.setVisibility(View.VISIBLE);
            } else {
                elementaryLayout.setVisibility(View.GONE);
            }
        });

        secondary.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                secondaryLayout.setVisibility(View.VISIBLE);
            } else {
                secondaryLayout.setVisibility(View.GONE);
            }
        });

        vocational.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                vocationalLayout.setVisibility(View.VISIBLE);
            } else {
                vocationalLayout.setVisibility(View.GONE);
            }
        });

        college.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                collegeLayout.setVisibility(View.VISIBLE);
            } else {
                collegeLayout.setVisibility(View.GONE);
            }
        });

        graduate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                graduateLayout.setVisibility(View.VISIBLE);
            } else {
                graduateLayout.setVisibility(View.GONE);
            }
        });

        submit.setOnClickListener(v -> {
            String elementarySchoolText = elementarySchool.getText().toString();
            String elementaryEducationText = elementaryEducation.getText().toString();

            String secondarySchoolText = secondarySchool.getText().toString();
            String secondaryEducationText = secondaryEducation.getText().toString();

            String vocationalSchoolText = vocationalSchool.getText().toString();
            String vocationalEducationText = vocationalEducation.getText().toString();

            String collegeSchoolText = collegeSchool.getText().toString();
            String collegeEducationText = collegeEducation.getText().toString();

            String graduateSchoolText = graduateSchool.getText().toString();
            String graduateEducationText = graduateEducation.getText().toString();

            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();

            editor.putString("ElementaryField1", elementarySchoolText);
            editor.putString("ElementaryField2", elementaryEducationText);
            editor.putString("SecondaryField1", secondarySchoolText);
            editor.putString("SecondaryField2", secondaryEducationText);
            editor.putString("VocationalField1", vocationalSchoolText);
            editor.putString("VocationalField2", vocationalEducationText);
            editor.putString("CollegeField1", collegeSchoolText);
            editor.putString("CollegeField2", collegeEducationText);
            editor.putString("GraduateFieldStudies1", graduateSchoolText);
            editor.putString("GraduateFieldStudies2", graduateEducationText);
            editor.apply();
            if ((!elementary.isChecked() || (elementary.isChecked() && !elementarySchoolText.isEmpty() && !elementaryEducationText.isEmpty())) &&
                    (!secondary.isChecked() || (secondary.isChecked() && !secondarySchoolText.isEmpty() && !secondaryEducationText.isEmpty())) &&
                    (!vocational.isChecked() || (vocational.isChecked() && !vocationalSchoolText.isEmpty() && !vocationalEducationText.isEmpty())) &&
                    (!college.isChecked() || (college.isChecked() && !collegeSchoolText.isEmpty() && !collegeEducationText.isEmpty())) &&
                    (!graduate.isChecked() || (graduate.isChecked() && !graduateSchoolText.isEmpty() && !graduateEducationText.isEmpty()))) {

             //orig
//                Intent toCrim = new Intent(Education.this, CriminalB.class);
//                startActivity(toCrim);
//
                Intent toCrim = new Intent(Education.this, CriminalB.class);
                Bundle i = getIntent().getExtras();
                byte[] byteArrayEducationalBG = i.getByteArray("imageArray");

                toCrim.putExtra("imageArray", byteArrayEducationalBG);
                startActivity(toCrim);
            } else {
                Toast.makeText(Education.this, "Please fill in all necessary information", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
