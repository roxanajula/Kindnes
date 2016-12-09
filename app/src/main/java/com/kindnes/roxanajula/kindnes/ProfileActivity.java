package com.kindnes.roxanajula.kindnes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView userNameProfile = (TextView) findViewById(R.id.userNameProfile);
        userNameProfile.setText(user.getDisplayName());
        ImageView userPhotoProfile = (ImageView) findViewById(R.id.userPhotoProfile);
        Picasso.with(this).load(user.getPhotoUrl()).into(userPhotoProfile);
    }
}
