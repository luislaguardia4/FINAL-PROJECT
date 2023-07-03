package com.example.finalproject;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class CriminalB extends AppCompatActivity {

    private CheckBox yes1;
    private CheckBox yes2;
    private CheckBox yes3;
    private CheckBox yesa;
    private CheckBox yesb;
    private CheckBox yesc;

    private EditText txt1;
    private EditText txt2;
    private EditText txt3;
    private EditText txta;
    private EditText txtb;
    private EditText txtc;
    private CheckBox no1;
    private CheckBox no2;
    private CheckBox no3;
    private CheckBox noa;
    private CheckBox nob;
    private CheckBox noc;


    private Button submitReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        yes1 = findViewById(R.id.yes1);
        no1 = findViewById(R.id.no1);
        txt1 = findViewById(R.id.txt1);

        yes2 = findViewById(R.id.yes2);
        no2 = findViewById(R.id.no2);
        txt2 = findViewById(R.id.txt2);

        yes3 = findViewById(R.id.yes3);
        no3 = findViewById(R.id.no3);
        txt3 = findViewById(R.id.txt3);

        yesa = findViewById(R.id.yesa);
        noa = findViewById(R.id.noa);
        txta = findViewById(R.id.txta);

        yesb = findViewById(R.id.yesb);
        nob = findViewById(R.id.nob);
        txtb = findViewById(R.id.txtb);

        yesc = findViewById(R.id.yesc);
        noc = findViewById(R.id.noc);
        txtc = findViewById(R.id.txtc);

        submitReport = findViewById(R.id.submitReport);
        submitReport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent Allreport = new Intent(CriminalB.this, Report.class);

                Intent Allreport = new Intent(CriminalB.this, Report.class);

                Bundle i = getIntent().getExtras();
                byte[] byteArrayCriminalBG = i.getByteArray("imageArray");

                Allreport.putExtra("imageArray", byteArrayCriminalBG);
                startActivity(Allreport);

                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(CriminalB.this).edit();

                String q1 = txt1.getText().toString();
                String q2 = txt2.getText().toString();
                String q3 = txt3.getText().toString();
                String qa = txta.getText().toString();
                String qb = txtb.getText().toString();
                String qc = txtc.getText().toString();

                editor.putString("firstone", q1);
                editor.putString("secondtwo", q2);
                editor.putString("thirdthree", q3);
                editor.putString("fourthfour", qa);
                editor.putString("fifthfive", qb);
                editor.putString("sixthsix", qc);
                editor.apply();

                //notif part
                NotificationCompat.Builder notification = new NotificationCompat.Builder(CriminalB.this, "INFORMATION SUBMITTED");
                notification.setContentTitle("New Notification!");
                notification.setContentText("Successfully Submitted!");
                notification.setSmallIcon(R.drawable.baseline_notifications_active_24);
                notification.setAutoCancel(true);

                NotificationManager notiff = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notiff.notify(0, notification.build());

                startActivity(Allreport);
            }



    });
        // Enable/disable details EditText based on checkbox state
        yes1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txt1.setEnabled(isChecked);
            if (!isChecked) {
                txt1.setText("");
            }
        });

        yes2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txt2.setEnabled(isChecked);
            if (!isChecked) {
                txt2.setText("");
            }
        });

        yes3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txt3.setEnabled(isChecked);
            if (!isChecked) {
                txt3.setText("");
            }
        });

        yesa.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txta.setEnabled(isChecked);
            if (!isChecked) {
                txta.setText("");
            }
        });

        yesb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txtb.setEnabled(isChecked);
            if (!isChecked) {
                txtb.setText("");
            }
        });

        yesc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            txtc.setEnabled(isChecked);
            if (!isChecked) {
                txtc.setText("");
            }
        });
    }

}
