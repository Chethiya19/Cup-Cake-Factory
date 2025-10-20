package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Login extends AppCompatActivity {

    EditText txtausername , txtapassword;
    Button adminbtnlogin;
    Boolean isLogged;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txtausername = findViewById(R.id.a_username);
        txtapassword = findViewById(R.id.a_password);
        adminbtnlogin = findViewById(R.id.btn_a_login);
        db = new DB_Operations(this);
        adminbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = txtausername.getText().toString();
                String pass = txtapassword.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Admin_Login.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean result = db.checkadminnamepass(user, pass);

                    if (result == true) {
                        isLogged = true;
                        Intent intent = new Intent(Admin_Login.this, Admin_Dashboard.class);
                        intent.putExtra("Text", isLogged);
                        intent.putExtra("usname", user);
                        startActivity(intent);
                        clear();

                    } else {
                        Toast.makeText(Admin_Login.this, " WRONG CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void clear(){
        txtausername.setText("");
        txtapassword.setText("");
    }

    public void A_Register (View view){
        Intent Intent= new Intent(this, Admin_Register.class);
        startActivity(Intent);
    }

}