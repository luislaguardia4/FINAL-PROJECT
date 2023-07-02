package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalproject.Education;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView imageView;
    private Button takePhoto;
    Bitmap photo;
    byte[] photoByteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        takePhoto = findViewById(R.id.takePhoto);

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 22);
            }
        });

        Spinner spinner = findViewById(R.id.Relationship);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Relationship, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            ImageView imageView = findViewById(R.id.imageView);
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        } else {
            Toast.makeText(this, "Cancelled taking photo", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void personalBackground(View v) {

        //variable names for the xml

        EditText Fname = findViewById(R.id.Fname);
        EditText Lname = findViewById(R.id.Lname);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        EditText pi = findViewById(R.id.pi);
        EditText tin = findViewById(R.id.tin);
        EditText ph = findViewById(R.id.ph);
        EditText gsis = findViewById(R.id.gsis);
        EditText EmergencyName = findViewById(R.id.EmergencyName);
        EditText EmergencyContact = findViewById(R.id.EmergencyContact);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        RadioGroup civilGroup = findViewById(R.id.civilGroup);
        Spinner Relationship = findViewById(R.id.Relationship);

        //THIS
        String firstName = Fname.getText().toString();
        String lastName = Lname.getText().toString();
        String Eemail = email.getText().toString();
        String Pphone = phone.getText().toString();
        String Hheight = height.getText().toString();
        String Wweight = weight.getText().toString();
        String Ppagibig = pi.getText().toString();
        String Ttin = tin.getText().toString();
        String Pphilhealth = ph.getText().toString();
        String Ggsis = gsis.getText().toString();
        String nameEmergency = EmergencyName.getText().toString();
        String contact = EmergencyContact.getText().toString();
        String gender = Integer.toString(genderGroup.getCheckedRadioButtonId());
        String civilStatus = Integer.toString(civilGroup.getCheckedRadioButtonId());
        String relationship = Relationship.getSelectedItem().toString();

        if (firstName.isEmpty() || lastName.isEmpty() || Eemail.isEmpty() || Pphone.isEmpty() ||
                Hheight.isEmpty() || Wweight.isEmpty() || nameEmergency.isEmpty() || contact.isEmpty() ||
                gender.equals("-1") || civilStatus.equals("-1")) {

            Toast.makeText(this, "Fill-in all necessary information", Toast.LENGTH_SHORT).show();

        } else if (photo == null) {
            Toast.makeText(this, "No Photo Taken", Toast.LENGTH_SHORT).show();

        } else {

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();

        if (gender.equals("2131296517")) {
            gender = "Male";
        } else if (gender.equals("2131296459")) {
            gender = "Female";
        }

        if (civilStatus.equals("2131296662")) {
            civilStatus = "Single";
        } else if (civilStatus.equals("2131296518")) {
            civilStatus = "Married";
        } else if (civilStatus.equals("2131296654")) {
            civilStatus = "Separated";
        } else if (civilStatus.equals("2131296761")) {
            civilStatus = "Widowed";
        } else if (civilStatus.equals("2131296597")) {
            civilStatus = "Others";
        }

        editor.putString("FirstName", firstName);
        editor.putString("LastName", lastName);
        editor.putString("Email", Eemail);
        editor.putString("Phone", Pphone);
        editor.putString("Height", Hheight);
        editor.putString("Weight", Wweight);
        editor.putString("Pagibig", Ppagibig);
        editor.putString("TIN", Ttin);
        editor.putString("Philhealth", Pphilhealth);
        editor.putString("GSIS", Ggsis);
        editor.putString("NameEmergency", nameEmergency);
        editor.putString("Contact", contact);
        editor.putString("Gender", gender);
        editor.putString("CivilStatus", civilStatus);
        editor.putString("Relationship", relationship);
        editor.apply();

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            photoByteArray = bytes.toByteArray();
            Intent nextEd = new Intent(MainActivity.this, Education.class);

            nextEd.putExtra("imageArray", photoByteArray);
            startActivity(nextEd);
       }

    }
}
