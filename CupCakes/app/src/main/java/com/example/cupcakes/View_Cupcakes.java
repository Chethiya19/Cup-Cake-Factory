package com.example.cupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class View_Cupcakes extends AppCompatActivity {
    ArrayList<Cupcake> CupcakeArrayList;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cupcakes);
        db = new DB_Operations(this);

        CupcakeArrayList = db.ViewAll_Cupcakes();

//        if (CupcakeArrayList.size()>0) {
//            Cupcake_Adapter cupcakeAdapter = new Cupcake_Adapter(this, CupcakeArrayList);
//            listview.setAdapter(cupcakeAdapter);
//        }
    }

    public void getSelectedCupcake(View view){
        int index = (int)view.getTag();
        Cupcake Cupcake = CupcakeArrayList.get(index);
        Toast.makeText(this,Cupcake.getName() +"\n",Toast.LENGTH_SHORT).show();
    }


}