package com.jazz.hellotabwidget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class HelloTabWidgetActivity extends TabActivity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, PortfolioActivity.class);
        spec = tabHost.newTabSpec("Portfolio").setIndicator("Portfolio Total",
                          res.getDrawable(R.drawable.ic_tab_pound))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, SharesActivity.class);
        spec = tabHost.newTabSpec("Shares").setIndicator("Shares",
                          res.getDrawable(R.drawable.ic_tab_graph))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, SharesRun.class);
        spec = tabHost.newTabSpec("Run of Shares").setIndicator("Run of Shares",
                res.getDrawable(R.drawable.ic_tab_run))
            .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, RocketPlummet.class);
        spec = tabHost.newTabSpec("Rocket/Plumet").setIndicator("Rocket/Plumet",
                res.getDrawable(R.drawable.ic_tab_rise))
            .setContent(intent);
        tabHost.addTab(spec);
       
        
        tabHost.setCurrentTab(4);
    }
}