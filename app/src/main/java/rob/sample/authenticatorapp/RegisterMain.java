package rob.sample.authenticatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerPage(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Register.class));
        finish();
    }

    public void loginPage(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void feedbackPage(View view) {
        FirebaseAuth.getInstance();
        startActivity(new Intent(getApplicationContext(),feedbackUser.class));
        finish();
    }

    public void profilePage(View view) {
        FirebaseAuth.getInstance();
        startActivity(new Intent(getApplicationContext(),profile.class));
        finish();
    }
}