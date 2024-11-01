package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class LoginPage_Web extends Base {

	public static By UserName	  =	By.id("j_username");
	public static By Password	  =	By.id("j_password");
	public static By Login_Btn	  =	By.xpath("//button[@class='btn btn-primary btn-block mb-4']");
	public static By Continue_Btn =	By.xpath("//input[@class='btn btn-primary btn-block']");

	public static RemoteWebDriver driver;

	public LoginPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}
	// Enter Email
	public static void email(String data) throws InterruptedException {
		Thread.sleep(1000);
		WebElement email = driver.findElement(UserName);		
		email.sendKeys(data);

	}
	// Enter Password
	public static void password(String data) throws InterruptedException {
		Thread.sleep(1000);
		WebElement password = driver.findElement(Password);		
		password.sendKeys(data);

	}
	// Click Login Button
	public static void loginButton() throws InterruptedException {
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(Login_Btn);		
		loginButton.click();
	}	
}


