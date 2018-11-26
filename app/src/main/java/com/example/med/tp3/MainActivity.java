package com.example.med.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login = (EditText) findViewById(R.id.user_email);
        final EditText pass = (EditText) findViewById(R.id.user_password);
        final Button loginButton = (Button) findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();
                if (loginTxt.equals("") || passTxt.equals("")) {
                    Toast.makeText(MainActivity.this,
                            R.string.email_or_password_empty,
                            Toast.LENGTH_SHORT).show();
                    return;
                }else{
                Intent intent = new Intent(MainActivity.this, LoginDisplayActivity.class);
                intent.putExtra(EXTRA_LOGIN, login.getText().toString());
                intent.putExtra(EXTRA_PASSWORD, pass.getText().toString());
                startActivity(intent);}
            }
        });





    }


}
