package com.example.kushmaheshwari.myfirstapp;



import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
//import com.parse.Parse;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//import com.parse.SaveCallback;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class MyActivity extends AppCompatActivity {
    public static ArrayList<Group> events = new ArrayList();
    private static final String TAG = "MyActivity";
    public final static String EXTRA_MESSAGE = "com.example.kushmaheshwari.myfirstapp.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        File f = new File(getApplicationContext().getFilesDir(), "MyFile.ser");
     //   f.delete();
        if (f.exists()) {
            events = null;
            try {
                FileInputStream fileInputStream = getApplicationContext().openFileInput("MyFile.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                events = (ArrayList<Group>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
        } else if (id == R.id.add_event) {
            Intent intent = new Intent(this, CreateDialogActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stop");

        try {
            FileOutputStream fileOutputStream = getApplicationContext().openFileOutput("MyFile.ser", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(events);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Start");
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"Pause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Resume");

    }
}

/*   Parse.enableLocalDatastore(this);
        Parse.initialize(this, "rHGV9FGCfAmttDmdVGMEnEtVdRyjW2iiWKIlRisr", "SAe1rn97Pd6WKJuo0zYkbCv4uRbOKqGYsxWC8Uyt");
        if(count==0){
            Log.d(TAG,"Make new parse");
            MyActivity.object = new ParseObject("AEvents");
            MyActivity.object.setObjectId("FinalEvents");
            count=1;
            return;
        }
        ParseQuery<ParseObject> query = ParseQuery.getQuery("AEvents");
        query.fromLocalDatastore();
        query.getInBackground("FinalEvents", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    try {
                        JSONArray a = object.getJSONArray("BEvents");
                        for (int i = 0; i < a.length(); i++) {
                            Log.d(TAG, a.get(i).toString());
                            events.add(a.get(i).toString());
                            MainListFragment.adapter.notifyDataSetChanged();
                        }

                    } catch (JSONException f) {

                    }
                } else {

                }
            }
        });*/

  /*   try {
            JSONArray array=new JSONArray();
            for (int i = 0; i < events.size(); i++) {
                array.put(i, events.get(i));
                Log.d(TAG, events.get(i));
            }
            if (object.has("BEvents")) {
                Log.d(TAG, "Has BEvents");
                object.remove("BEvents");
            }
            object.put("BEvents", array);
            object.pinInBackground();

        } catch(JSONException e) {
            Log.d(TAG, "WRONGGGG");
            throw new RuntimeException(e);
        }
    }


      /*  ParseObject testObject = new ParseObject("Events");
        testObject.put("myevents", events);
        testObject.setObjectId("Events");
        testObject.saveInBackground();*/
