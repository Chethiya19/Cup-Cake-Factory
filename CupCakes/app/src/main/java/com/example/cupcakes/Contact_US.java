package com.example.cupcakes;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contact_US extends AppCompatActivity {

    EditText txtMobile, txtMessage;
    TextView lblCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        txtMessage = findViewById(R.id.txtMessage);
        txtMobile = findViewById(R.id.txtMobNumber);
        lblCount = findViewById(R.id.lblCount);

        if(Build.VERSION.SDK_INT>=23){
            if(ContextCompat.checkSelfPermission(Contact_US.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Contact_US.this, new String[]{Manifest.permission.SEND_SMS},11);
            }
        }

        txtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lblCount.setText(charSequence.length()+"/160");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void send_sms(View view){
        String mobile_num = txtMobile.getText().toString();
        String message = txtMessage.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(mobile_num,null,message,null,null);
            Toast.makeText(this,"SMS Sent",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("SEND SMS ","ERROR : "+ex.getMessage());
        }
    }

}