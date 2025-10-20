package com.example.cupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class View_orders extends AppCompatActivity {
    ArrayList<Order> orderArrayList;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);
        ListView listView = findViewById(R.id.lstallorders);
        db = new DB_Operations(this);

        orderArrayList = db.View_orders();

        ArrayList<Order> orderArrayList = db.View_orders();
        ArrayList<String> order = new ArrayList();

        if(orderArrayList!=null){
            int count = orderArrayList.size();
            String Orders;

            for(int i=0; i<count; i++){
                Order Order1 = orderArrayList.get(i);
                Orders = Order1.getOID()+"\n"+ Order1.getName()+"\n" + Order1.getAddress()+"\n" + Order1.getMobileno();
                order.add(Orders);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,order);
        listView.setAdapter(adapter);
    }

//    public void getSelectedCategory(View view){
//        int index = (int)view.getTag();
//        Order order = orderArrayList.get(index);
//        Toast.makeText(this,Category.getName() +"\n",Toast.LENGTH_SHORT).show();
//    }
}