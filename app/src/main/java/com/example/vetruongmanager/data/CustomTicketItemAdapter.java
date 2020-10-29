package com.example.vetruongmanager.data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vetruongmanager.R;

import java.util.List;

public class CustomTicketItemAdapter extends BaseAdapter {
    private List<Ticket> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomTicketItemAdapter(Context aContext,  List<Ticket> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.ticket_item_layout, null);
            holder = new ViewHolder();
            holder.numberView = (TextView) convertView.findViewById(R.id.ticket_number);
            holder.nameView = (TextView) convertView.findViewById(R.id.ticket_name);
            holder.phoneView = (TextView) convertView.findViewById(R.id.ticket_phone_number);
            holder.classView = (TextView) convertView.findViewById(R.id.ticket_class);
            holder.checkView = (ImageView) convertView.findViewById(R.id.ticket_check_box);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Ticket ticket = this.listData.get(position);
        holder.numberView.setText("ID: " + String.valueOf(ticket.getNumber()));
        holder.nameView.setText(ticket.getName());
        holder.phoneView.setText(ticket.getPhoneNumber());
        holder.classView.setText(ticket.getClassNumber());

        if(ticket.isPaid()){
            holder.checkView.setImageResource(R.drawable.ic_checked);
        }

        return convertView;
    }


    static class ViewHolder {
        TextView nameView;
        TextView phoneView;
        TextView classView;
        TextView numberView;
        ImageView checkView;
    }

}
