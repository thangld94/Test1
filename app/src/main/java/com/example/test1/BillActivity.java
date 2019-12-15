package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BillActivity extends AppCompatActivity {
   TextView tv1,tv2,tv3;
   String tv11,tv22,tv33,time_in;
   Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);

        pay=(Button)findViewById(R.id.pay);
        Intent intent=getIntent();
        tv11=intent.getStringExtra("tv1");
        tv22=intent.getStringExtra("tv2");
        tv33=intent.getStringExtra("tv3");
        time_in=intent.getStringExtra("time_in");
        tv1.setText(tv11);
        tv2.setText(tv22);
        tv3.setText(tv33);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss");
                dateFormatter.setLenient(false);
                Date today = new Date();
                String s = dateFormatter.format(today);
                time_in="Thời gian vào: "+time_in;
                s="Thời gian ra: "+s;
                Intent intent = new Intent(BillActivity.this,ManageActivity.class);
                intent.putExtra("tv1",tv11);
                intent.putExtra("tv2",tv22);
                intent.putExtra("tv3",tv33);
                intent.putExtra("time_in",time_in);
                intent.putExtra("time_out",s);
                startActivity(intent);
            }
        });



    }
}
