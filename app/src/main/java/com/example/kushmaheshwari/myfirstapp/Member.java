package com.example.kushmaheshwari.myfirstapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kushmaheshwari on 6/26/15.
 */
public class Member implements Serializable {
    private String name;
    private boolean isChecked;
    public Member(String n){
        name=n;
        isChecked=false;
    }
    public String getName(){
        return name;
    }
    public boolean getChecked(){
        return isChecked;
    }
    public void setChecked(boolean b){
        isChecked=b;
    }
    public String toString(){
        return name;
    }
}
