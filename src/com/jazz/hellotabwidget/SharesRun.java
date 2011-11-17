package com.jazz.hellotabwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;


import android.widget.TextView;

public class SharesRun extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		TextView textview = new TextView(this);
		setContentView(textview);
        super.onCreate(savedInstanceState);
        
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

	public String GetCurrentBPVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
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


	        StringBuffer s = new StringBuffer(line);
	        StringBuffer AfterRemoval=s.delete(0,46);
	        line = AfterRemoval.toString();


	       line = line.split("<")[0];
	       String tmpString = line.replace(",","");
	       line = tmpString;

	        return line;

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



	public String GetCurrentGenericVolume(String code) throws IOException
	{
		URL con;
		 con = new URL("http://shareprices.com/lse/"+code);
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
    }
}


