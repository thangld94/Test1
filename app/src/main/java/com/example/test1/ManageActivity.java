package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ManageActivity extends AppCompatActivity {
    ListView lv;
    static ArrayList<Bill>arrBill=new ArrayList<>();
    CustomManage<Bill> customManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        lv=(ListView)findViewById(R.id.lv);
        Intent intent=getIntent();
        String tv1=intent.getStringExtra("tv1");
        String tv2=intent.getStringExtra("tv2");
        String tv3=intent.getStringExtra("tv3");
        arrBill.add(new Bill(tv1,tv2,tv3));
        //arrBill=MainActivity.db.getAllBill();
        customManage=new CustomManage<>(this,R.layout.activity_bill,arrBill);
        lv.setAdapter(customManage);

    }
}
