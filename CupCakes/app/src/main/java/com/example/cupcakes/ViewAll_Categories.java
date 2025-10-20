package com.example.cupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAll_Categories extends AppCompatActivity {

    ArrayList<Category> categoryArrayList;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_categories);

        ListView listView = findViewById(R.id.lstallcategories);
        db = new DB_Operations(this);

        categoryArrayList = db.ViewAll_Categories();

        ArrayList<Category> categoryArrayList = db.ViewAll_Categories();
        ArrayList<String> category = new ArrayList();

        if(categoryArrayList!=null){
            int count = categoryArrayList.size();
            String categories;

            for(int i=0; i<count; i++){
                Category category1 = categoryArrayList.get(i);
                categories = category1.getCID()+"\n"+ category1.getName();
                category.add(categories);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,category);
        listView.setAdapter(adapter);
    }

    public void getSelectedCategory(View view){
        int index = (int)view.getTag();
        Category Category = categoryArrayList.get(index);
        Toast.makeText(this,Category.getName() +"\n",Toast.LENGTH_SHORT).show();
    }

}