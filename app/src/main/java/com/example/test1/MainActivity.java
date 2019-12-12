package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout manhinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manhinh=(LinearLayout)findViewById(R.id.manHinh);
        manhinh.setBackgroundResource(R.drawable.nnn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_manage,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_menu:
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_bill:
                Intent intent1=new Intent(MainActivity.this,BillActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_manage:
                Intent intent2=new Intent(MainActivity.this,ManageActivity.class);
                startActivity(intent2);
            case R.id.menu_search:


        }
        return super.onOptionsItemSelected(item);
    }
}
