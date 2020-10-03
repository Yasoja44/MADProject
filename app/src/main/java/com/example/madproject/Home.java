package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnFood,btnBook,btnOther;
    Button btnAbout,btnLogin,btnFeed;
    Intent intent;
    String USER_ID2;
    public static final String USER_ID = "U01";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnFood = findViewById(R.id.btn_HomeFood);
        btnBook = findViewById(R.id.btn_HomeBooking);
        btnOther = findViewById(R.id.btn_HomeOther);
        btnFeed = findViewById(R.id.btn_HomeFeedback);
        btnAbout = findViewById(R.id.btn_HomeAbout);
        btnLogin = findViewById(R.id.btn_HomeLogin);

        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


    }

    protected void onResume() {
        super.onResume();
        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

        @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_HomeFood: Food();
                break;
            case R.id.btn_HomeBooking: Book();
                break;
            case R.id.btn_HomeOther: Other();
                break;
            case R.id.btn_HomeFeedback: Feed();
                break;
            case R.id.btn_HomeAbout: About();
                break;
            case R.id.btn_HomeLogin: Login();
                break;
        }
    }

    public void Food(){
        if(USER_ID.equals("")){
            Toast.makeText(getApplicationContext(), "Login First", Toast.LENGTH_SHORT).show();
        }
        else if(USER_ID.equals("ADMIN")){
            intent = new Intent(this,FoodShowAdmin.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(this,FoodMain.class);
            intent.putExtra(USER_ID,"U01");
            startActivity(intent);
        }

    }
    public void Book(){

    }
    public void Other(){
        intent = new Intent(this,ServicesShow.class);
        intent.putExtra(USER_ID,"ADMIN");
        startActivity(intent);
    }
    public void Feed(){

    }
    public void About(){

    }
    public void Login(){

    }

}