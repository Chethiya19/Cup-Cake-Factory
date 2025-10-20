package com.example.cupcakes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Member_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_dashboard);
    }
    public void CupcakeCategories(View view){
        Intent Intent= new Intent(Member_Dashboard.this,Cupcake_Categories.class);
        startActivity(Intent);
    }
    public void Others(View view){
        Intent Intent= new Intent(Member_Dashboard.this,Others.class);
        startActivity(Intent);
    }
    public void Oderdetails(View view){
        Intent Intent= new Intent(Member_Dashboard.this,View_orders.class);
        startActivity(Intent);
    }
    public void Info(View view){
        Intent Intent= new Intent(Member_Dashboard.this,Contact_US.class);
        startActivity(Intent);
    }
    public void exit(View view){
        Intent Intent= new Intent(Member_Dashboard.this,MainActivity.class);
        startActivity(Intent);
    }
    public void placeorder(View view){
        Intent Intent= new Intent(Member_Dashboard.this,Place_Order.class);
        startActivity(Intent);
    }

}