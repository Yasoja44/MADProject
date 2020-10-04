package rob.sample.authenticatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class FoodChoose extends AppCompatActivity implements View.OnClickListener{

    ImageButton imgbtnPizza,imgbtnBread,imgbtnRice;
    Button btnPizza,btnBread,btnRice;
    Intent intent,intentGet;
    public static final String UID_CHOOSE = " ";
    public static final int EXTRA_MESSAGE = 0;
    Bundle extras;
    String UID;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_choose);

        imgbtnPizza = findViewById(R.id.imgbtn_pizza);
        imgbtnBread = findViewById(R.id.imgbtn_bread);
        imgbtnRice = findViewById(R.id.imgbtn_rice);

        btnPizza = findViewById(R.id.btn_pizza);
        btnBread = findViewById(R.id.btn_bread);
        btnRice = findViewById(R.id.btn_rice);

        imgbtnPizza.setOnClickListener(this);
        imgbtnBread.setOnClickListener(this);
        imgbtnRice.setOnClickListener(this);
        btnPizza.setOnClickListener(this);
        btnBread.setOnClickListener(this);
        btnRice.setOnClickListener(this);



        intentGet = getIntent();
        UID = intentGet.getStringExtra(FoodMain.UID_EXTRA);

    }

    protected void onResume() {
        super.onResume();
        imgbtnPizza.setOnClickListener(this);
        imgbtnBread.setOnClickListener(this);
        imgbtnRice.setOnClickListener(this);
        btnPizza.setOnClickListener(this);
        btnBread.setOnClickListener(this);
        btnRice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_pizza: Pizza();
                break;
            case R.id.imgbtn_bread: Bread();
                break;
            case R.id.imgbtn_rice: Rice();
                break;
            case R.id.btn_pizza: Pizza();
                break;
            case R.id.btn_bread: Bread();
                break;
            case R.id.btn_rice: Rice();
                break;
        }
    }

    public void Pizza(){
        intent = new Intent(this,RoomServiceAdd.class);
        extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE",1);
        extras.putString("UID_CHOOSE",UID);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void Bread(){
        intent = new Intent(this,RoomServiceAdd.class);
        extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE",2);
        extras.putString("UID_CHOOSE",UID);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void Rice(){
        intent = new Intent(this,RoomServiceAdd.class);
        extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE",3);
        extras.putString("UID_CHOOSE",UID);
        intent.putExtras(extras);
        startActivity(intent);
    }

}