package com.jazz.hellotabwidget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
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
        float BpRocket=0;
        float HsbcRocket=0;
        float ExRocket=0;
        float MksRocket=0;
        float SnRocket=0;
        float BRocket=0;

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
	        
	        while(i <13)
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
	        	BpRocket = Float.valueOf(float1.trim()).floatValue();
	        }
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No BP share value available. Please try again.\n");
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
	        
	        while(i <13)
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
	            MksRocket = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error:  No MKS share value available. Please try again.\n");
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
		        
		        while(i <13)
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
		            SnRocket = Float.valueOf(float3.trim()).floatValue();
		
		        }                                             
		        setContentView(textview);
		        in.close();
	        }
        catch (Exception e)
        {
		       textview.setText("Error: No Smith & Nephew share value available. Please try again.\n");
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
	        
	        while(i <13)
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
	            ExRocket = Float.valueOf(float4.trim()).floatValue();
	        }                               
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error: No Experian share value available. Please try again.\n");
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
	
	        while(i <13)
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
	            HsbcRocket = Float.valueOf(float5.trim()).floatValue();
	        }
	        
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
        	textview.setText("Error: No HSBC share value available. Please try again.\n");
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
	        
	        while(i <13)
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
	            MksRocket = Float.valueOf(float2.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error:  No MKS share value available. Please try again.\n");
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
	        
	        while(i <13)
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
	            BRocket = Float.valueOf(float6.trim()).floatValue();
	
	        }                                    
	        setContentView(textview);
	        in.close();
        }
        catch (Exception e)
        {
	        textview.setText("Error:  No Bowleven share value available. Please try again.\n");
	        e.printStackTrace();
        }
        
        //displays shares value
        
        DecimalFormat newFormat = new DecimalFormat("##.#");
        
        //TEST DATA
        //BRocket = 9.9f;
        //MksRocket = 28.8f;
        //SnRocket = -20.0f;
        
        int rocket = 10;
        int plummet = -20;
        boolean RocketPlummet =false;
        if(BRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Bowleven PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(BRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(BRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Bowleven PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(BRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(BpRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - BP Amoco</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(BpRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(BpRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - BP Amoco</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(BpRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(ExRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Experian Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(ExRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(ExRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Experian Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(ExRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(HsbcRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - HSBC Holdings</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(HsbcRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(HsbcRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - HSBC Holdings</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(HsbcRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(MksRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Marks & Spencer Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(MksRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(MksRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Marks & Spencer Ord.</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(MksRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(SnRocket >= rocket)
        {
        	textview.append(Html.fromHtml(("<big><font color='green'><b><i>ROCKET - Smith and Nephew PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have risen by "+Float.valueOf(newFormat.format(SnRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(SnRocket <= plummet)
        {
        	textview.append(Html.fromHtml(("<big><font color='red'><b><i>PLUMMET - Smith and Nephew PLC</i></b></font></big>")));
        	textview.append(("\nThe shares have dropped by "+Float.valueOf(newFormat.format(SnRocket))+"%\n\n"));
        	RocketPlummet =true;
        }
        if(RocketPlummet == false)
        {
        	textview.append(Html.fromHtml(("<big><font color='#FFA500'><b><i>NO SHARES HAVE ROCKETED OR PLUMMETED</i></b></font></big>")));
        }
        
    }
}