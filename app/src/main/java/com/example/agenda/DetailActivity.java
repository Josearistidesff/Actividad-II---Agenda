package com.example.agenda;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private String address;
    private TextView nameView;
    private TextView lastNameView;
    private TextView genderView;
    private TextView careearView;
    private ImageView profileImgView;
    private TextView birthDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra("name");
        String lastName = getIntent().getStringExtra("lastName");
        String gender = getIntent().getStringExtra("gender");
        String career = getIntent().getStringExtra("career");
        int profileImg = getIntent().getIntExtra("profileImg",0);
        String birthDate = getIntent().getStringExtra("birthDate");
        address = getIntent().getStringExtra(address);

        nameView =(TextView) findViewById(R.id.name);
        genderView =(TextView) findViewById(R.id.gender);
        careearView =(TextView) findViewById(R.id.career);
        birthDateView =(TextView) findViewById(R.id.birthDate);
        profileImgView =(ImageView) findViewById(R.id.imageView);

        nameView.setText(name + " " + lastName);
        careearView.setText(career);
        genderView.setText(gender);
        birthDateView.setText(birthDate);

        Resources resources = getResources();

        profileImgView.setImageDrawable(resources.getDrawable(profileImg));

    }

    public void goBack(View view){
        finish();
    }

    public void openMap(View view){
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }


    }
}