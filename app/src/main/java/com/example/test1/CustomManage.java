
package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CustomManage <C> extends ArrayAdapter<Bill> {
    Context context;
    int resource ;
    ArrayList<Bill>ArrBill;

    public CustomManage (@NonNull Context context, int resource, @NonNull ArrayList<Bill> ArrBill) {
        super(context,resource,ArrBill);
        this.context=context;
        this.resource=resource;
        this.ArrBill=ArrBill;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.bill_listview,parent,false);
            viewHoder=new ViewHoder();
            viewHoder.tv1=(TextView)convertView.findViewById(R.id.tv1);
            viewHoder.tv2=(TextView)convertView.findViewById(R.id.tv2);
            viewHoder.tv3=(TextView)convertView.findViewById(R.id.tv3);
            ViewHoder.time_in=(TextView)convertView.findViewById(R.id.time_in);
            ViewHoder.time_out=(TextView)convertView.findViewById(R.id.time_out);
            convertView.setTag(viewHoder);

        }
        else {
            viewHoder=(ViewHoder)convertView.getTag();
        }
        Bill bill=ArrBill.get(position);
        viewHoder.tv1.setText(bill.getTv1());
        viewHoder.tv2.setText(bill.getTv2());
        viewHoder.tv3.setText(bill.getTv3());
        viewHoder.time_in.setText(bill.getTime_in());
        viewHoder.time_out.setText(bill.getTime_out());

        return convertView;
    }
    public static class ViewHoder{

        public static TextView time_in,tv1,tv2,tv3,time_out;


    }
}