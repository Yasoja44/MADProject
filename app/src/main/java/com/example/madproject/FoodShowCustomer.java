package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FoodShowCustomer extends AppCompatActivity implements View.OnClickListener{

    TextView showCustomer;
    Button btnEdit,btnDelete;
    Intent intentGet;
    DatabaseReference dbRef;
    String UID;

    private static final String TAG = "FoodShowCustomer";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    public static final String UID_SHOW = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_show_customer);

        //showCustomer = findViewById(R.id.txt_cusShow);

        btnEdit = findViewById(R.id.btn_cusEdit);
        btnDelete = findViewById(R.id.btn_CusDelete);

        intentGet = getIntent();
        UID = intentGet.getStringExtra(FoodMain.UID_EXTRA);

        btnDelete.setOnClickListener(this);
        btnEdit.setOnClickListener(this);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();

        /*dbRef = FirebaseDatabase.getInstance().getReference();
        Query showQuery = dbRef.child("Order").orderByChild("userID").equalTo(UID.toString().trim());

        showQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot showSnapshot: dataSnapshot.getChildren()) {
                    showCustomer.append("User ID: "+showSnapshot.child("userID").getValue().toString() + "\n"+
                            "Order ID: "+showSnapshot.child("orderID").getValue().toString() + "\n"+
                            "Food Type: "+showSnapshot.child("foodType").getValue().toString() + "\n" +
                            "Food Amount: " + showSnapshot.child("foodAmount").getValue().toString() + "\n" +
                            "Room No: " + showSnapshot.child("roomNo").getValue().toString() + "\n" +
                            "Order Date: " + showSnapshot.child("orderDate").getValue().toString() + "\n" +
                            "Order Time: " + showSnapshot.child("orderTime").getValue().toString() + "\n" +
                            "Ordered DateTime: " + showSnapshot.child("orderedDateTime").getValue().toString() + "\n" +
                            "Price: " + showSnapshot.child("price").getValue().toString() + "\n\n"
                    );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

    private void initImageBitmaps() {

        dbRef = FirebaseDatabase.getInstance().getReference();
        Query showQuery = dbRef.child("Order").orderByChild("userID").equalTo(UID.toString().trim());

        showQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot showSnapshot: dataSnapshot.getChildren()) {
                    Log.d(TAG, "initImageBitmaps: started");
                    mImageUrls.add("https://www.howtogeek.com/wp-content/uploads/2020/03/delivery-food.jpg.pagespeed.ce.8e-lIOJeD5.jpg");
                    mNames.add("User ID: "+showSnapshot.child("userID").getValue().toString() + "\n"+
                            "Order ID: "+showSnapshot.child("orderID").getValue().toString() + "\n"+
                            "Food Type: "+showSnapshot.child("foodType").getValue().toString() + "\n" +
                            "Food Amount: " + showSnapshot.child("foodAmount").getValue().toString() + "\n" +
                            "Room No: " + showSnapshot.child("roomNo").getValue().toString() + "\n" +
                            "Order Date: " + showSnapshot.child("orderDate").getValue().toString() + "\n" +
                            "Order Time: " + showSnapshot.child("orderTime").getValue().toString() + "\n" +
                            "Ordered DateTime: " + showSnapshot.child("orderedDateTime").getValue().toString() + "\n" +
                            "Price: " + showSnapshot.child("price").getValue().toString() + "\n\n");
                    initRecyclerView();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.FoodCus_recycler_view);
        YasojaRecyclerViewAdapter adapter = new YasojaRecyclerViewAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnDelete.setOnClickListener(this);
        btnEdit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cusEdit: Edit();
                break;
            case R.id.btn_CusDelete: Delete();
                break;
        }
    }

    public void Edit(){
        Toast.makeText(getApplicationContext(), "UID:" + UID, Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(this,EditFood.class);
        intent2.putExtra(UID_SHOW,UID);
        startActivity(intent2);
    }

    public void Delete(){
        Toast.makeText(getApplicationContext(), "UID:" + UID, Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(this,DeleteFood.class);
        intent2.putExtra(UID_SHOW,UID);
        startActivity(intent2);
    }
}