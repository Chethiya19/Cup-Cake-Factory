package com.example.cupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cupcake_Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake_categories);
    }
    public void ClassicCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Classic_Cupcakes.class);
        startActivity(Intent);
    }
    public void ThemedCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Themed_Cupcakes.class);
        startActivity(Intent);
    }
    public void BirtydayCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Birtyday_Cupcakes.class);
        startActivity(Intent);
    }
    public void AnniversaryCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Anniversary_Cupcakes.class);
        startActivity(Intent);
    }
    public void NewBabyCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,New_Baby_Cupcakes.class);
        startActivity(Intent);
    }
    public void ValantineCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Valantine_Cupcakes.class);
        startActivity(Intent);
    }
    public void Graduation_Cupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Graduation_Cupcakes.class);
        startActivity(Intent);
    }
    public void MothersDayCupcakes(View view){
        Intent Intent= new Intent(Cupcake_Categories.this,Mothers_Day_Cupcakes.class);
        startActivity(Intent);
    }
}