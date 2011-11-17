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
        shareCodeArray[5] ="bp";
        shareCodeArray[1] ="expn";
        shareCodeArray[2] ="hsba";
        shareCodeArray[3] ="mks";
        shareCodeArray[4] ="sn";
        shareCodeArray[0] ="blvn";
        
        boolean noSharesOnRun = true;
        textview.append(Html.fromHtml(("<b><h1>RUN OF SHARES</h1></b><br>")));
        
        try 
        {
        	setContentView(textview);
        	
        	String previousVolume = GetPreviousGenericVolume(shareCodeArray[0]);
        	String currentVolume = GetCurrentGenericVolume(shareCodeArray[0]);
        	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>Bowleven PLC - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[0])+"\n");
				noSharesOnRun = false;
			}

        }

        catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on Bowleven PLC!</i></b></font><br>")));
			noSharesOnRun = false;
		}
        
        try 
	    {
	    	setContentView(textview);
	    	
	    	String previousVolume = GetPreviousBPVolume(shareCodeArray[5]);
	    	String currentVolume = GetCurrentBPVolume(shareCodeArray[5]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>BP Amoco - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[5])+"\n");
				noSharesOnRun = false;
			}

	    }

	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on BP Amoco!</i></b></font><br>")));
			noSharesOnRun = false;
		}
     
       try 
	    {
	    	setContentView(textview);

	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[1]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[1]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>HSBC Holdings - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[1])+"\n");
				noSharesOnRun = false;
			}

	    }

	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on HSBC Holdings!</i></b></font><br>")));
			noSharesOnRun = false;
		}
	   try 
	    {
	    	setContentView(textview);

	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[2]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[2]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>Experian Ord. - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[2])+"\n");
				noSharesOnRun = false;
			}

	    }

	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on Experian Ord.!</i></b></font><br>")));
			noSharesOnRun = false;
		}
	   try 
	    {
	    	setContentView(textview);

	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[3]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[3]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>Marks & Spencer Ord. - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[3])+"\n");
				noSharesOnRun = false;
			}

	    }

	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on Marks & Spencer Ord.!</i></b></font><br>")));
			noSharesOnRun = false;
		}
	   try 
	    {
	    	setContentView(textview);

	    	String previousVolume = GetPreviousGenericVolume(shareCodeArray[4]);
	    	String currentVolume = GetCurrentGenericVolume(shareCodeArray[4]);
	    	String runPercent = GetRunPercent(previousVolume, currentVolume);


			if(DisplayRun(runPercent)==true)
			{
				textview.append(Html.fromHtml(("<big><font color='green'><b><i>Smith and Nephew PLC - RUN</i></b></font></big><br>")));
				textview.append(FormatData(shareCodeArray[4])+"\n");
				noSharesOnRun = false;
			}

	    }

	    catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			textview.append(Html.fromHtml(("<font color='#FFA500'><b><i>Connection Error on Smith and Nephew PLC!<br><br>Check connection</i></b></font><br>")));
			noSharesOnRun = false;
		}

	   
	   if(noSharesOnRun == true) 
       	   textview.append(Html.fromHtml(("<big><font color='#FFA500'><b><i>NO SHARES ARE ON RUN</i></b></font></big>")));
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

		if (percentValue >= 35)
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


