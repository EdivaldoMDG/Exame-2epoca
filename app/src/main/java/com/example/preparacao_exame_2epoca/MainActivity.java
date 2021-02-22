package com.example.preparacao_exame_2epoca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {



    Button login;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.loginButton);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if(email1.equals("edivaldogoncalves07@gmail.com")&&password1.equals("123456789")){
                    Intent dashboard = new Intent(getApplicationContext(),Exame.class);
                    startActivity(dashboard);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Validation Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}