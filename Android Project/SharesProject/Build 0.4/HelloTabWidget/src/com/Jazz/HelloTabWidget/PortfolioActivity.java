package com.Jazz.HelloTabWidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PortfolioActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   
        float mbpShare = 0;
        float mMksShare =0;
        float mSnShare=0;
        float mExShare=0;
        float mHsbcShare=0;
        float totalPort=0;
        
      //BP Amoco PLC UNITS: 192
        String bpcode = "LON:BP";

        //Marks and Spencer Ordinary UNITS: 485
        String mkscode = "LON:MKS";
        //Smith & Nephew PLC UNITS: 1219
        String sncode = "LON:SN";
        //Experian ordinary UNITS: 258
        String excode = "PINK:EXPGF";
        //HSBC Holding PLC UNITS: 343
        String hbccode = "NYSE:HBC";
        URL con;

        TextView textview = new TextView(this);
        textview.append("Portfolio Total calculated at current share prices: \n\n");
        try
        {
	        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + bpcode);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));       
	        String line = "";
	        int i = 0;
	        
	        while(i <7)
	        {
	        	line = in.readLine();
	        	i++;
	        }
	        String bpShare= line;
	
	        String re1=".*?";	// Non-greedy match on filler
	        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
	
	        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	        Matcher m = p.matcher(bpShare);
	        if (m.find())
	        {
	            String float1=m.group(1);
	            textview.append("BP Amoco PLC: "+float1.toString()+""+"\n");
	        	mbpShare = Float.valueOf(float1.trim()).floatValue();
	        }
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No connection to the shares database available.  Please try again.");
	        e.printStackTrace();
        }
        try
        {
	        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + mkscode);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));
	        String line = "";
	        int i = 0;
	        
	        while(i <7)
	        {
		        line = in.readLine();
		        i++;
	        }
	   
	        String mksShare= line;
	
	        String re1=".*?";	// Non-greedy match on filler
	        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
	
	        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	        Matcher m = p.matcher(mksShare);
	        if (m.find())
	        {
	            String float2=m.group(1);
	            textview.append("Marks and Spencer Ordinary: "+float2.toString()+""+"\n");
	            mMksShare = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No connection to the shares database available.  Please try again.");
	        e.printStackTrace();
        }
        try
        {
		        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + sncode);       
		        BufferedReader in = new BufferedReader(
		        new InputStreamReader(
		
		        con.openStream()));
		        String line = "";
		        int i = 0;
		        
		        while(i <7)
		        {
			        line = in.readLine();
			        i++;
		        }
		        String snShare= line;
		        
		        String re1=".*?";	// Non-greedy match on filler
		        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
		
		        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		        Matcher m = p.matcher(snShare);
		        if (m.find())
		        {
		            String float3=m.group(1);
		            textview.append("Smith & Nephew Plc: "+float3.toString()+""+"\n");
		            mSnShare = Float.valueOf(float3.trim()).floatValue();
		
		        }                                             
		        setContentView(textview);
		        in.close();
	        }
        catch (Exception e)
        {
		       textview.setText("Error: No connection to the shares database available.  Please try again.");
		       e.printStackTrace();
		}
	    try
	    {
	        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + excode);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));
	        String line = "";
	        int i = 0;
	        
	        while(i <7)
	        {
		        line = in.readLine();
		        i++;
	        }
	        String exShare= line;
	
	        String re1=".*?";	// Non-greedy match on filler
	        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
	
	        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	        Matcher m = p.matcher(exShare);
	        if (m.find())
	        {
	            String float4=m.group(1);
	            textview.append("Experian Ordinary: "+float4.toString()+""+"\n");
	            mExShare = Float.valueOf(float4.trim()).floatValue();
	        }                               
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No connection to the shares database available.  Please try again.");
	        e.printStackTrace();
        }
        try
        {
	        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + hbccode);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	        		
	        con.openStream()));
	        String line = "";
	        int i = 0;
	
	        while(i <7)
	        {
		        line = in.readLine();
		        i++;
	        }
	
	        String hsbcShare= line;
	        String re1=".*?";	// Non-greedy match on filler
	        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
	
	        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	        Matcher m = p.matcher(hsbcShare);
	        if (m.find())
	        {
	            String float5=m.group(1);
	            textview.append("HSBC Holdings: "+float5.toString()+""+"\n");
	            mHsbcShare = Float.valueOf(float5.trim()).floatValue();
	        }
	        
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
        	textview.setText("Error: No connection to the shares database available.  Please try again.");
        	e.printStackTrace();
        } 
        //
        totalPort = mbpShare*192;
        totalPort = totalPort+(mSnShare*1219);	
        totalPort = totalPort+(mHsbcShare*343);
        totalPort = totalPort+(mMksShare*485);
        totalPort = totalPort+(mExShare*258);
        
        totalPort = (totalPort/100);
        double newTotal = Math.round(totalPort*100.0)/100.0;
        
        textview.append("\n\nTotal Portfolio Value: £"+newTotal);
	}
}
//        String[] mCode={"BP","SN","MKS","PINK:EXPGF","NYSE:HBC"};
//        
//        
//       	  URL con;
//       	  TextView textview = new TextView(this);
//       	  
//       	  for(int j = 0; j<5; j++){
//		try {
//			con = new URL("http://finance.google.com/finance/info?client=ig&q=" + mCode[j]); //url for shares
//			BufferedReader in = new BufferedReader( //open new buffered reader
//	       	        new InputStreamReader(
//	       	        con.openStream()));
//
//	       	  String line = ""; //blank line for reader
//	       	  int i = 0; //control
//	       	  
//	       	  while(i <7){
//	       		  line = in.readLine();
//	       		  i++;
//	       	  }
//	    
//	       	  String share = line.substring(8, 14);
//	       	  
//	       	 try{ //try catch block
//	       		 
//	       	double mShare = Float.valueOf(share.trim()).floatValue();
//	       	textview.append("This Share is worth: "+ mShare+"\n");
//	     
//	       	  }
//	       	  catch (Exception e){
//	       		textview.setText("Error: No Connection. Please Try Again");
//				e.printStackTrace();
//	       	  
//	       	  }
//	       	 
//	       	  
//
//	       	  in.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			textview.setText("Error: No Connection. Please Try Again");
//			e.printStackTrace();
//		}
//       	  
//       	    }
//       	  setContentView(textview);
//
//	}
       	
       	
       	
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
      

