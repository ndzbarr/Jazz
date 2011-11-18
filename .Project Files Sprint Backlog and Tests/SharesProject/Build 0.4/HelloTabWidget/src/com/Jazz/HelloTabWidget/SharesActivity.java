package com.Jazz.HelloTabWidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
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
        String excode = "PINK:EXPGF";
        //HSBC Holding PLC UNITS: 343
        String hbccode = "NYSE:HBC";
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
	           // textview.append("Marks and Spencer Ordinary: "+float2.toString()+""+"\n");
	            mMksShare = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: Could Not Get Share.  Please try again.");
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
	            //textview.append("Experian Ordinary: "+float4.toString()+""+"\n");
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
	           // textview.append("HSBC Holdings: "+float5.toString()+""+"\n");
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
        
        //calculate shares total and divide by 100(to the pound)
        float mbpTotal=((mbpShare*192)/100);
        float mHsbcTotal=((mHsbcShare*343)/100);
        float mExTotal=((mExShare*258)/100);
        float mMksTotal=((mMksShare*485)/100);
        float mSnTotal=((mSnShare*1219)/100);
        
        //Rounds total to 2 decimal places
        double newBpTotal = Math.round(mbpTotal*100.0)/100.0;
        double newHsbcTotal = Math.round(mHsbcTotal*100.0)/100.0;
        double newExTotal = Math.round(mExTotal*100.0)/100.0;
        double newMksTotal = Math.round(mMksTotal*100.0)/100.0;
        double newSnTotal = Math.round(mSnTotal*100.0)/100.0;
        
        //displays shares value
        textview.append(("192 BP Amoco shares at ")+mbpShare+("\nTotal = £"+newBpTotal+"\n\n"));
        textview.append(("343 HSBC Holdings shares at ")+mHsbcShare+("\nTotal = £"+newHsbcTotal+"\n\n"));
        textview.append(("258 Experian Ord. shares at ")+mExShare+("\nTotal = £"+newExTotal+"\n\n"));
        textview.append(("485 Marks & Spencer Ord. shares at ")+mMksShare+("\nTotal = £"+newMksTotal+"\n\n"));
        textview.append(("1219 Smith and Nephew PLC shares at ")+mSnShare+("\nTotal = £"+newSnTotal+"\n\n"));
        
    }
}

