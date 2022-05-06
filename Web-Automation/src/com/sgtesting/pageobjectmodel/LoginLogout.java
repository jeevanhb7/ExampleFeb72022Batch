package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout {
	public static WebDriver oBrowser=null;
	public static ActiTimePage oPage=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		createUser();
		deleteuser();
		logout();
		closeBrowser();

	}
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "D:\\JavaAutomation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oPage=new ActiTimePage(oBrowser);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void login()
	{
		try
		{
			oPage.getusername().sendKeys("admin");
			Thread.sleep(1000);
			oPage.getpassword().sendKeys("manager");
			Thread.sleep(1000);
			oPage.getloginbutton().click();
			Thread.sleep(1000);
			oPage.getflyoutwindow().click();
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void createUser()
	{
		try
		{
			oPage.getUserlink().click();
			Thread.sleep(1000);
			oPage.getadduserlink().click();
			Thread.sleep(1000);
			oPage.getfirstname().sendKeys("Jeevan");
			Thread.sleep(1000);
			oPage.getlastnamelink().sendKeys("H B");
			Thread.sleep(1000);
			oPage.getemaillink().sendKeys("jeevan@gmail.com");
			Thread.sleep(1000);
			oPage.getuserusernamelink().sendKeys("Jeevan H B");
			Thread.sleep(1000);
			oPage.getuserpasswordlink().sendKeys("123");
			Thread.sleep(1000);
			oPage.getuserreenterpasswordlink().sendKeys("123");
			Thread.sleep(1000);
			oPage.getCreateuserlink().click();
			Thread.sleep(1000);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void deleteuser()
	{
		try
		{
			oPage.getclickonexistinguser().click();
			Thread.sleep(1000);
			oPage.getdeleteuser().click();
			Thread.sleep(1000);
			Alert oAlert=oBrowser.switchTo().alert();
			oAlert.accept();
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void logout()
	{
		try
		{
			oPage.getlogoutlink();
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void closeBrowser()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
