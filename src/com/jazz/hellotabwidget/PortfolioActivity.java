package com.jazz.hellotabwidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class PortfolioActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
   
        float mbpShare = 0;
        float mMksShare =0;
        float mSnShare=0;
        float mExShare=0;
        float mHsbcShare=0;
        float totalPort=0;
        Log.v("jazz", "Something");
        
        //BP Amoco PLC UNITS: 192
        String bpcode = "LON:BP";
        //Marks and Spencer Ordinary UNITS: 485
        String mkscode = "LON:MKS";
        //Smith & Nephew PLC UNITS: 1219
        String sncode = "LON:SN";
        //Experian ordinary UNITS: 258
        String excode = "LON:EXPN";
        //HSBC Holding PLC UNITS: 343
        String hbccode = "LON:HSBA";
        //Boleven PLC PLC UNITS: 
        String bplccode = "LON:BLVN";
        
        URL con;

        TextView textview = new TextView(this);
        textview.append(Html.fromHtml(("<h1><b>PORTFOLIO TOTAL VALUE</h1></b><br>")));
        //BP AMOCO
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
	            textview.append(Html.fromHtml(("<b><i>BP Amoco</i></b><br>")));
	            textview.append(float1.toString()+""+"\n");
	        	mbpShare = Float.valueOf(float1.trim()).floatValue();
	        }
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("\nError: No connection to the BP share value available.  Please try again.\n");
	        e.printStackTrace();
        }
        //EXPERIAN
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
	            textview.append(Html.fromHtml(("<b><i>Experian Ord.</i></b><br>")));
	            textview.append(float4.toString()+""+"\n");
	            mExShare = Float.valueOf(float4.trim()).floatValue();
	        }                               
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("\nError: No connection to the Experian Share value available.  Please try again.\n");
	        e.printStackTrace();
        }
	    //HSBC
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
	            textview.append(Html.fromHtml(("<b><i>HSBC Holdings</i></b><br>")));
	            textview.append(float5.toString()+""+"\n");
	            mHsbcShare = Float.valueOf(float5.trim()).floatValue();
	        }
	        
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
        	textview.setText("\nError: No connection to the HSBC Share value available.  Please try again.\n");
        	e.printStackTrace();
        } 
        //MARKS AND SPENCER
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
	            textview.append(Html.fromHtml(("<b><i>Marks and Spencer Ord.</i></b><br>")));
	            textview.append(float2.toString()+""+"\n");
	            mMksShare = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("\nError: No connection to the MKS share value available.  Please try again.\n");
	        e.printStackTrace();
        }
        // SMITH AND NEPHEW
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
		            textview.append(Html.fromHtml(("<b><i>Smith & Nephew PLC</i></b><br>")));
		            textview.append(float3.toString()+""+"\n");
		            mSnShare = Float.valueOf(float3.trim()).floatValue();
		
		        }                                             
		        setContentView(textview);
		        in.close();
	        }
        catch (Exception e)
        {
		       textview.setText("\nError: No connection to the SN value available.  Please try again.\n");
		       e.printStackTrace();
		}
        //
        totalPort = mbpShare*192;
        totalPort = totalPort+(mSnShare*1219);	
        totalPort = totalPort+(mHsbcShare*343);
        totalPort = totalPort+(mMksShare*485);
        totalPort = totalPort+(mExShare*258);
        
        totalPort = (totalPort/100);
        double newTotal = Math.round(totalPort*100)/100;
    
        textview.append(Html.fromHtml("<br><br><h1>Total Portfolio: <b>£ </b>"+"<b>"+(int)newTotal+"</b></h1>"));
	}
}