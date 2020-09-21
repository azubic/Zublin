package com.example.zublinhrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_view);

        //setup buttons
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        //setup text fields
        final TextView edtEmail = (TextView) findViewById(R.id.edtEmail);
        final TextView edtPassword = (TextView) findViewById(R.id.edtPassword);

        //Employee Account Info
        final String employeeUsername = "a";
        final String employeePassword = "a";
        //Reviewer Account Info
        final String reviewerUsername = "b";
        final String reviewerPassword = "b";

        //login button method
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //pulls text from fields
                final String username = edtEmail.getText().toString();
                final String password = edtPassword.getText().toString();

                if (username.equals(employeeUsername) && password.equals(employeePassword)) {
                    //switch to Employee page
                    Intent switchToEmployee = new Intent(v.getContext(), Employee.class);
                    startActivity(switchToEmployee);
                }
                else if (username.equals(reviewerUsername) && password.equals(reviewerPassword)) {
                    //switch to Reviewer Page
                    Intent switchToReviewer = new Intent(v.getContext(), Reviewer.class);
                    startActivity(switchToReviewer);
                }
                else {
                    //inform user of incorrect password attempt
                    Toast.makeText(v.getContext(), "Incorrect Password: Please, Try Again", 2).show();
                    //reset text fields
                    edtEmail.setText("");
                    edtPassword.setText("");
                }
            }
        });

        //register button method
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //switch to register page
                Intent switchToRegister = new Intent(v.getContext(), UserRegisterLogin.class);
                startActivity(switchToRegister);
            }
        });
    }
}