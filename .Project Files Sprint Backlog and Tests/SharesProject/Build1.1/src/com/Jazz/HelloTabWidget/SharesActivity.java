package com.Jazz.HelloTabWidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class SharesActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Let's display the progress in the activity title bar, like the
        // browser app does.
        
        //BP Amoco PLC UNITS: 192
        float mbpShare = 0;
        float mMksShare =0;
        float mSnShare=0;
        float mExShare=0;
        float mHsbcShare=0;
        String bpcode = "LON:BP";

        //Marks and Spencer Ordinary UNITS: 485
        String mkscode = "LON:MKS";
        //Smith & Nephew PLC UNITS: 1219
        String sncode = "LON:SN";
        //Experian ordinary UNITS: 258
        String excode = "LON:EXPN";
        //HSBC Holding PLC UNITS: 343
        String hbccode = "LON:HSBA";
        URL con;

        TextView textview = new TextView(this);
        //textview.append("Portfolio Total calculated at current share prices: \n\n");
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
	            //textview.append("BP Amoco PLC: "+float1.toString()+""+"\n");
	        	mbpShare = Float.valueOf(float1.trim()).floatValue();
	        }
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No BP share value not available.  Please try again.\n");
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
	           // textview.append("Marks and Spencer Ordinary: "+float2.toString()+""+"\n");
	            mMksShare = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error:  No MKS share value not available.  Please try again.\n");
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
		           // textview.append("Smith & Nephew Plc: "+float3.toString()+""+"\n");
		            mSnShare = Float.valueOf(float3.trim()).floatValue();
		
		        }                                             
		        setContentView(textview);
		        in.close();
	        }
        catch (Exception e)
        {
		       textview.setText("Error: No Smith & Nephew share value not available.  Please try again.\n");
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
	            //textview.append("Experian Ordinary: "+float4.toString()+""+"\n");
	            mExShare = Float.valueOf(float4.trim()).floatValue();
	        }                               
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No Experian share value not  available.  Please try again.\n");
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
	           // textview.append("HSBC Holdings: "+float5.toString()+""+"\n");
	            mHsbcShare = Float.valueOf(float5.trim()).floatValue();
	        }
	        
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
        	textview.setText("Error: No HSBC share value not available.  Please try again.\n");
        	e.printStackTrace();
        } 
        
        //calculate shares total and divide by 100(to the pound)
        float mbpTotal=((mbpShare*192)/100);
        float mHsbcTotal=((mHsbcShare*343)/100);
        float mExTotal=((mExShare*258)/100);
        float mMksTotal=((mMksShare*485)/100);
        float mSnTotal=((mSnShare*1219)/100);
        
        //Rounds total to 2 decimal places
        double newBpTotal = Math.round(mbpTotal*100)/100;
        double newHsbcTotal = Math.round(mHsbcTotal*100)/100;
        double newExTotal = Math.round(mExTotal*100)/100;
        double newMksTotal = Math.round(mMksTotal*100)/100;
        double newSnTotal = Math.round(mSnTotal*100)/100;
        
        //displays shares value
        textview.append(Html.fromHtml(("<b><h1>INDIVIDUAL SHARES TOTAL</h1></b><br>")));

        textview.append(Html.fromHtml(("<b><i>BP Amoco</i></b><br>192 shares at ")));
        textview.append(mbpShare+("\nTotal:                                          �"+(int)newBpTotal+"\n\n"));
        textview.append(Html.fromHtml(("<b><i>Experian Ord.</i></b><br>258 shares at ")));
        textview.append(mExShare+("\nTotal:                                          �"+(int)newExTotal+"\n\n"));
        textview.append(Html.fromHtml(("<b><i>HSBC Holdings</i></b><br>343 shares at ")));
        textview.append(mHsbcShare+("\nTotal:                                          �"+(int)newHsbcTotal+"\n\n"));
        textview.append(Html.fromHtml(("<b><i>Marks & Spencer Ord.</i></b><br>485 shares at ")));
        textview.append(mMksShare+("\nTotal:                                          �"+(int)newMksTotal+"\n\n"));
        textview.append(Html.fromHtml(("<b><i>Smith and Nephew PLC</i></b><br>1219 shares at ")));
        textview.append(mSnShare+("\nTotal:                                          �"+(int)newSnTotal+"\n\n"));
        
    }
}

