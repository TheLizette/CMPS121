package com.example.lizet.assignment2_121;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddEventPage extends AppCompatActivity {
    private EditText editTitle;
    private EditText editEventDescript;
    private Button button;

    private String pastel = "";
    private LocationManager locationManager;
    private LocationListener locationListener;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_page);
        setTitle("Event Logging");

        editTitle = findViewById(R.id.editTitle);
        editEventDescript = findViewById(R.id.editEventDescript);
        button = findViewById(R.id.button);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //textView.append("\n" + location.getLatitude()+ " " +location.getLongitude());
                //Toast.makeText(AddEventPage.this, location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_LONG).show();
                pastel=location.getLatitude()+ " " +location.getLongitude();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
            }, 10);
            return;
        } else {
            //configureButton();
            locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);

        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
                }
                return;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
            }, 10);
            return;
        }

        Location poopie = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(poopie!=null) {
            locationListener.onLocationChanged(poopie);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(AddEventPage.this, MainActivity.class);
                String x = editTitle.getText().toString();
                String y = editEventDescript.getText().toString();
                Date date = new Date();
                String time = new SimpleDateFormat("hh:mm:ss aa").format(date);
                String date1 = new SimpleDateFormat("MM-dd-yyyy").format(date);
                String gps = pastel;

                JSONObject fileshit = new JSONObject();
                try {
                    fileshit.put("title", x);
                    fileshit.put("description", y);
                    fileshit.put("time",time);
                    fileshit.put("date",date1);
                    fileshit.put("gps", gps);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                File file =null;
                x=x+" ";

                FileOutputStream fileOutputStream= null;
                try {
                    file = getFilesDir();
                    String newline= "\n";
                    fileOutputStream = openFileOutput("vivz.txt", Context.MODE_PRIVATE|MODE_APPEND);
                    fileOutputStream.write(fileshit.toString().getBytes());
                    fileOutputStream.write(newline.getBytes());


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                intent.putExtra("Title input", x);
                intent.putExtra("Description title", y);
                intent.putExtra("time input", time);
                intent.putExtra("date input", date1);
                intent.putExtra("gps input", gps);
                startActivity(intent);
            }

        });

    }
}