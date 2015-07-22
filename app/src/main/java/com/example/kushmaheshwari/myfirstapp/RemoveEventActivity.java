package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class RemoveEventActivity extends Activity {
    Button no;
    Button yes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_event);
        no=(Button)findViewById(R.id.No);
        no.setOnClickListener(myhandler1);
        yes=(Button)findViewById(R.id.yes);
        yes.setOnClickListener(myhandler2);
    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
                finish();
        }
    };

    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent=getIntent();
            int index=intent.getIntExtra("Index",0);//check these parameters
            MyActivity.events.remove(index);
        //    Group.allNames.remove(index);
            MainListFragment.groupAdapter.notifyDataSetChanged();
            finish();
        }
    };


}
