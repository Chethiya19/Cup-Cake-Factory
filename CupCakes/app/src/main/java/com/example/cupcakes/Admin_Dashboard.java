package com.example.cupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void Manage_Categories(View view){
        Intent Intent= new Intent(this,Manage_Categories.class);
        startActivity(Intent);
    }
    public void Manage_cupcakes(View view){
        Intent Intent= new Intent(this,Manage_cupcakes.class);
        startActivity(Intent);
    }
    public void View_orders(View view){
        Intent Intent= new Intent(this,View_orders.class);
        startActivity(Intent);
    }
    public void Process_orders(View view){
        Intent Intent= new Intent(this,Process_orders.class);
        startActivity(Intent);
    }
}