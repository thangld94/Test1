package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<Item>itemArrayList;
    private CustomAdapter<Item>customAdapter;
    private ListView lvItem;
    private EditText ban;
    private  String tv1="Tên món\n\n";
    private String tv2="\n\nSố lượng\n\n";
    private String tv3="\n\nThành tiền\n\n";
    private  int price=0;
    private  int temp=0;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lvItem = (ListView) findViewById(R.id.lv_menu);
        btnAdd = (Button) findViewById(R.id.btn_add);
        ban=(EditText)findViewById(R.id.edt_id);
        itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item(Item.ID, "Chân gà xả tắc", "20000", R.drawable.changa));
        itemArrayList.add(new Item(Item.ID, "Bánh tráng trộn", "15000", R.drawable.banhtrang));
        itemArrayList.add(new Item(Item.ID, "Xoài lắc", "20000", R.drawable.xoailac));
        itemArrayList.add(new Item(Item.ID, "Tai heo trộn", "30000", R.drawable.taiheo));
        itemArrayList.add(new Item(Item.ID, "Bánh xèo", "40000", R.drawable.banh_xeo));
        itemArrayList.add(new Item(Item.ID, "Bún đậu mắm tôm", "30000", R.drawable.bun_dau));
        itemArrayList.add(new Item(Item.ID, "Mì xào", "50000", R.drawable.mi_xao));
        itemArrayList.add(new Item(Item.ID, "Ốc hút", "30000", R.drawable.oc_hut));
        itemArrayList.add(new Item(Item.ID, "Phô mai que", "25000", R.drawable.pho_mai));
        customAdapter = new CustomAdapter<>(this, R.layout.row_listview, itemArrayList);
        lvItem.setAdapter(customAdapter);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item item = (Item) adapterView.getItemAtPosition(position);
                tv1 = "" + tv1 + item.getName() + "\n"+"\n";
                temp= Integer.parseInt(item.getPrice());
                view_dialog();

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, BillActivity.class);
                String so_ban=ban.getText().toString();
                if(so_ban.equals("")){
                    Toast.makeText(MenuActivity.this,"Bạn phải nhập số bàn",Toast.LENGTH_SHORT).show();
                }
                else {
                    DateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss");
                    dateFormatter.setLenient(false);
                    Date today = new Date();
                    String s = dateFormatter.format(today);
                    tv1 = "Số bàn: " + so_ban +"\n\n" + tv1 + "Tổng tiền:";
                    String a = String.valueOf(price);
                    tv3 = "" + tv3 + a ;
                    intent.putExtra("time_in",s);
                    intent.putExtra("tv1", tv1);
                    intent.putExtra("tv3", tv3);
                    intent.putExtra("tv2", tv2);
                    tv1 = "Tên món\n\n";
                    tv3 = "Thành tiền\n\n";
                    tv2 = "\n\nSố lượng\n\n";
                    price = 0;
                    startActivity(intent);
                }

            }
        });

    }
    public void view_dialog(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.detail_food);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(lp);

        final EditText soluong=(EditText)dialog.findViewById(R.id.edt_num);
        Button choice=(Button)dialog.findViewById(R.id.choice);
        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String b=soluong.getText().toString();
                tv2=tv2+b+"\n"+"\n";
                price = price + temp*Integer.parseInt(b);
                String a=String.valueOf(temp*Integer.parseInt(b));
                tv3=""+tv3+a+"\n\n";
                dialog.dismiss();


            }
        });

        dialog.show();


    }

}
