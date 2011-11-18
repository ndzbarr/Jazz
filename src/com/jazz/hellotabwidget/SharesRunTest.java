package com.jazz.hellotabwidget;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class SharesRunTest extends AndroidTestCase {
	
	SharesRun unitTest;
	
	
	public static void main(String[] args)
	{
		//junit.textui.TestRunner.run(suite());
	}
	
	protected void setUp()
	{
		unitTest =new SharesRun();
	}

	public static Test suite()
	{
		return new TestSuite(SharesRunTest.class);
	}
	
	public void testNotNull() throws Throwable
	{
		Assert.assertNotSame(unitTest,null);
	}
	
	//checks bp method returns a string that can be successfully parsed to int.
	public void testBpPreviousVolume() throws Throwable
	{
		String testerString =  unitTest.GetPreviousBPVolume("Bp");
		
		int testerInteger;
		boolean isValid;
		
		try {
			testerInteger = Integer.parseInt(testerString);
			isValid = true;
		} 
		catch(NumberFormatException nfe)
		{
			isValid = false;
		}
		
		
		assertTrue(isValid == true);
		
	}
	
	//checks bp method returns a string that can be successfully parsed to int.
		public void testBpCurrentVolume() throws Throwable
		{
			String testerString =  unitTest.GetCurrentBPVolume("Bp");
			
			int testerInteger;
			boolean isValid;
			
			try {
				testerInteger = Integer.parseInt(testerString);
				isValid = true;
			} 
			catch(NumberFormatException nfe)
			{
				isValid = false;
			}
			
			
			assertTrue(isValid == true);
			
		}
	
	//checks generic method to ensure that the string that is returned can be parsed as an int successfully
	public void testPreviousGenericVolume() throws Throwable
	{
		String testerString =  unitTest.GetPreviousGenericVolume("mks");
		
		int testerInteger;
		boolean isValid;
		
		try {
			testerInteger = Integer.parseInt(testerString);
			isValid = true;
		} 
		catch(NumberFormatException nfe)
		{
			isValid = false;
		}
		assertTrue(isValid == true);
		
	}
	
	public void testCurrentGenericVolume() throws Throwable
	{
		String testerString = unitTest.GetCurrentGenericVolume("blvn");
		int testerInteger;
		boolean isValid;
		
		try
		{
			testerInteger = Integer.parseInt(testerString);
			isValid = true;
		}
		catch(NumberFormatException nfe)
		{
			isValid = false;
		}
		
		assertTrue(isValid == true);
	}
	
	//Test generic Run Percent Method
	public void testRunPercentMethod() throws Throwable
	{
		String testerString = unitTest.GetRunPercent("20", "10");
		double testerDouble;
		boolean isValid;
		try
		{
			testerDouble = Double.parseDouble(testerString);
			isValid = true;
		}
		catch(NumberFormatException nfe)
		{
			isValid = false;
		}
		
		assertTrue(isValid == true);
		
	}
	
	//Testing various character data for RunPercent method
	public void testRunPercentBoundry() throws Throwable
	{
		String testerString = unitTest.GetRunPercent("k75", "125");
		double testerDouble;
		boolean isValid =false;
		try
		{
			testerDouble = Double.parseDouble(testerString);
			System.out.print(testerDouble);
			isValid = true;
		}
		catch(NumberFormatException nfe)
		{
			isValid = false;
		}
		
		assertTrue(isValid == false);
		
	}
	
	//Tests DisplayRun method, shows a 40% increase from previous day(140.00)
	public void testIsDisplayableMethod() throws Throwable
	{
		boolean willDisplay= unitTest.DisplayRun("140.00");
		assertTrue(willDisplay == true);
				
	}
	
	/*This test will ensure that a low trading activity ie less than the previous day, is not displayed
	test value = 40		this value corresponds to todays trading value only being 40% of what was traded on previous day
	Expected return (Boolean) = false*/
	public void testWillNotDisplay() throws Throwable
	{
		boolean willDisplay = unitTest.DisplayRun("40");
		assertTrue(willDisplay == false);
	}
	
	
	/*This test will ensure that a low trading activity ie less than the previous day, is not displayed
	test value = 125		this value corresponds to todays trading value only being 125% of what was traded on previous day
	Expected return (Boolean) = true*/
	public void testDisplayUpperBoundry() throws Throwable
	{
		boolean willDisplay = unitTest.DisplayRun("125");
		assertTrue(willDisplay==true);
	}
	
	
	/*This test will ensure that a low trading activity ie less than the previous day, is not displayed
	test value = 124.9	this value corresponds to todays trading value only being 124.9% of what was traded on previous day
	Expected return (Boolean) = false*/
	public void testDisplayLowerBoundry() throws Throwable
	{
		boolean willDisplay = unitTest.DisplayRun("124.9");
		assertTrue(willDisplay==false);
	}
	
	
}
		


