package com.Jazz.HelloTabWidget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TabHost;

public class HelloTabWidgetActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, PortfolioActivity.class);
        spec = tabHost.newTabSpec("portfolio").setIndicator("Portfolio Total",
                          res.getDrawable(R.drawable.ic_tab_pound))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, SharesActivity.class);
        spec = tabHost.newTabSpec("Shares").setIndicator("Shares",
                          res.getDrawable(R.drawable.oc_tab_graph))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}