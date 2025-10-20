package com.example.cupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class New_Baby_Cupcakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__baby__cupcakes);
    }
    public void placeorder(View view){
        Intent Intent= new Intent(this,Place_Order.class);
        startActivity(Intent);
    }
}