package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class MembersFragment extends android.support.v4.app.ListFragment {
    public static ArrayAdapter<Member> membersAdapter;
    public static ArrayList<Member> members = new ArrayList();
    private Button addMember;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.member_item,container,false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        membersAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,members);
        membersAdapter.notifyDataSetChanged();
        setListAdapter(membersAdapter);

        addMember=(Button)getView().findViewById(R.id.addMemberButton);
        addMember.setOnClickListener(myhandler1);



    }
    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i=new Intent(getActivity(),AddMemberActivity.class);
            startActivity(i);
        }
    };






}
