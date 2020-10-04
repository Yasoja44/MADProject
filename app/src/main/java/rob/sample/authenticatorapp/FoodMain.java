package rob.sample.authenticatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class FoodMain extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnOrder,btnShow;
    Intent intent;
    String UID;
    public static final String UID_EXTRA = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);

        btnOrder = findViewById(R.id.imgbtn_PlaceOrder);
        btnShow = findViewById(R.id.imgbtn_ShowOrder);

        btnOrder.setOnClickListener(this);
        btnShow.setOnClickListener(this);

        intent = getIntent();
        UID = intent.getStringExtra(Home2.USER_ID);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnOrder = findViewById(R.id.imgbtn_PlaceOrder);
        btnShow = findViewById(R.id.imgbtn_ShowOrder);
        btnOrder.setOnClickListener(this);
        btnShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_PlaceOrder:Order();
                break;
            case R.id.imgbtn_ShowOrder:Show();
                break;
        }
    }

    public void Order(){
        Intent next = new Intent(this,FoodChoose.class);
        next.putExtra(UID_EXTRA,UID);
        startActivity(next);
    }

    public void Show(){
        Intent next = new Intent(this,FoodShowCustomer.class);
        next.putExtra(UID_EXTRA,UID);
        startActivity(next);
    }
}