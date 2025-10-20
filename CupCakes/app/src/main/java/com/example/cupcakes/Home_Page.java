package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void MemberLog(View view){
        Intent Intent= new Intent(this, Member_Login.class);
        startActivity(Intent);
    }
    public void AdminLog(View view){
        Intent Intent= new Intent(this,Admin_Login.class);
        startActivity(Intent);
    }
    public void ContactUs(View view){
        Intent Intent= new Intent(this,Contact_US.class);
        startActivity(Intent);
    }
}