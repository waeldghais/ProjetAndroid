package com.example.med.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginDisplayActivity extends MainActivity{
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);


        Intent intent = getIntent();
        TextView EmailDisplay = (TextView) findViewById(R.id.email_display);
        TextView passwordDisplay = (TextView) findViewById(R.id.password_display);

        if (intent != null) {
            EmailDisplay.setText(intent.getStringExtra(EXTRA_LOGIN));
            passwordDisplay.setText(intent.getStringExtra(EXTRA_PASSWORD));
        }


    }
}
