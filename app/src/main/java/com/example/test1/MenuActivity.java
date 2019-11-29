package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<Item>itemArrayList;
    private CustomAdapter<Item>customAdapter;
    private ListView lvItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lvItem=(ListView)findViewById(R.id.lv_menu);
        itemArrayList=new ArrayList<>();
        itemArrayList.add(new Item("Chân gà xả tắc","20000"));
        itemArrayList.add(new Item("Nem chua rán","25000"));
        itemArrayList.add(new Item("Xoài lắc","10000"));
        customAdapter=new CustomAdapter<>(this,R.layout.row_listview,itemArrayList);
        lvItem.setAdapter(customAdapter);
        //customAdapter.notifyDataSetChanged();
    }
}

