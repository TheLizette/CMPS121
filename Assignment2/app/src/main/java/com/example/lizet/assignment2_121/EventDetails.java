package com.example.lizet.assignment2_121;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import org.json.JSONObject;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EventDetails extends AppCompatActivity {
    private TextView editTitle;
    private TextView editTime;
    private TextView editDate;
    private TextView editGPS;
    private TextView editEventDescript;
    private Button DeleteButton;
    private int value;

    private String[] shit;
    private  ArrayList  <String> copyArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        setTitle("Event Logging");
        editTitle = findViewById(R.id.textView7);
        editTime = findViewById(R.id.textView8);
        editDate = findViewById(R.id.textView9);
        editGPS = findViewById(R.id.textView10);
        editEventDescript = findViewById(R.id.textView11);
        DeleteButton = findViewById(R.id.button2);

        Intent losportalesss = getIntent();
        if  (losportalesss ==  null){
            return;
        }
        value = losportalesss.getIntExtra("position", 0);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream =openFileInput("vivz.txt");
            int read=-1;
            StringBuffer buffer =new StringBuffer();
            Log.d("before", "while");
            while((read=fileInputStream.read())!=-1)
            {
                buffer.append((char)read);
            }
            Log.d("VIVZ" , buffer.toString());

            String lt = buffer.toString();
            shit =lt.split("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String b = shit[value];
        JSONParser ok =new JSONParser();
        org.json.simple.JSONObject whatever = null;
        try {
           whatever = (org.json.simple.JSONObject)ok.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String ttt;
        String ddd;
        ttt = (String) whatever.get("title");
        ddd = (String) whatever.get("description");
        editTitle.setText(ttt);
        editEventDescript.setText(ddd);
        String time;
        String date;
        time = (String) whatever.get("time");
        date = (String) whatever.get("date");
        editTime.setText(time);
        editDate.setText(date);
        String gps;
        gps= (String) whatever.get("gps");
        editGPS.setText(gps);

        copyArray = new ArrayList<String>();
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(EventDetails.this, MainActivity.class);
                for(int i = 0; i < shit.length; i++)
                {
                    if(i==value){
                        continue;
                    }
                    else{
                        copyArray.add(shit[i]);
                    }
                }

                //clear the file
                File file =null;
                FileOutputStream fileOutputStream= null;
                try {
                    fileOutputStream = openFileOutput("vivz.txt", Context.MODE_PRIVATE);
                    String empty = "";
                    fileOutputStream.write(empty.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //write copyarray into file
                try {
                    for(int i = 0; i < copyArray.size(); i++)
                    {
                        fileOutputStream.write(copyArray.get(i).getBytes());
                        String newline= "\n";
                        fileOutputStream.write(newline.getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


                startActivity(intent);
            }
        });

    }

}



