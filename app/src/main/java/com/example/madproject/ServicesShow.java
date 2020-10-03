package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ServicesShow extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnVehicle,btnDocotr,btnGuide;
    Button btnAbout,btnLogin,btnFeed;
    Intent intentGet;
    String UID;

    public static String USER_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_show);

        btnVehicle = findViewById(R.id.imgbtn_ServiceVehicle);
        btnDocotr = findViewById(R.id.imgbtn_ServiceDoctor);
        btnGuide = findViewById(R.id.imgbtn_ServiceGuide);
        btnFeed = findViewById(R.id.btn_ServiceFeedback);
        btnAbout = findViewById(R.id.btn_ServiceAbout);
        btnLogin = findViewById(R.id.btn_ServiceLogin);

        btnVehicle.setOnClickListener(this);
        btnDocotr.setOnClickListener(this);
        btnGuide.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        intentGet = getIntent();
        UID = intentGet.getStringExtra(Home.USER_ID);

    }
    protected void onResume() {
        super.onResume();
        btnVehicle.setOnClickListener(this);
        btnDocotr.setOnClickListener(this);
        btnGuide.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_ServiceVehicle: Vechicle();
                break;
            case R.id.imgbtn_ServiceDoctor: Doctor();
                break;
            case R.id.imgbtn_ServiceGuide: Guide();
                break;
            case R.id.btn_ServiceFeedback: Feed();
                break;
            case R.id.btn_ServiceAbout: About();
                break;
            case R.id.btn_ServiceLogin: Login();
                break;
        }
    }
    public void Feed(){

    }
    public void About(){

    }
    public void Login(){

    }
    public void Guide(){

    }
    public void Doctor(){
        if(UID.equals("ADMIN")){
            Intent intent = new Intent(this,AddDoctor.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,DoctorShowNew.class);
            startActivity(intent);
        }


    }
    public void Vechicle(){

    }
}