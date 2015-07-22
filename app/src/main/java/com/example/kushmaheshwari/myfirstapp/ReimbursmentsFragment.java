package com.example.kushmaheshwari.myfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ReimbursmentsFragment extends android.support.v4.app.ListFragment {
    public static ArrayAdapter<Member> reimbursmentMembers;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reimbursments,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        reimbursmentMembers=new ArrayAdapter<Member>(getActivity(),android.R.layout.simple_list_item_1,MembersFragment.members);
        reimbursmentMembers.notifyDataSetChanged();
        setListAdapter(reimbursmentMembers);

    }
}