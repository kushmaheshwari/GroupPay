package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kushmaheshwari on 6/26/15.
 */
public class CheckBoxAdapter extends ArrayAdapter {
    Context c;
    ArrayList<Member> members;
    public CheckBoxAdapter(Context c,ArrayList a){
        super(c,R.layout.checkbox_row,a);
        this.c=c;
        this.members=a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)c).getLayoutInflater();
        convertView = inflater.inflate(R.layout.checkbox_row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkbox1);
        name.setText(members.get(position).getName());
        if(members.get(position).getChecked()==true){
            cb.setChecked(true);
        }else{
            cb.setChecked(false);
        }
        return convertView;
    }


}
