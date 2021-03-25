package com.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class veterinariansPage {

	public WebDriver driver;

	public veterinariansPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** ------------------------Vets Page objects----------------------------------------------------- ***/
	@FindBy(xpath="//table[@id='vets']/tbody/tr")
	private WebElement vetsTable;
	
	/*** ------------------------Vets Page methods----------------------------------------------------- ***/
	public void getVetsName() {
		List<WebElement> docNames = vetsTable.findElements(By.xpath("//table[@id='vets']/tbody/tr/td[1]"));
		
		System.out.println("Vet's Names: ");
		for (WebElement names : docNames) {
			System.out.println(names.getText());
		}
		
		System.out.println("");
	}
}
