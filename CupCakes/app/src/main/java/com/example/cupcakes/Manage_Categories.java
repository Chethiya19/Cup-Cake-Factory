package com.example.cupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;


public class Manage_Categories extends AppCompatActivity {
    EditText txtcid,txtcname;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_categories);
        txtcid = findViewById(R.id.txtcid);
        txtcname = findViewById(R.id.txtcname);
        db = new DB_Operations(this);
    }
    public void getImage(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("aspectX",0);
        intent.putExtra("aspectY",0);
        intent.putExtra("outputX",125);
        intent.putExtra("outputY",125);
        intent.putExtra("crop","true");
        intent.putExtra("return-data","true");
        startActivityForResult(Intent.createChooser(intent,"Select Category Image"),111);
    }

    public void create(View view){
        try{
            Category category = new Category();
            category.setCID(Integer.parseInt(txtcid.getText().toString()));
            category.setName(txtcname.getText().toString());

            db.insertCategory(category.getCID(),category.getName());
            Toast.makeText(this,"Category Created",Toast.LENGTH_SHORT).show();

        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void findcategory(View view){
        try {
            Category category = db .findcategory(txtcid.getText().toString());

            if(category !=null) {
                txtcname.setText(category.getName());
                Toast.makeText(this,"Category record found",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"Category record not found",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }



    public void updateCategory(View view){
        try {
            Category category = new Category();
            category.setCID(Integer.parseInt(txtcid.getText().toString()));
            category.setName(txtcname.getText().toString());
            db.updateCategory(category);
            Toast.makeText(this,"Category updated ",Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }



    public void deleteCategory(View view){
        try {
            db.deleteCategory(txtcid.getText().toString());
            Toast.makeText(this,"Category deleted",Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }

    public void viewallcategories(View view){
        Intent Intent= new Intent(this,ViewAll_Categories.class);
        startActivity(Intent);
    }

    public void clear() {
        txtcid.setText(null);
        txtcname.setText(null);
        txtcid.requestFocus();
    }

    public void cleartxt(View view) {
        clear();
    }
}