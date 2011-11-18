package com.Jazz.HelloTabWidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PortfolioActivity extends Activity {


	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Let's display the progress in the activity title bar, like the
        // browser app does.
       	 String code;
       	 code = "BP";
       	  URL con;
       	  TextView textview = new TextView(this);
		try {
			con = new URL("http://finance.google.com/finance/info?client=ig&q=" + code);
			BufferedReader in = new BufferedReader(
	       	        new InputStreamReader(
	       	        con.openStream()));

	       	  String inputLine;
	       	  int i = 0;
	       	  
	       	  while(i <7){
	       		  inputLine = in.readLine();
	       		  textview.setText(inputLine);
	       		  i++;
	       	  }
	       	 // while ((inputLine = in.readLine()) != null)
	       	 //System.out.println(inputLine);
	       	  
	       	  setContentView(textview);

	       	  in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	  
       	    }
       	
       
       	
       	
       	
//       	
//		try {
//			url = new URL("http://finance.google.com/finance/info?client=ig&q=" + code);
//			con = url.openConnection();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		BufferedReader reader = new BufferedReader(new InputStreamReader(con);

        
        
     
          
        //The following commented lines test a connection to the internet and ensure it follows the main.xml layount.
         
        //WebView webview = new WebView(this);
        
        //getWindow().requestFeature(Window.FEATURE_PROGRESS);

       // webview.getSettings().setJavaScriptEnabled(true);

        //final Activity activity = this;
        //webview.setWebChromeClient(new WebChromeClient() {
          //public void onProgressChanged(WebView view, int progress) {
            // Activities and WebViews measure progress with different scales.
            // The progress meter will automatically disappear when we reach 100%
            //activity.setProgress(progress * 1000);
          //}
       // });
        //webview.setWebViewClient(new WebViewClient() {
          //public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            //Toast.makeText(activity, "Please Check Connection " + description, Toast.LENGTH_SHORT).show();
         // }
       // });

        //webview.loadUrl("http://google.com/");
        //TextView textview = new TextView(this);
        //textview.setText("This will Display Portfolio Shares");
        //setContentView(webview);
      
}
