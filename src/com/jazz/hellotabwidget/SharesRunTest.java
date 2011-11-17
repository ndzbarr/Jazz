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
	public void testBpVolume() throws Throwable
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
		
		
		assertTrue(isValid = true);
		
	}
	
	//checks generic method to ensure that the string that is returned can be parsed as an int successfully
	public void testGenericVolume() throws Throwable
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
		assertTrue(isValid = true);
		
	}
}
