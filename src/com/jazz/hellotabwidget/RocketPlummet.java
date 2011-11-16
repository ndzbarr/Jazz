package com.jazz.hellotabwidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class RocketPlummet extends Activity 
{
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        float mbpShare = 0;
        float mMksShare =0;
        float mSnShare=0;
        float mExShare=0;
        float mHsbcShare=0;
        float mBShare=0;
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
        //Boleven PLC PLC UNITS: 3960
        String bplccode = "LON:BLVN";
        URL con;

        TextView textview = new TextView(this);
        textview.append(Html.fromHtml(("<b><h1>ROCKET OR PLUMMET</h1></b><br>")));
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
	        con = new URL("http://finance.google.com/finance/info?client=ig&q=" + bplccode);
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
	   
	        String bShare= line;
	
	        String re1=".*?";	// Non-greedy match on filler
	        String re2="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
	
	        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	        Matcher m = p.matcher(bShare);
	        if (m.find())
	        {
	            String float6=m.group(1);
	            mBShare = Float.valueOf(float6.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error:  No Bowleven share value not available.  Please try again.\n");
	        e.printStackTrace();
        }
        
        
        //calculate shares total and divide by 100(to the pound)
        float mbpTotal=5;//((mbpShare*192)/100);
        float mHsbcTotal=50;//((mHsbcShare*343)/100);
        float mExTotal=50;//((mExShare*258)/100);
        float mMksTotal=50;//((mMksShare*485)/100);
        float mSnTotal=50;//((mSnShare*1219)/100);
        float mBTotal=50;//((mBShare*3960)/100);
        //displays shares value
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - BP Amoco</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mbpTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - BP Amoco</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mbpTotal+"%\n"));
        }
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - HSBC Holdings</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mHsbcTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - HSBC Holdings</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mHsbcTotal+"%\n"));
        }
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Experian Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mExTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Experian Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mExTotal+"%\n"));
        }
        
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Marks & Spencer Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mMksTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Marks & Spencer Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mMksTotal+"%\n"));
        }
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Smith and Nephew PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mSnTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Smith and Nephew PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mSnTotal+"%\n"));
        }
        
        if(mbpTotal == 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Bowleven PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+(int)mBTotal+"%\n"));
        }
        if(mbpTotal < 50)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Bowleven PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+(int)mBTotal+"%\n"));
        }
        
    }
}