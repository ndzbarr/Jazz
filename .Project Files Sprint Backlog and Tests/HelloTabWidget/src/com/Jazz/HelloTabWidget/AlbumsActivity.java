package com.Jazz.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AlbumsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("Neill Barr loves to moan");
        setContentView(textview);
    }
}