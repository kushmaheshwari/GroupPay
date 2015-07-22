package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;


public class ExpensesFragment extends android.support.v4.app.ListFragment {
    public static ArrayAdapter<Expense> expensesAdapter;
    public static ArrayList<Expense> expenses = new ArrayList();
    private Button addExpense;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.expense_item,container,false);
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        expensesAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,expenses);
        expensesAdapter.notifyDataSetChanged();
        setListAdapter(expensesAdapter);
        addExpense=(Button)getView().findViewById(R.id.expensebutton);
        addExpense.setOnClickListener(myhandler1);


    }
    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i=new Intent(getActivity(),AddExpenseActivity.class);
            startActivity(i);
        }
    };
}
