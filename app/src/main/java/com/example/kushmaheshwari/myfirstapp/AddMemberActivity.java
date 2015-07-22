package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddMemberActivity extends Activity {
    Button add;
    Button cancel;
    EditText view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        add=(Button)findViewById(R.id.create);
        add.setOnClickListener(myhandler1);
        cancel=(Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(myhandler2);
        view=(EditText)findViewById(R.id.eventname);
    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            String event=view.getText().toString();
            if(event.length()==0){
                Toast.makeText(v.getContext(), "You must provide a name", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            MembersFragment.members.add(0,new Member(event));
            MembersFragment.membersAdapter.notifyDataSetChanged();
            finish();
        }
    };

    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };
}
