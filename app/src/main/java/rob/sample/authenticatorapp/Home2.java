package rob.sample.authenticatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home2 extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnFood,btnBook,btnOther,btnProfile;
    Button btnAbout,btnFeed,btnFood2,btnBook2,btnOther2;
    Intent intent;
    String UID;
    public static final String USER_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_home);

        btnFood = findViewById(R.id.imgbtn_newHomeRoom);
        btnBook = findViewById(R.id.imgbtn_newHomeBooking);
        btnOther = findViewById(R.id.imgbtn_newHomeOther);
        btnFood2 = findViewById(R.id.btn_newHomeRoom);
        btnBook2 = findViewById(R.id.btn_newHomeBooking);
        btnOther2 = findViewById(R.id.btn_newHomeOther);
        btnFeed = findViewById(R.id.btn_HomeFeedback2);
        btnAbout = findViewById(R.id.btn_HomeAbout2);
        btnProfile = findViewById(R.id.btn_profile);

        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnFood2.setOnClickListener(this);
        btnBook2.setOnClickListener(this);
        btnOther2.setOnClickListener(this);

        intent = getIntent();
        UID = intent.getStringExtra(Login.UID_EXTRA);

        Toast.makeText(this, ""+UID, Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        btnFood.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnFeed.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
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
            case R.id.btn_profile: Profile();
                break;
            case R.id.btn_newHomeBooking: Book();
                break;
            case R.id.btn_newHomeRoom: Food();
                break;
            case R.id.btn_newHomeOther: Other();
                break;
        }
    }

    public void Food(){
        if(UID.equals("")){
            Toast.makeText(getApplicationContext(), "Login First", Toast.LENGTH_SHORT).show();
        }
        else if(UID.equals("admin@gmail.com")){
            intent = new Intent(this,FoodShowAdmin.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(this,FoodMain.class);
            intent.putExtra(USER_ID,UID);
            startActivity(intent);
        }

    }
    public void Book(){
        if(UID.equals("admin@gmail.com")){
            intent = new Intent(this,AdminBooking_DetailsList.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(this,RoomList.class);
            intent.putExtra(USER_ID,UID);
            startActivity(intent);
        }

        /*Intent intent = new Intent(this, RoomList.class);
        intent.putExtra(USER_ID,UID);
        startActivity(intent);*/
    }
    public void Other(){
        intent = new Intent(this,ServicesShow2.class);
        intent.putExtra(USER_ID,UID);
        startActivity(intent);
    }
    public void Feed(){
        intent = new Intent(this,feedbackUser.class);
        //intent.putExtra(USER_ID,UID);
        startActivity(intent);
    }
    public void About(){

    }
    public void Profile(){


        if(UID.equals("admin@gmail.com")){
            Toast.makeText(getApplicationContext(), "You are Loging as", Toast.LENGTH_SHORT).show();

        }
        else{
            intent = new Intent(this,profile.class);
            intent.putExtra(USER_ID,UID);
            startActivity(intent);
        }

    }
}