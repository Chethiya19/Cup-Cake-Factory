package com.example.cupcakes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Cupcake_Adapter extends BaseAdapter {

    Context context;
    ArrayList<Cupcake> CupcakeArrayList;
    TextView lblCakeid, lblCatname;
    ImageView imgCupcake;
    Button btnClick;

    public Cupcake_Adapter(Context context, ArrayList<Cupcake> cupcakes){
        this.context = context;
        CupcakeArrayList = cupcakes;
    }

    @Override
    public int getCount() {
        return CupcakeArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return CupcakeArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewcupake = layoutInflater.inflate(R.layout.cupcake_view_layout,viewGroup,false);

        lblCakeid = viewcupake.findViewById(R.id.lblcupcakeid);
        lblCatname = viewcupake.findViewById(R.id.lblcupcake_name);
        imgCupcake = viewcupake.findViewById(R.id.imgcake);
        btnClick = viewcupake.findViewById(R.id.btnclick2);

        Cupcake cupcake = CupcakeArrayList.get(i);
        lblCakeid.setText(""+ cupcake.getCCID());
        lblCatname.setText(cupcake.getName());

        Bitmap bitmap = BitmapFactory.decodeByteArray(cupcake.getImage(),0,cupcake.getImage().length);
        imgCupcake.setImageBitmap(bitmap);
        btnClick.setTag(i);

        return viewcupake;
    }
}
