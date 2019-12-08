package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<Item>itemArrayList;
    private CustomAdapter<Item>customAdapter;
    private ListView lvItem;
    private  String tv1="";
    private String tv2="";
    private String tv3="";
    private  int price=0;
    Button btnAdd;
    //EditText edtBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lvItem = (ListView) findViewById(R.id.lv_menu);
        btnAdd = (Button) findViewById(R.id.btn_add);
        //edtBan=(EditText)findViewById(R.id.edt_id);
        itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item(Item.ID, "Chân gà xả tắc", "20000", R.drawable.changa));
        itemArrayList.add(new Item(Item.ID, "Nem chua rán", "25000", R.drawable.nemchuaran));
        itemArrayList.add(new Item(Item.ID, "Bánh tráng trộn", "10000", R.drawable.banhtrang));
        itemArrayList.add(new Item(Item.ID, "Xoài lắc", "20000", R.drawable.xoailac));
        itemArrayList.add(new Item(Item.ID, "Tai heo ngâm mắm thái", "30000", R.drawable.taiheo));
        customAdapter = new CustomAdapter<>(this, R.layout.row_listview, itemArrayList);
        lvItem.setAdapter(customAdapter);


        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item item = (Item) adapterView.getItemAtPosition(position);
                tv1 = "" + tv1 + item.getName() + "\n"+"\n";
                tv3=""+tv3+item.getPrice()+"\n"+"\n";
                price = price + Integer.parseInt(item.getPrice());

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, BillActivity.class);
                tv1=""+tv1+"Tổng tiền:";
                intent.putExtra("tv1", tv1);
                String a=String.valueOf(price);
                tv3=""+tv3+a;
                intent.putExtra("tv3",tv3);
                tv1="";
                tv3="";
                price=0;
                startActivity(intent);

            }
        });

    }

}