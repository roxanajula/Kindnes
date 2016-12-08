package com.kindnes.roxanajula.kindnes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.firebase.ui.auth.AuthUI;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN= 0;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            //User already signed in
            Log.d("AUTH", auth.getCurrentUser().getEmail());
            Intent homepage = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(homepage);
        } else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setProviders(
                            AuthUI.FACEBOOK_PROVIDER,
                            AuthUI.GOOGLE_PROVIDER)
                    .build(), RC_SIGN_IN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                //User logged in
                Log.d("AUTH", auth.getCurrentUser().getEmail() + auth.getCurrentUser().getDisplayName() + auth.getCurrentUser().getPhotoUrl());
                Intent homepage = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homepage);
            }
            else {
                //User not authenticated
                Log.d("AUTH", "NOT AUTHENTICATED");
            }
        }
    }
}