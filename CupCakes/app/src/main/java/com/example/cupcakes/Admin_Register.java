package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Register extends AppCompatActivity {
    EditText txtName,txtEmail,txtPass;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        txtName =findViewById(R.id.a_uname);
        txtEmail=findViewById(R.id.a_email);
        txtPass=findViewById(R.id.a_pw);
        db = new DB_Operations(this);
    }
    public void clear(){
        txtName.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void insert_Admin(View view){
        try {
            Admin a = new Admin();
            String name=txtName.getText().toString();
            String email=txtEmail.getText().toString();
            String pass=txtPass.getText().toString();

            if (name.equals("") || email.equals("")|| pass.equals(""))
            {
                Toast.makeText(Admin_Register.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

            } else {
                a.setName(name);
                a.setEmail(email);
                a.setPass(pass);

                try {
                    db.insertAdmin(a);
                    Toast.makeText(this, "Registration Succesful", Toast.LENGTH_SHORT).show();
                    clear();
                }catch (Exception e){
                    Toast.makeText(this, "Cannot Register", Toast.LENGTH_SHORT).show();
                    e.getStackTrace();
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show();
        }
    }
    public void adminlog (View view){
        Intent Intent= new Intent(this,Admin_Login.class);
        startActivity(Intent);
    }
}