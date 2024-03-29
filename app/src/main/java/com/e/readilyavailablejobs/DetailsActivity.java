package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DetailsActivity extends AppCompatActivity {


    private EditText country, firname, laname, username, emailadress, phonumber, enterpassword, conpassword;
    private Button submit;
    private Button back;

    Signer signer;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        country = (EditText) findViewById(R.id.et_enteryourcountry);
        firname = (EditText) findViewById(R.id.et_enteryourfname_id);
        laname = (EditText) findViewById(R.id.et_enteryourlastname_id);
        username = (EditText) findViewById(R.id.et_enteryourusername_id);
        emailadress = (EditText) findViewById(R.id.et_enteryouremailaddress_id);
        phonumber = (EditText) findViewById(R.id.et_enteryourphonenumber_id);
        enterpassword = (EditText) findViewById(R.id.et_enteryourpassword_id);
        conpassword = (EditText) findViewById(R.id.et_confirmyourpassword_id);
        submit = (Button) findViewById(R.id.bt_submit_id);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User Details");


        submit = (Button) findViewById(R.id.bt_submit_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btsubmit();

            }
        });
        back = (Button) findViewById(R.id.bt_back_id);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btlogin();
            }
        });
    }

    private void btlogin() {

        Intent intent = new Intent(DetailsActivity.this, NextActivity.class);
        startActivity(intent);
    }

    private void btsubmit() {


        String signerCountry = country.getText().toString();
        String signerFirName = firname.getText().toString();
        String signerLaName = laname.getText().toString();
        String signerUserName = username.getText().toString();
        String signerEmailAdress = emailadress.getText().toString();
        String signerPhoneNumber = phonumber.getText().toString();
        String signerPassword = enterpassword.getText().toString();
        String signerConPassword = conpassword.getText().toString();


        Signer signer = new Signer(signerCountry, signerFirName, signerLaName, signerUserName, signerEmailAdress,
                signerPhoneNumber, signerPassword, signerConPassword);
        

        //Using the method to creat a unique id of signer
        databaseReference.push().setValue(signer);

    }

}







