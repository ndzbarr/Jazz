package com.Jazz.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PortfolioActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This will Display the Total Portfolio");
        setContentView(textview);
    }
}
