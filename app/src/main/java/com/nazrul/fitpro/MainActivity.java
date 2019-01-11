package com.nazrul.fitpro;

/**Title: Fitapp
 * Author: Md. Nazrul Islam
 *
 */


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*

        //Don't worry sweat Snackbar. I will deal with you later. Okay?

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        */

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if(savedInstanceState == null){
            setTitle(R.string.nav_bmi_Title);
            MBIFragment bmi = new MBIFragment();
            FragmentTransaction bmi_transaction = getSupportFragmentManager().beginTransaction();
            bmi_transaction.replace(R.id.content_main, bmi);
            bmi_transaction.commit();
        }

    }


    //When the drawer is open, if back button is pressed; close the drawer. Else, leave quietly.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //If exit selected finish the activity
        if (id == R.id.Exit) {
            finish();
            return true;
        }
        //If share selected open sharing intent
        else if(id == R.id.Share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("*/*");
            startActivity(Intent.createChooser(sharingIntent, "শেয়ার করুন"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Handle navigation view item clicks here.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_bmi) {
            setTitle(R.string.nav_bmi_Title);
            MBIFragment bmi = new MBIFragment();
            FragmentTransaction bmi_transaction = getSupportFragmentManager().beginTransaction();
            bmi_transaction.replace(R.id.content_main, bmi);
            bmi_transaction.commit();

        } else if (id == R.id.nav_bmr) {
            setTitle(R.string.nav_bmr_Title);
            BMRFragment bmr = new BMRFragment();
            FragmentTransaction bmr_transaction = getSupportFragmentManager().beginTransaction();
            bmr_transaction.replace(R.id.content_main, bmr);
            bmr_transaction.commit();

        } else if (id == R.id.nav_alldayCalorie) {
            setTitle(R.string.nav_alldayCalorie_Title);
            TotalCalAllDayFragment alldaycal = new TotalCalAllDayFragment();
            FragmentTransaction alldaycal_transaction = getSupportFragmentManager().beginTransaction();
            alldaycal_transaction.replace(R.id.content_main, alldaycal);
            alldaycal_transaction.commit();


        } else if (id == R.id.nav_suggestion) {
            setTitle(R.string.nav_suggestion_Title);
            GetSuggestionFragment sugges = new GetSuggestionFragment();
            FragmentTransaction sugges_transaction = getSupportFragmentManager().beginTransaction();
            sugges_transaction.replace(R.id.content_main, sugges);
            sugges_transaction.commit();

        }
        else if(id == R.id.nav_fitapp){
            setTitle(R.string.nav_fitapp);
            FitappFragment fitapp = new FitappFragment();
            FragmentTransaction fitapp_transaction = getSupportFragmentManager().beginTransaction();
            fitapp_transaction.replace(R.id.content_main, fitapp);
            fitapp_transaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
