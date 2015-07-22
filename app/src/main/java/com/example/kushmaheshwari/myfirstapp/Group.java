package com.example.kushmaheshwari.myfirstapp;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by kushmaheshwari on 6/26/15.
 */
public class Group implements Serializable{
    private String name;
    private ArrayList<Member> members;
    private ArrayList<Expense> expenses;
  //  public static ArrayList<String> allNames=new ArrayList<>();


    public Group(String n){
        name=n;
        members = new ArrayList<>();
        expenses=new ArrayList<>();
    //    allNames.add(0,this.name);
    }

    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }

    public void addMember(Member m){
        members.add(m);
    }
    public void removeMember(int i){
        members.remove(i);
    }
    public void addExpense(Expense e){
        expenses.add(e);
    }
    public void removeExpense(int i){
        expenses.remove(i);
    }
    public String toString(){
        return name;
    }





}
