package com.example.dark_mode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText email_ed,password_ed;
    TextView email_txt,password_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        AppCompatButton button = findViewById(R.id.signin_btn);
        email_ed=findViewById(R.id.ed1);
        password_ed=findViewById(R.id.ed2);

        email_txt=findViewById(R.id.txt1);
        password_txt=findViewById(R.id.txt2);


        email_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            String email=email_ed.getText().toString();
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (email_ed.length()==0 && hasFocus){
                    email_txt.setVisibility(View.INVISIBLE);
                }else if (email_ed.length()!=0 && !hasFocus){
                    email_txt.setVisibility(View.INVISIBLE);
                }else if (email_ed.length()!=0 && hasFocus){
                    email_txt.setVisibility(View.INVISIBLE);
                }else {
                    email_txt.setVisibility(View.VISIBLE);
                }
            }
        });

        password_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            String password = password_ed.getText().toString();
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (password_ed.length()==0 && hasFocus){
                    password_txt.setVisibility(View.INVISIBLE);
                }else if (password_ed.length()!=0 && !hasFocus){
                    password_txt.setVisibility(View.INVISIBLE);
                }else if (password_ed.length()!=0 && hasFocus){
                    password_txt.setVisibility(View.INVISIBLE);
                }else {
                    password_txt.setVisibility(View.VISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Purchase.class));
            }
        });
    }


}