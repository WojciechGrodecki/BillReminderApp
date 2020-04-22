package com.example.myapplication.ui.activity.mainActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.R;
import com.example.myapplication.ui.base.BaseActivity;
import com.example.myapplication.ui.fragments.addBill.AddBillFragment;
import com.example.myapplication.ui.fragments.allBills.AllBillsFragment;
import com.example.myapplication.ui.fragments.billDetails.BillDetailsFragment;
import com.example.myapplication.ui.fragments.billPaid.BillPaidFragment;
import com.example.myapplication.ui.fragments.billUnPaid.BillUnPaidFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mDrawerLayout;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v-> startAdd());

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.all_bill) {
            setFragment(new AllBillsFragment());
        } else if (id == R.id.add_bill) {
            setFragment(new AddBillFragment());
        } else if (id == R.id.bill_details) {
            setFragment(new BillDetailsFragment());
        } else if (id == R.id.bill_paid) {
            setFragment(new BillPaidFragment());
        } else if (id == R.id.bill_unpaid) {
            setFragment(new BillUnPaidFragment());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContainer, fragment)
                .commit();
    }

    private void startAdd(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, new AddBillFragment())
                .addToBackStack(null)
                .commit();
    }

}
