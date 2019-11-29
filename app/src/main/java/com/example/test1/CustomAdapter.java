
        package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter<C> extends ArrayAdapter<Item> {
    Context context;
    int resource ;
    ArrayList<Item>ArrItem;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> ArrItem) {
        super(context,resource,ArrItem);
        this.context=context;
        this.resource=resource;
        this.ArrItem=ArrItem;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_listview,parent,false);
            viewHoder=new ViewHoder();
            viewHoder.tvName=(TextView)convertView.findViewById(R.id.tv_name);
            viewHoder.tvPrice=(TextView)convertView.findViewById(R.id.tv_price);
            convertView.setTag(viewHoder);

        }
        else {
            viewHoder=(ViewHoder)convertView.getTag();
        }
        Item item=ArrItem.get(position);
        viewHoder.tvName.setText(item.getName());
        viewHoder.tvPrice.setText(item.getPrice());
        return convertView;
    }
    public class ViewHoder{
        TextView tvName;
        TextView tvPrice;

    }
}