package com.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class OwnersPage {
	
	WebDriver driver;
	
	public OwnersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/***  -----------------------------------------Owners page objects---------------------------------------------------------- ***/
	
	//Find owner button
	@FindBy(xpath="//button[contains(text(),'Find')]")
	private WebElement findOwnerButton;
	
	//Add owner button
	@FindBy(xpath="//a[text()='Add Owner']")
	private WebElement addOwnerLink;
	
	//Owner search ox
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement ownerSearch;
	
	//Owners table
	@FindBy(xpath="//table[@id='owners']/tbody/tr")
	private WebElement ownersTable;
	
	//Owner's first name
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstName;
	
	//Owners last name
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastName;
	
	//Owners address
	@FindBy(xpath="//input[@id='address']")
	private WebElement address;
	
	//Owners city
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	//Owners telephone
	@FindBy(xpath="//input[@id='telephone']")
	private WebElement telephone;
	
	//Submit owner
	@FindBy(xpath="//button[contains(text(), 'Add Owner')]")
	private WebElement submitOwnerButton;
	
	//Add New Pet button
	@FindBy(xpath="//a[contains(text(),  'Add')]")
	private WebElement addNewPet;
	
	//Pet's name
	@FindBy(xpath="//input[@id='name']")
	private WebElement petsName;
	
	//Pet's DoB
	@FindBy(xpath="//input[@name='birthDate']")
	private WebElement petDoB;
	
	//Pet type
	@FindBy(xpath="//select[@id='type']")
	private WebElement petType;
	
	//Add pet button
	@FindBy(xpath="//button[contains(text(), 'Add Pet')]")
	private WebElement addPet;
	
	//Edit owner link
	@FindBy(xpath="//a[contains(text(), 'Owner')]")
	private WebElement editOwnerLink;
	
	//Update Owner button
	@FindBy(xpath="//button[contains(text(), 'Update Owner')]")
	private WebElement updateOwnerButton;
	
	//edit pets link
	@FindBy(xpath="//a[contains(@href, '/visits/new')]/parent::td/preceding-sibling::td/a")
	private WebElement editPetsLink;
	
	//update pet button
	@FindBy(xpath="//button[contains(text(), 'Update Pet')]")
	private WebElement updatePetsButton;
	
	/***  -----------------------------------------Owners page methods---------------------------------------------------------- ***/
	
	//Click on find owners button
	public void clickFindOwnersButton() {
		findOwnerButton.click();
	}
	
	//method to get all owner's names
	public void getOwnersNames() {
		
		clickFindOwnersButton();
		
		List <WebElement> OwnerNames = ownersTable.findElements(By.xpath("//table[@id='owners']/tbody/tr/td[1]"));
		
		System.out.println("Owner Names:");
		
		for (WebElement names : OwnerNames) {
			System.out.println(names.getText());
		}
		
		System.out.println("");
	}
	
	//method to add an owner and a pet
	public void addOwner(String fName, String lName,String addr, String oCity, String telPhone, String petName, String dob, String type ) {
		
		//Click on Add owners button
		addOwnerLink.click();
		
		//Add firstName
		firstName.click();
		firstName.sendKeys(fName);
		
		//Add lastname
		lastName.click();
		lastName.sendKeys(lName);
		
		//Add address
		address.click();
		address.sendKeys(addr);
		
		//Add city
		city.click();
		city.sendKeys(oCity);
		
		//Add telephone
		telephone.click();
		telephone.sendKeys(telPhone);
		
		//Click on Add owner submit button
		submitOwnerButton.click();
		
		//Click on add pet button
		addNewPet.click();
		
		//add pet's name
		petsName.click();
		petsName.sendKeys(petName);
		
		//add pet dom
		petDoB.click();
		petDoB.sendKeys(dob);
		
		//Add pet type
		petType.click();
		Select ptype = new Select(petType);
		ptype.selectByValue(type);
		
		//Click on Add pet button
		addPet.click();
		
	}
	
	//method to validate if correct data has been added.
	public void validateData(String fName, String lName,String addr, String oCity, String telPhone, String petName, String dob, String type) throws InterruptedException {
		
		SoftAssert sa = new SoftAssert();
		
		Thread.sleep(5000);
		
		//Click on edit owner link
		editOwnerLink.click();
		
		//validate first name
		firstName.click();
		String editFName = firstName.getAttribute("value");
		sa.assertEquals(editFName, fName);
		
		//Validate last name
		lastName.click();
		String editLName = lastName.getAttribute("value");
		sa.assertEquals(editLName, lName);
		
		//Validate address
		address.click();
		String editAddr = address.getAttribute("value");
		sa.assertEquals(editAddr, addr);
		
		//Validate city
		city.click();
		String editCity = city.getAttribute("value");
		sa.assertEquals(editCity, oCity);
		
		//Validate telephone
		telephone.click();
		String editTelephone = telephone.getAttribute("value");
		sa.assertEquals(editTelephone, telPhone);
		
		//Click on the update owner button
		updateOwnerButton.click();
		
		Thread.sleep(5000);
		
		//Click on the edit pets link
		editPetsLink.click();
		
		//Validate Pet's name
		petsName.click();
		String editPName = petsName.getAttribute("value");
		sa.assertEquals(editPName, petName);
		
		//Validate Pet's DoB
		petDoB.click();
		String editPDoB = petDoB.getAttribute("value");
		sa.assertEquals(editPDoB, dob);
		
		//Click on update Pet button
		updatePetsButton.click();
		
		sa.assertAll();
	}
}
