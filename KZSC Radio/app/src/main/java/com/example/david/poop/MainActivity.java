//package com.example.david.poop;
//
//import android.content.Intent;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.NavigationView;
//import android.app.Fragment;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//
//import java.io.IOException;
//
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//
//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;
//    MediaPlayer mediaPlayer = new MediaPlayer();
//
//    @Nullable
//    @Override
//    public ActionBar getSupportActionBar() {
//        return super.getSupportActionBar();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setNavigationListener();
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.logopic);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
////        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
////        bottomNav.setOnNavigationItemSelectedListener(navListner);
//
//        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new HomeFragment()).commit();
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        final String AudioURL = "http://188.165.192.5:8242/kzschigh?type=.mp3";
//
//        //Preparing audio
//        try {
//            mediaPlayer.setDataSource(AudioURL);
//            mediaPlayer.prepareAsync();
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch(RuntimeException e) {
//            e.printStackTrace();
//        }
//
//        //play code
//        final FloatingActionButton play = (FloatingActionButton) findViewById(R.id.playButton);
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();
//                    play.setImageResource(R.drawable.ic_play_arrow_white_24dp);
//                }else{
//                    mediaPlayer.start();
//                    play.setImageResource(R.drawable.ic_pause_white_24dp);
//                }
//            }
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(mToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment selectedFragment = null;
//        switch(item.getItemId()) {
//            case R.id.home:
//                Log.d("home", "nav_home");
//                selectedFragment = new HomeFragment();
//                break;
//            case R.id.chat:
//                Log.d("chat", "nav_chat");
//                selectedFragment = new LoginFragment();
//                break;
//            case R.id.schedule:
//                Log.d("sched", "nav_schedule");
//                selectedFragment = new ScheduleFragment();
//                break;
//            case R.id.about:
//                Log.d("about", "nav_about");
//                selectedFragment = new AboutFragment();
//                break;
//            case R.id.donate:
//                Log.d("donate", "nav_donate");
//                selectedFragment = new DonateFragment();
//                break;
//        }
//        getFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//        mDrawerLayout.closeDrawers();
//        return false;
//    }
//
//    private void setNavigationListener(){
//        NavigationView navigationView = (NavigationView) findViewById(R.id.drop);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//}

package com.example.david.poop;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logopic);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigationListener();
//        setTitle("KZSC App");

//        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String AudioURL = "http://188.165.192.5:8242/kzschigh?type=.mp3";

        //Preparing audio
        try {
            mediaPlayer.setDataSource(AudioURL);
            mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(RuntimeException e) {
            e.printStackTrace();
        }

        //play code
        final FloatingActionButton play = (FloatingActionButton) findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                }else{
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_pause_white_24dp);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch(item.getItemId()) {
            case R.id.home:
                Log.d("home", "nav_home");
                selectedFragment = new HomeFragment();
                break;
            case R.id.chat:
                Log.d("chat", "nav_chat");
                selectedFragment = new LoginFragment();
                break;
            case R.id.schedule:
                Log.d("sched", "nav_schedule");
                selectedFragment = new ScheduleFragment();
                break;
            case R.id.about:
                Log.d("about", "nav_about");
                selectedFragment = new AboutFragment();
                break;
            case R.id.donate:
                Log.d("donate", "nav_donate");
                selectedFragment = new DonateFragment();
                break;
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        mDrawerLayout.closeDrawers();
        return false;
    }

    private void setNavigationListener(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.drop);
        navigationView.setNavigationItemSelectedListener(this);
    }

}