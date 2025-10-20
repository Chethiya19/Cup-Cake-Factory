package com.example.cupcakes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;

public class Manage_cupcakes extends AppCompatActivity {
    EditText txtcakeid,txtcakename,txtprice;
    ImageView CupcakeImage;
    byte[] imageArray;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cupcakes);
        txtcakeid = findViewById(R.id.txtcakeid);
        txtcakename = findViewById(R.id.txtcattname);
        txtprice = findViewById(R.id.txtprice);
        CupcakeImage = findViewById(R.id.CupcakeImage);
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
        startActivityForResult(Intent.createChooser(intent,"Select Cupcake Image"),111);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==111){
            if (data !=null){
                try{
                    Uri uri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    ByteArrayOutputStream outputStreame = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,0, outputStreame);
                    imageArray = outputStreame.toByteArray();
                    CupcakeImage.setImageBitmap(bitmap);
                } catch (Exception ex) {
                    Log.e("Error", ex.getMessage());
                }
            }
        }
    }
//    public void createcup(View view){
//        try{
//            Cupcake cupcake = new Cupcake();
//            cupcake.setCCID(Integer.parseInt(txtcakeid.getText().toString()));
//            cupcake.setName(txtcakename.getText().toString());
//            cupcake.setPrice(Double.parseDouble(txtprice.getText().toString()));
//            cupcake.setImage(imageArray);
//
//            db.insertCup(cupcake.getCCID(),cupcake.getName(),cupcake.getPrice(),cupcake.getImage());
//            Toast.makeText(this,"Cupcake Created",Toast.LENGTH_SHORT).show();
//
//        }catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }

    public void Create(View view){
        try{
            Cupcake cupcake = new Cupcake();
            cupcake.setCCID(Integer.parseInt(txtcakeid.getText().toString()));
            cupcake.setName(txtcakename.getText().toString());
            cupcake.setPrice(Double.parseDouble(txtprice.getText().toString()));
            cupcake.setImage(imageArray);

            db.CreateCupcake(cupcake);
            Toast.makeText(this,"Cupcake Created",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void findCupcake(View view){
        try {
            Cupcake cupcake = db .findCupcake(txtcakeid.getText().toString());

            if(cupcake !=null) {
                txtcakename.setText(cupcake.getName());
                Toast.makeText(this,"Cupcake record found",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"Cupcake record not found",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }
    public void updateCupcake(View view){
        try {
            Cupcake cupcake = new Cupcake();
            cupcake.setCCID(Integer.parseInt(txtcakeid.getText().toString()));
            cupcake.setName(txtcakename.getText().toString());
            db.updateCupcake(cupcake);
            Toast.makeText(this,"Cupcake updated ",Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }

    public void deleteCupcake(View view){
        try {
            db.deleteCupcake(txtcakeid.getText().toString());
            Toast.makeText(this,"Cupcake deleted",Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Log.e("Find","Error" + ex.getMessage());
        }
    }
    public void viewAllCupcake(View view){
        Intent intent = new Intent(this,View_Cupcakes.class);
        startActivity(intent);
    }

}