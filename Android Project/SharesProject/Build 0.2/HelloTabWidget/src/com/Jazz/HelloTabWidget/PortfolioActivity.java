package com.Jazz.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PortfolioActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Let's display the progress in the activity title bar, like the
        // browser app does.
        WebView webview = new WebView(this);
        
        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        webview.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webview.setWebChromeClient(new WebChromeClient() {
          public void onProgressChanged(WebView view, int progress) {
            // Activities and WebViews measure progress with different scales.
            // The progress meter will automatically disappear when we reach 100%
            activity.setProgress(progress * 1000);
          }
        });
        webview.setWebViewClient(new WebViewClient() {
          public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, "Please Check Connection " + description, Toast.LENGTH_SHORT).show();
          }
        });

        webview.loadUrl("http://google.com/");
        //TextView textview = new TextView(this);
        //textview.setText("This will Display Portfolio Shares");
        setContentView(webview);
      
}
}