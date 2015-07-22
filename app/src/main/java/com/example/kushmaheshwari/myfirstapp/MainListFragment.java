package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainListFragment extends ListFragment implements AdapterView.OnItemClickListener{
    public static ArrayAdapter<Group> groupAdapter;
    public final static String EXTRA_NAME = "com.mycompany.myfirstapp.NAME";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.list_item, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        groupAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,MyActivity.events);
        groupAdapter.notifyDataSetChanged();
        setListAdapter(groupAdapter);
        getListView().setOnItemClickListener(this);


        AdapterView.OnItemLongClickListener listener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Toast.makeText( getActivity().getBaseContext()  , "Long Clicked "  , Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(arg0.getContext(),RemoveEventActivity.class);
                intent.putExtra("Index",position);
                startActivity(intent);
                return true;
            }
        };

        getListView().setOnItemLongClickListener(listener);

    }



    public void onItemClick(AdapterView<?> adapterView,View view,int i, long l){
        Intent intent= new Intent(adapterView.getContext(),GroupActivity.class);
      //  intent.putExtra(EXTRA_NAME,MyActivity.events.get(i));
        startActivity(intent);

        Toast.makeText(getActivity(), "Item" + i, Toast.LENGTH_SHORT).show();
    }



}
