package com.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/***  -----------------------------------------Home page objects---------------------------------------------------------- ***/
	
	//home page image
	@FindBy(xpath="//img[@src='/resources/images/pets.png']")
	private WebElement welcomeImage;
	
	//veterinarians tab
	@FindBy(xpath="//a[@title='veterinarians']")
	private WebElement veternTab;
	
	//owners tab
	@FindBy(xpath="//a[@title='find owners']")
	private WebElement ownersTab;
	
	
	/***  -----------------------------------------Home page methods---------------------------------------------------------- ***/
	
	//method to validate the image on the home page
	public boolean validateHomePageImg() {
		boolean imgResult = welcomeImage.isDisplayed();
		return imgResult;
	}
	
	//method to navigate to veterinarians page
	public void navigateToVeterinarians() {
		veternTab.click();
		String vTitle = driver.findElement(By.xpath("//h2[text()='Veterinarians']")).getText();
		
		//verify the page navigation
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(vTitle, "Veterinarians");
		sa.assertAll();
	}
	
	//navigate to owners tab
	public void navigateToOwners() {
		ownersTab.click();
		
		//Validate the page
		String oTitle = driver.findElement(By.xpath("//h2[text()='Find Owners']")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(oTitle, "Find Owners");
		sa.assertAll();
	}
	
}

