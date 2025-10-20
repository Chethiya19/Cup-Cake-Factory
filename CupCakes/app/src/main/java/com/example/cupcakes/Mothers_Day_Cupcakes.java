package com.example.cupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mothers_Day_Cupcakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mothers__day__cupcakes);
    }
    public void placeorder(View view){
        Intent Intent= new Intent(this,Place_Order.class);
        startActivity(Intent);
    }
}