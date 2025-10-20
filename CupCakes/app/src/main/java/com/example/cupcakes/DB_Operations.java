package com.example.cupcakes;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DB_Operations extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public DB_Operations(@Nullable Context context){
        super(context, "Capcakes_10", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tblMember (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(20),EMAIL VARCHAR(20) , PSWORD VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tblAdmin (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(20),EMAIL VARCHAR(20) , PSWORD VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tblCategory(CID INTEGER PRIMARY KEY, CName VARCHAR(25))";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tblCupcakes(CCID INTEGER PRIMARY KEY, CCName VARCHAR(25), Price DOUBLE," + "Image BLOG)";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tblOrder (OID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(20),ADDRESS VARCHAR(100) , MOBILENO VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS tblMember";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS tblAdmin";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS tblCategory";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS tblCupcakes";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS tblOrder";
        sqLiteDatabase.execSQL(sql);
    }
    public void insertMember(Member m) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tblMember (NAME,EMAIL,PSWORD) VALUES ('" + m.getName() + "', '" + m.getEmail() + "', '" + m.getPass() + "')";
        db.execSQL(sql);
    }
    public void insertAdmin(Admin admin) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tblAdmin (NAME,EMAIL,PSWORD) VALUES ('" + admin.getName() + "', '" + admin.getEmail() + "', '" + admin.getPass() + "')";
        db.execSQL(sql);
    }
    public Boolean checkmembernamepass(String NAME, String PASS) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select*from tblMember where NAME = ? and PSWORD = ?", new String[]{NAME,PASS});
        if (cursor.getCount() > 0) {

            return true;
        } else {
            return false;
        }


    }
    public Boolean checkadminnamepass(String NAME, String PASS) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select*from tblAdmin where NAME = ? and PSWORD = ?", new String[]{NAME,PASS});
        if (cursor.getCount() > 0) {

            return true;
        } else {
            return false;
        }


    }
    /*public void insertUser(User user){
        String sql = "INSERT INTO tblUser VALUES ('" + user.getEmial()+ "', '"+ user.getFname()+ "','"+ user.getLname()+"','"+user.getPass()+"')";
        SQLiteDatabase database = getReadableDatabase();
        database.execSQL(sql);
    }*/
    public void PlaceOrder(Order order){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase database = getReadableDatabase();

        contentValues.put("OID", order.getOID());
        contentValues.put("Name",order.getName());
        contentValues.put("Address",order.getAddress());
        contentValues.put("MobileNo",order.getMobileno());

        database.insert("tblOrder",null,contentValues);
    }
    public ArrayList<Order> View_orders(){
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM tblOrder";
        ArrayList<Order> orderArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Order Order =new Order();
                Order.setOID(cursor.getInt(0));
                Log.i("ID",""+cursor.getInt(0));
                Order.setName(cursor.getString(1));
                Log.i("Name",""+cursor.getString(1));
                Order.setAddress(cursor.getString(2));
                Log.i("Adress",""+cursor.getString(2));
                Order.setMobileno(Integer.parseInt(cursor.getString(3)));
                Log.i("Mobile_Number",""+cursor.getString(3));
                orderArrayList.add(Order);
            }
        } else {
            orderArrayList  = null;
        }
        return orderArrayList;
    }

//    public void CreateCategory(Category category){
//        ContentValues contentValues = new ContentValues();
//        SQLiteDatabase database = getWritableDatabase();
//
//        contentValues.put("CID", category.getCID());
//        contentValues.put("CName",category.getName());
//        contentValues.put("Image",category.getImage());
//
//        database.insert("tblCategory",null,contentValues);
//    }

    public void insertCategory(int id, String name){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblCategory(CID,CName) VALUES("+id+",'"+name+"')";
        database.execSQL(sql);

    }
    public void insertCup(int id, String name, double price, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblCupcakes(CCID,CCName,Price,Image) VALUES("+id+",'"+name+"',"+price+","+image+")";
        database.execSQL(sql);
    }

//    public void CreateCupcake(Cupcake cupcake){
//        ContentValues contentValues = new ContentValues();
//        SQLiteDatabase database = getWritableDatabase();
//
//        contentValues.put("ID", cupcake.getCCID());
//        contentValues.put("Name",cupcake.getName());
//        contentValues.put("Price",cupcake.getPrice());
//        contentValues.put("Image",cupcake.getImage());
//
//        database.insert("tblCupcakes",null,contentValues);
//    }

    public ArrayList<Category> ViewAll_Categories(){
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM tblCategory";
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Category Category =new Category();
                Category.setCID(cursor.getInt(0));
                Log.i("ID",""+cursor.getInt(0));
                Category.setName(cursor.getString(1));
                Log.i("Name",""+cursor.getString(1));
                categoryArrayList.add(Category);
            }
        } else {
            categoryArrayList  = null;
        }
        return categoryArrayList;
    }

    public Category findcategory(String CID){
        String sql = "SELECT * FROM tblCategory WHERE CID='"+CID+"'";
        Category category = new Category();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(sql,null);
        int count = cursor.getCount();
        if(count!=0){
            cursor.moveToFirst();
            category.setName(cursor.getString(1));
        } else {
            category = null;
        }
        return category;
    }

    public int updateCategory(Category c){
        String sql = "UPDATE tblCategory SET CName='"+c.getName() +"', WHERE CID='"+c.getCID()+"'";
        SQLiteDatabase database = getReadableDatabase();
        db.execSQL(sql);
        ContentValues contentValues = new ContentValues();
        contentValues.put("Category Name", c.getName());
        return database.update("tblCategory", contentValues , "CID='"+c.getCID()+"'", null);
    }

    public int deleteCategory(String cid){
        SQLiteDatabase database = getReadableDatabase();
        return database.delete("tblCategory" , "CID='"+ cid +"'", null);
    }

    public void CreateCupcake(Cupcake cupcake){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase database = getWritableDatabase();

        contentValues.put("CakeID", cupcake.getCCID());
        contentValues.put("Name",cupcake.getName());
        contentValues.put("Price",cupcake.getPrice());
        contentValues.put("Image",cupcake.getImage());

        database.insert("tblCupcakes",null,contentValues);
    }
    public Cupcake findCupcake(String CID){
        String sql = "SELECT * FROM tblCupcake WHERE CID='"+CID+"'";
        Cupcake cupcake = new Cupcake();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(sql,null);
        int count = cursor.getCount();
        if(count!=0){
            cursor.moveToFirst();
            cupcake.setName(cursor.getString(1));
        } else {
            cupcake = null;
        }
        return cupcake;
    }
    public int updateCupcake(Cupcake c){
        SQLiteDatabase database = getReadableDatabase();
        // db.execSQL(sql);
        ContentValues contentValues = new ContentValues();
        contentValues.put("Category Name", c.getName());

        return database.update("tblCupcakes", contentValues , "CakeID='"+c.getCCID()+"'", null);
    }

    public int deleteCupcake(String cid){
        SQLiteDatabase database = getReadableDatabase();

        return database.delete("tblCupcakes" , "CakeID='"+ cid +"'", null);
    }

    public ArrayList<Cupcake> ViewAll_Cupcakes() {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM tblCupcakes";
        ArrayList<Cupcake> cupcakeArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Cupcake cupcake = new Cupcake();
                cupcake.setCCID(cursor.getInt(0));
                Log.i("CID", "" + cursor.getInt(0));
                cupcake.setName(cursor.getString(1));
                Log.i("CName", "" + cursor.getString(1));
                cupcake.setPrice(cursor.getDouble(2));
                Log.i("Price", "" + cursor.getDouble(2));
                cupcake.setImage(cursor.getBlob(3));
                cupcakeArrayList.add(cupcake);
            }
        } else {
            cupcakeArrayList = null;
        }
        return cupcakeArrayList;
    }
}



