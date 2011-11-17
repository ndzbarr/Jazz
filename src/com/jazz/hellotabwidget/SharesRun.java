package com.jazz.hellotabwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import android.widget.TextView;

public class SharesRun extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		TextView textview = new TextView(this);
		setContentView(textview);
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
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
        textview.append(Html.fromHtml(("<b><h1>RUN OF SHARES</h1></b><br>")));
        try
=======
        
        String[] shareCodeArray;
        shareCodeArray = new String[6];
        shareCodeArray[0] ="bp";
        shareCodeArray[1] ="expn";
        shareCodeArray[2] ="hsba";
        shareCodeArray[3] ="mks";
        shareCodeArray[4] ="sn";
        shareCodeArray[5] ="blvn";
        
        boolean noSharesOnRun = true;
        
        
   
        try 
>>>>>>> cc5be3a51c022ccab00e3f14cf555bd6a477ce36
        {
        	setContentView(textview);
        	
        	String previousVolume = GetPreviousBPVolume(shareCodeArray[0]);
        	String currentVolume = GetCurrentBPVolume(shareCodeArray[0]);
        	String runPercent = GetRunPercent(previousVolume, currentVolume);
			
			
			if(DisplayRun(runPercent)==true)
			{
				textview.append(FormatData(shareCodeArray[0])+"\n");
				noSharesOnRun = false;
			}
			
        }
		
        catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append("Connection Error! : Please Try Again");
		}
     
       
	
    try 
    {
    	setContentView(textview);
    	
    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[1]);
    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[1]);
    	String runPercent = GetRunPercent(previousVolume, currentVolume);
		
		
		if(DisplayRun(runPercent)==true)
		{
			textview.append(FormatData(shareCodeArray[1])+"\n");
			noSharesOnRun = false;
		}
		
    }
	
    catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		textview.append("Connection Error! : Please Try Again");
	}
 
   
	
	   try 
	    {
	    	setContentView(textview);
	    	
	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[2]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[2]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);
			
			
			if(DisplayRun(runPercent)==true)
			{
				textview.append(FormatData(shareCodeArray[2])+"\n");
				noSharesOnRun = false;
			}
			
	    }
		
	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append("Connection Error! : Please Try Again");
		}
	   try 
	    {
	    	setContentView(textview);
	    	
	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[3]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[3]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);
			
			
			if(DisplayRun(runPercent)==true)
			{
				textview.append(FormatData(shareCodeArray[3])+"\n");
				noSharesOnRun = false;
			}
			
	    }
		
	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append("Connection Error! : Please Try Again");
		}
	   try 
	    {
	    	setContentView(textview);
	    	
	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[4]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[4]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);
			
			
			if(DisplayRun(runPercent)==true)
			{
				textview.append(FormatData(shareCodeArray[4])+"\n");
				noSharesOnRun = false;
			}
			
	    }
		
	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append("Connection Error! : Please Try Again");
		}
	   try 
	    {
	    	setContentView(textview);
	    	
	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[5]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[5]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);
			
			
			if(DisplayRun(runPercent)==true)
			{
				textview.append(FormatData(shareCodeArray[5])+"\n");
				noSharesOnRun = false;
			}
			
	    }
		
	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append("Connection Error! : Please Try Again");
		}
	   
	   if(noSharesOnRun == true) 
		   textview.append("No Shares are on a run!");
	   }

	public String GetPreviousBPVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));       
	        String line = "";
	        int i = 0;
	        
	        while(i <364)
	        {
	        	line = in.readLine();
	        	i++;
	        }
	        
	       
	        StringBuffer s = new StringBuffer(line);
	        StringBuffer AfterRemoval=s.delete(0,82);
	        line = AfterRemoval.toString();
	        
	        
	
	        line = line.split("<")[0];
	        String tmpString = line.replace(",","");
	        line = tmpString;
	        
	       
	           
		return line;
	}
	
<<<<<<< HEAD
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
=======
	public String GetCurrentBPVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
>>>>>>> cc5be3a51c022ccab00e3f14cf555bd6a477ce36
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));       
	        String line = "";
	        int i = 0;
	        
	        while(i <263)
	        {
	        	line = in.readLine();
	        	i++;
	        }
<<<<<<< HEAD
	   
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
=======
	        
	        
	        StringBuffer s = new StringBuffer(line);
	        StringBuffer AfterRemoval=s.delete(0,46);
	        line = AfterRemoval.toString();
	        
	        
	       line = line.split("<")[0];
	       String tmpString = line.replace(",","");
	       line = tmpString;
	        
	        return line;
>>>>>>> cc5be3a51c022ccab00e3f14cf555bd6a477ce36
		
	}
	public String GetPreviousGenericVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));       
	        String line = "";
	        int i = 0;
	        
	        while(i <362)
	        {
	        	line = in.readLine();
	        	i++;
	        }
	        
	       
	        StringBuffer s = new StringBuffer(line);
	        StringBuffer AfterRemoval=s.delete(0,82);
	        line = AfterRemoval.toString();
	        
	        
	
	        line = line.split("<")[0];
	        String tmpString = line.replace(",","");
	        line = tmpString;
	        
	       
	           
		return line;
	}
	
<<<<<<< HEAD
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
=======
	
	
	public String GetCurrentGenericVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
>>>>>>> cc5be3a51c022ccab00e3f14cf555bd6a477ce36
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	
	        con.openStream()));       
	        String line = "";
	        int i = 0;
	        
	        while(i <261)
	        {
	        	line = in.readLine();
	        	i++;
	        }
	        
	        
	        StringBuffer s = new StringBuffer(line);
	        StringBuffer AfterRemoval=s.delete(0,46);
	        line = AfterRemoval.toString();
	        
	        
	       line = line.split("<")[0];
	       String tmpString = line.replace(",","");
	       line = tmpString;
	        
	        return line;
		
	}
	
	
<<<<<<< HEAD
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
        float mbpTotal=((mbpShare*192)/100);
        float mHsbcTotal=((mHsbcShare*343)/100);
        float mExTotal=((mExShare*258)/100);
        float mMksTotal=((mMksShare*485)/100);
        float mSnTotal=((mSnShare*1219)/100);
        float mBTotal=((mBShare*3960)/100);
        //Rounds total to 2 decimal places
        double newBpTotal = Math.round(mbpTotal*100)/100;
        double newHsbcTotal = Math.round(mHsbcTotal*100)/100;
        double newExTotal = Math.round(mExTotal*100)/100;
        double newMksTotal = Math.round(mMksTotal*100)/100;
        double newSnTotal = Math.round(mSnTotal*100)/100;
        double newBTotal = Math.round(mBTotal*100)/100;
        //displays shares value
        textview.append(Html.fromHtml(("<b><i>BP Amoco</i></b><br>192 shares at ")));
        textview.append(mbpShare+("\nTotal:                                          £"+(int)newBpTotal+"\n"));
        textview.append(Html.fromHtml(("<b><i>Experian Ord.</i></b><br>258 shares at ")));
        textview.append(mExShare+("\nTotal:                                          £"+(int)newExTotal+"\n"));
        textview.append(Html.fromHtml(("<b><i>HSBC Holdings</i></b><br>343 shares at ")));
        textview.append(mHsbcShare+("\nTotal:                                          £"+(int)newHsbcTotal+"\n"));
        textview.append(Html.fromHtml(("<b><i>Marks & Spencer Ord.</i></b><br>485 shares at ")));
        textview.append(mMksShare+("\nTotal:                                          £"+(int)newMksTotal+"\n"));
        textview.append(Html.fromHtml(("<b><i>Smith and Nephew PLC</i></b><br>1219 shares at ")));
        textview.append(mSnShare+("\nTotal:                                          £"+(int)newSnTotal+"\n"));
        textview.append(Html.fromHtml(("<b><i>Bowleven PLC</i></b><br>3960 shares at ")));
        textview.append(mBShare+("\nTotal:                                          £"+(int)newBTotal+"\n"));        
=======
	public String GetRunPercent(String preVol, String CurVol)
	{
		double percent;
		double previousVol;
		double currentVol;
		String Answer;
		try
		{
			previousVol = Double.parseDouble(preVol);
		}
		catch(NumberFormatException nfe)
		{
			String error;
			   error = ("Error With Data!: " + nfe);
			   return error;
		} 
		
		try
		{
		currentVol = Double.parseDouble(CurVol);
		}
		catch(NumberFormatException nfe)
		{
			String error;
			   error = ("Error With Data!: " + nfe);
			   return error;
		} 
		
		percent = ((currentVol/previousVol)*100);
		
		Answer  = Double.toString(percent);
		
		return Answer;
	}
	
    public boolean DisplayRun(String runPercent)
    {
    	boolean isDisplayed = false;
    	double percentValue;
    	
		percentValue = Double.parseDouble(runPercent);
		
		if (percentValue >= 125)
			isDisplayed = true;
	
    	return isDisplayed;
    }
    
    
    public String FormatData(String code)
    {
    	if (code == "bp")   //code swaps, to ease readabilty 
    		code = "Bp Amoco shares";
    	
    	if (code =="expn")
    		code ="Experian Ordinary shares";
    	
    	if (code =="hsba")
    		code ="HSBC Holdings shares";
    	
    	if(code=="mks")
    		code = "Marks and Spencer Ordinary shares";
    	
    	if(code=="sn")
    		code = "Smith and Nephew shares";
    	
    	if(code=="blvn")
    		code = "Bowleven Shares";
    		
    	
    	
    	
    	String dataString = code + " are on a run\n";
    	
    	
    	return dataString;
>>>>>>> cc5be3a51c022ccab00e3f14cf555bd6a477ce36
    }
}

