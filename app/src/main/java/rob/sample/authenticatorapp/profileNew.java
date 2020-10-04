package rob.sample.authenticatorapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class profileNew extends Fragment {

    FirebaseAuth pAuth;
    FirebaseUser user;
    FirebaseDatabase fdb;
    DatabaseReference dbre;

    ImageView ppimage;
    TextView ppname,ppemail,ppphone;

    public profileNew () {

    }
@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile_new,container, false);


        pAuth = FirebaseAuth.getInstance();
        user = pAuth.getCurrentUser();
        fdb = FirebaseDatabase.getInstance();
        dbre = fdb.getReference("registerClass");

        ppimage = view.findViewById(R.id.ppimage);
        ppname = view.findViewById(R.id.ppname);
        ppemail = view.findViewById(R.id.ppemail);
        ppphone = view.findViewById(R.id.ppphone);

    Query query = dbre.orderByChild("email").equalTo(registerClass.getccEmail());
    query.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    String name = "" +ds.child("cfullName").getValue();
                    String email = "" +ds.child("cEmail").getValue();
                    String phone = "" +ds.child("cPhone").getValue();
//                    String image = "" + ds.child("ppi")

                    ppname.setText(name);
                    ppemail.setText(email);
                    ppphone.setText(phone);

//                    try {
//                        Picasso.get().load(ppimage)
//                    }
                }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

    return view;

}
}