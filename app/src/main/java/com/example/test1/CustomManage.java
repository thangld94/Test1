
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
            convertView.setTag(viewHoder);

        }
        else {
            viewHoder=(ViewHoder)convertView.getTag();
        }
        Bill bill=ArrBill.get(position);
        viewHoder.tv1.setText(bill.getTv1());
        viewHoder.tv2.setText(bill.getTv2());
        viewHoder.tv3.setText(bill.getTv3());

        return convertView;
    }
    public class ViewHoder{
       TextView tv1,tv2,tv3;

    }
}