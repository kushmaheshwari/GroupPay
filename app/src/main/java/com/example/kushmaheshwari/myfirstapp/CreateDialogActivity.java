package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateDialogActivity extends Activity {
    Button create;
    Button cancel;
    EditText view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_newevent);
        create=(Button)findViewById(R.id.create);
        create.setOnClickListener(myhandler1);
        cancel=(Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(myhandler2);
        view=(EditText)findViewById(R.id.eventname);
    }


    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            String event=view.getText().toString();
            if(event.length()==0){
                Toast.makeText(v.getContext(), "You must provide a title", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            MyActivity.events.add(0,new Group(event));
            MainListFragment.groupAdapter.notifyDataSetChanged();
            finish();
        }
    };

    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };





}
