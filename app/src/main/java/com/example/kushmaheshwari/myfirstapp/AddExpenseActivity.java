package com.example.kushmaheshwari.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class AddExpenseActivity extends Activity  {
    Expense expense;
    private Button addAll;
    private Button addExpense;
    private String title;
    private Double amount;
    private Member payer;
    private ArrayList<Member> paymentMembers=new ArrayList<>();
    private CheckBoxAdapter a;
    private Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        expense=new Expense(MembersFragment.members);


        s = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<Member> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, expense.getPossibleMembers());
        s.setAdapter(adapter);

        ListView lv = (ListView) findViewById(R.id.listViewcheck);
        a=new CheckBoxAdapter(this,expense.getPossibleMembers());
        lv.setAdapter(a);

        addAll=(Button)findViewById(R.id.addallbutton);
        addAll.setOnClickListener(myhandler1);
        addExpense=(Button)findViewById((R.id.addexpense));
        addExpense.setOnClickListener(myhandler2);

    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            expense.setCheckedtoTrue();
            a.notifyDataSetChanged();
        }
    };
    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            title = ((EditText)findViewById(R.id.expenseTitle)).getText().toString();
            amount= Double.parseDouble(((EditText) findViewById(R.id.expenseAmount)).getText().toString());
            payer=(Member)s.getSelectedItem();
            for (int i=0;i<expense.getPossibleMembers().size();i++){
                if(expense.getPossibleMembers().get(i).getChecked()){
                    paymentMembers.add(expense.getPossibleMembers().get(i));
                }
            }
            expense.setName(title);
            expense.setAmount(amount);
            expense.setPayer(payer);
            expense.setPaymentMembers(paymentMembers);
            ExpensesFragment.expenses.add(0, expense);
            ExpensesFragment.expensesAdapter.notifyDataSetChanged();
            finish();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_expense, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
