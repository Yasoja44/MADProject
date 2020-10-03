package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home2 extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnFood,btnBook,btnOther;
    Button btnAbout,btnLogin,btnFeed,btnFood2,btnBook2,btnOther2;
    Intent intent;
    String USER_ID2;
    public static final String USER_ID = "U01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        btnFood = findViewById(R.id.imgbtn_newHomeRoom);
        btnBook = findViewById(R.id.imgbtn_newHomeBooking);
        btnOther = findViewById(R.id.imgbtn_newHomeOther);
        btnFood2 = findViewById(R.id.btn_newHomeBooking);
        btnBook2 = findViewById(R.id.btn_newHomeRoom);
        btnOther2 = findViewById(R.id.btn_newHomeOther);
        btnFeed = findViewById(R.id.btn_HomeFeedback2);
        btnAbout = findViewById(R.id.btn_HomeAbout2);
        btnLogin = findViewById(R.id.btn_HomeLogin2);

        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnFood2.setOnClickListener(this);
        btnBook2.setOnClickListener(this);
        btnOther2.setOnClickListener(this);
    }

    protected void onResume() {
        super.onResume();
        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnFood2.setOnClickListener(this);
        btnBook2.setOnClickListener(this);
        btnOther2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_newHomeRoom: Food();
                break;
            case R.id.imgbtn_newHomeBooking: Book();
                break;
            case R.id.imgbtn_newHomeOther: Other();
                break;
            case R.id.btn_HomeFeedback2: Feed();
                break;
            case R.id.btn_HomeAbout2: About();
                break;
            case R.id.btn_HomeLogin2: Login();
                break;
            case R.id.btn_newHomeBooking: Food();
                break;
            case R.id.btn_newHomeRoom: Book();
                break;
            case R.id.btn_newHomeOther: Other();
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
        intent = new Intent(this,ServicesShow2.class);
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