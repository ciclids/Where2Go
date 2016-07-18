package com.ciclids.where2go.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ciclids.where2go.R;
import com.ciclids.where2go.login.LoginActivity;
import com.ciclids.where2go.main.adapters.MainSectionsPagerAdapter;
import com.ciclids.where2go.placesList.ui.PlacesFragment;
import com.ciclids.where2go.placesMap.PlacesMapFragment;
import com.facebook.login.LoginManager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max on 2016
 */
public class MainActivity extends AppCompatActivity {


    @Bind(R.id.toolbarMain)
    Toolbar toolbarMain;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabs)
    TabLayout tabsLayout;
    Fragment placefrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        placefrag = new PlacesFragment();
        Fragment[] fragments = new Fragment[]{
                placefrag,
                new PlacesMapFragment()};

        String[] titles = new String[]{getString(R.string.main_title_list),
                getString(R.string.main_title_map)};


        setSupportActionBar(toolbarMain);

        MainSectionsPagerAdapter adapter = new MainSectionsPagerAdapter(getSupportFragmentManager(),
                fragments,
                titles);
        viewPager.setAdapter(adapter);
        tabsLayout.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout_icon) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}