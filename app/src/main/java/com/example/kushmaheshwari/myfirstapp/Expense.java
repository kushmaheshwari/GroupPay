package com.example.kushmaheshwari.myfirstapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kushmaheshwari on 6/26/15.
 */

public class Expense implements Serializable {
    private String name;
    private Double amount;
    private Member payer;
    private ArrayList<Member> possibleMembers;
    private ArrayList<Member> paymentMembers;
    public static ArrayList<String> expenseNames=new ArrayList<>();


    public Expense(ArrayList<Member> members){
        possibleMembers=members;
        setCheckedtoFalse();
    }
    public ArrayList<Member> getPossibleMembers(){
        return possibleMembers;
    }
    public void setCheckedtoFalse(){
        for(int i=0;i<possibleMembers.size();i++){
            possibleMembers.get(i).setChecked(false);
        }
    }
    public void setCheckedtoTrue(){
        for(int i=0;i<possibleMembers.size();i++){
            possibleMembers.get(i).setChecked(true);
        }
    }
    public void setName(String n){
        name=n;
    }
    public void setAmount(Double d){
        amount=d;
    }
    public void setPayer(Member m){
        payer=m;
    }
    public void setPaymentMembers(ArrayList<Member> a){
        paymentMembers=a;
    }
    public String toString(){
        return name;
    }



}
