package com.example.lizet.assignment2_121;

import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] shit;
    private StringBuffer buffer;

    //private String[] titleArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Event Logging");
        buffer = new StringBuffer();
        //Toast.makeText(MainActivity.this, "dfhgdjh", Toast.LENGTH_LONG).show();
        Log.d("before", "try");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("vivz.txt");
            int read = -1;
            //buffer = new StringBuffer();
            Log.d("before", "while");
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }

        finally{
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (buffer.length() == 0) {
                Log.d("in dis bitch", "hehehe");
                //Toast.makeText(MainActivity.this, "nothiinggggg :(", Toast.LENGTH_LONG).show();
                String nothingToShow[] = new String[1];
                nothingToShow[0] = "No events to show";
                ListAdapter listAd = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nothingToShow);
                ListView listEvent = findViewById(R.id.title);
                listEvent.setAdapter(listAd);

            }else{
                Log.d("VIVZ", buffer.toString());
                String lt = buffer.toString();
                shit = lt.split("\n");
                String titleArray[] = new String[shit.length];
                //parse title
                for (int i = 0; i < shit.length; i++) {
                    JSONParser parser = new JSONParser();
                    org.json.simple.JSONObject whatever = null;
                    try {
                        whatever = (org.json.simple.JSONObject) parser.parse(shit[i]);
                        String ttt = (String) whatever.get("title");
                        titleArray[i] = ttt;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


                ListAdapter listAd = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, titleArray);
                ListView listEvent = findViewById(R.id.title);
                listEvent.setAdapter(listAd);

                listEvent.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent2 = new Intent(MainActivity.this, EventDetails.class);
                                intent2.putExtra("position", position);
                                //Toast.makeText(MainActivity.this, Event, Toast.LENGTH_LONG).show();
                                startActivity(intent2);
                            }
                        }
                );
            }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbarstuff1,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddEventPage.class);
        startActivity(intent);
        return true;
    }


}
