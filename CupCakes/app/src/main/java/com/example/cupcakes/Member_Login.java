package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Member_Login extends AppCompatActivity {

    EditText txtmusername , txtmpassword;
    Button memberbtnlogin;
    Boolean isLogged;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);
        txtmusername = findViewById(R.id.m_username);
        txtmpassword = findViewById(R.id.m_password);
        memberbtnlogin = findViewById(R.id.btn_m_login);
        db = new DB_Operations(this);
        memberbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = txtmusername.getText().toString();
                String pass = txtmpassword.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Member_Login.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean result = db.checkmembernamepass(user, pass);

                    if (result == true) {
                        isLogged = true;
                        Intent intent = new Intent(Member_Login.this, Member_Dashboard.class);
                        intent.putExtra("Text", isLogged);
                        intent.putExtra("usname", user);
                        startActivity(intent);
                        clear();

                    } else {
                        Toast.makeText(Member_Login.this, " WRONG CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void clear(){
        txtmusername.setText("");
        txtmpassword.setText("");
    }

    public void M_register (View view){
        Intent Intent= new Intent(this, Member_Register.class);
        startActivity(Intent);
    }

}