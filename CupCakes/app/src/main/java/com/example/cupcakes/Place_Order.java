package com.example.cupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Place_Order extends AppCompatActivity {
    EditText txtmname, txtaddress, txtmobileno;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        txtmname = findViewById(R.id.MemberName);
        txtaddress = findViewById(R.id.txtcatname);
        txtmobileno = findViewById(R.id.Membertelno);
        db = new DB_Operations(this);
    }

    public void Placeorder(View view) {
        try {
            Order order = new Order();
            order.setName(txtmname.getText().toString());
            order.setAddress(txtaddress.getText().toString());
            order.setMobileno(Integer.parseInt(txtmobileno.getText().toString()));

            db.PlaceOrder(order);
            Toast.makeText(this, "Order Place Succesful", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Please Fill Details ", Toast.LENGTH_SHORT).show();
        }
    }

    public void vieworders(View view) {
        Intent intent = new Intent(this, View_orders.class);
        startActivity(intent);
    }
}
