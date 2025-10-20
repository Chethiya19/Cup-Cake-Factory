package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Member_Register extends AppCompatActivity {
    EditText txtName,txtEmail,txtPass;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_register);
        txtName =findViewById(R.id.m_uname);
        txtEmail=findViewById(R.id.m_email);
        txtPass=findViewById(R.id.m_pw);
        db = new DB_Operations(this);
    }
    public void clear(){
        txtName.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void insert_member(View view){
        try {
            Member m = new Member();
            String name=txtName.getText().toString();
            String email=txtEmail.getText().toString();
            String pass=txtPass.getText().toString();

            if (name.equals("") || email.equals("")|| pass.equals(""))
            {
                Toast.makeText(Member_Register.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

            } else {
                m.setName(name);
                m.setEmail(email);
                m.setPass(pass);

                try {
                    db.insertMember(m);
                    Toast.makeText(this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
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
    public void memberlog (View view){
        Intent Intent= new Intent(this,Member_Login.class);
        startActivity(Intent);
    }
}