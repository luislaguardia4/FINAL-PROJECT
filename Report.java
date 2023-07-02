package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //Personalbg
        TextView nameOutput = findViewById(R.id.NameReport);
        TextView emailOutput = findViewById(R.id.EmailReport);
        TextView genderOutput = findViewById(R.id.GenderReport);
        TextView phoneOutput = findViewById(R.id.PhoneReport);
        TextView heightOutput = findViewById(R.id.HeightReport);
        TextView weightOutput = findViewById(R.id.WeightReport);
        TextView civilStatusOutput = findViewById(R.id.CivilStatusReport);
        TextView pagibigOutput = findViewById(R.id.PagibigReport);
        TextView tinOutput = findViewById(R.id.TINReport);
        TextView philhealthOutput = findViewById(R.id.PhilhealthReport);
        TextView gsisOutput = findViewById(R.id.GSISReport);
        TextView nameEmergencyOutput = findViewById(R.id.NameEmergencyReport);
        TextView contactOutput = findViewById(R.id.ContactReport);
        TextView relationshipOutput = findViewById(R.id.RelationshipReport);

        //Educationalbg
        TextView elementaryReport = findViewById(R.id.ElementaryReport);
        TextView secondaryReport = findViewById(R.id.SecondaryReport);
        TextView vocationalReport = findViewById(R.id.VocationalReport);
        TextView collegeReport = findViewById(R.id.CollegeReport);
        TextView graduateStudiesReport = findViewById(R.id.GraduateStudiesReport);

        //Criminalbg
        TextView firstQuestionReport = findViewById(R.id.FirstQuestionReport);
        TextView secondQuestionReport = findViewById(R.id.SecondQuestionReport);
        TextView thirdQuestionReport = findViewById(R.id.ThirdQuestionReport);
        TextView fourthAQuestionReport = findViewById(R.id.FourthAQuestionReport);
        TextView fourthBQuestionReport = findViewById(R.id.FourthBQuestionReport);
        TextView fourthCQuestionReport = findViewById(R.id.FourthCQuestionReport);

        ImageView imPictureReceiver = findViewById(R.id.imageViewReport);
        Bundle i = getIntent().getExtras();
        byte[] byteArray = i.getByteArray("imageArray");
        Bitmap photo = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imPictureReceiver.setImageBitmap(photo);

        //from personal
        String firstName = PreferenceManager.getDefaultSharedPreferences(this).getString("FirstName", "");
        String lastName = PreferenceManager.getDefaultSharedPreferences(this).getString("LastName", "");
        String email = PreferenceManager.getDefaultSharedPreferences(this).getString("Email", "");
        String phone = PreferenceManager.getDefaultSharedPreferences(this).getString("Phone", "");
        String height = PreferenceManager.getDefaultSharedPreferences(this).getString("Height", "");
        String weight = PreferenceManager.getDefaultSharedPreferences(this).getString("Weight", "");
        String pagibig = PreferenceManager.getDefaultSharedPreferences(this).getString("Pagibig", "");
        String tin = PreferenceManager.getDefaultSharedPreferences(this).getString("TIN", "");
        String philhealth = PreferenceManager.getDefaultSharedPreferences(this).getString("Philhealth", "");
        String gsis = PreferenceManager.getDefaultSharedPreferences(this).getString("GSIS", "");
        String nameEmergency = PreferenceManager.getDefaultSharedPreferences(this).getString("NameEmergency", "");
        String contact = PreferenceManager.getDefaultSharedPreferences(this).getString("Contact", "");
        String gender = PreferenceManager.getDefaultSharedPreferences(this).getString("Gender", "");
        String civilStatus = PreferenceManager.getDefaultSharedPreferences(this).getString("CivilStatus", "");
        String relationship = PreferenceManager.getDefaultSharedPreferences(this).getString("Relationship", "");

        //from educ
        String elementaryField1 = PreferenceManager.getDefaultSharedPreferences(this).getString("ElementaryField1", "");
        String elementaryField2 = PreferenceManager.getDefaultSharedPreferences(this).getString("ElementaryField2", "");
        String secondaryField1 = PreferenceManager.getDefaultSharedPreferences(this).getString("SecondaryField1", "");
        String secondaryField2 = PreferenceManager.getDefaultSharedPreferences(this).getString("SecondaryField2", "");
        String vocationalField1 = PreferenceManager.getDefaultSharedPreferences(this).getString("VocationalField1", "");
        String vocationalField2 = PreferenceManager.getDefaultSharedPreferences(this).getString("VocationalField2", "");
        String collegeField1 = PreferenceManager.getDefaultSharedPreferences(this).getString("CollegeField1", "");
        String collegeField2 = PreferenceManager.getDefaultSharedPreferences(this).getString("CollegeField2", "");
        String graduateStudiesField1 = PreferenceManager.getDefaultSharedPreferences(this).getString("GraduateFieldStudies1", "");
        String graduateStudiesField2 = PreferenceManager.getDefaultSharedPreferences(this).getString("GraduateFieldStudies2", "");

        //from crim
        String q1 = PreferenceManager.getDefaultSharedPreferences(this).getString("firstone", "");
        String q2 = PreferenceManager.getDefaultSharedPreferences(this).getString("secondtwo", "");
        String q3 = PreferenceManager.getDefaultSharedPreferences(this).getString("thirdthree", "");
        String qa = PreferenceManager.getDefaultSharedPreferences(this).getString("fourthfour", "");
        String qb = PreferenceManager.getDefaultSharedPreferences(this).getString("fifthfive", "");
        String qc = PreferenceManager.getDefaultSharedPreferences(this).getString("sixthsix", "");

        //personal back
        nameOutput.setText(String.format("%s %s", firstName, lastName));
        emailOutput.setText(email);
        phoneOutput.setText(phone);
        heightOutput.setText(height);
        weightOutput.setText(weight);
        pagibigOutput.setText(pagibig);
        tinOutput.setText(tin);
        philhealthOutput.setText(philhealth);
        gsisOutput.setText(gsis);
        nameEmergencyOutput.setText(nameEmergency);
        contactOutput.setText(contact);
        genderOutput.setText(gender);
        civilStatusOutput.setText(civilStatus);
        relationshipOutput.setText(relationship);

        //edu back
        elementaryReport.setText(String.format("%s | %s", elementaryField1, elementaryField2));
        secondaryReport.setText(String.format("%s | %s", secondaryField1, secondaryField2));
        vocationalReport.setText(String.format("%s | %s", vocationalField1, vocationalField2));
        collegeReport.setText(String.format("%s | %s", collegeField1, collegeField2));
        graduateStudiesReport.setText(String.format("%s | %s", graduateStudiesField1, graduateStudiesField2));

        //crim back
        firstQuestionReport.setText(q1);
        secondQuestionReport.setText(q2);
        thirdQuestionReport.setText(q3);
        fourthAQuestionReport.setText(qa);
        fourthBQuestionReport.setText(qb);
        fourthCQuestionReport.setText(qc);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView imPictureReceiver = findViewById(R.id.imageViewReport);
        Bundle i = getIntent().getExtras();
        byte[] byteArray = i.getByteArray("imageArray");
        Bitmap photo = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imPictureReceiver.setImageBitmap(photo);
    }

    public void page4Back(View v) {
        Intent page4_back = new Intent(this, MainActivity.class);
        startActivity(page4_back);
    }
}
