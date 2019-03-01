package com.example.todolist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.todolist.R.id.checkBox;

public class ItemListAdapter extends BaseAdapter {
    private ArrayList<Item> list;
    private Context context;

    public ItemListAdapter(ArrayList<Item> l, Context context){
        list = l;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position).getText();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public boolean isChecked(int position) {
        return list.get(position).checked;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder view = null;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        if (view == null){
            view = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_main, null);
            view.text = (TextView) convertView.findViewById(R.id.entry);
            view.checkbox = (CheckBox) convertView.findViewById(R.id.checkBox);
            view.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int position = (Integer) buttonView.getTag();
                    list.get(position).setChecked(buttonView.isChecked());
                    if (isChecked) {

                    }


                }
            });
            convertView.setTag(view);
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        view.checkbox.setTag(position);
        view.text.setText("" + list.get(position).getText());
        view.checkbox.setChecked(list.get(position).isChecked());

        return convertView;

    }
}