package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {
   TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("tv1"));
        tv3.setText(intent.getStringExtra("tv3"));



    }
}
