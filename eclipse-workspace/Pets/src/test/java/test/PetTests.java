package test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.PageFactory.HomePage;
import com.PageFactory.OwnersPage;
import com.PageFactory.veterinariansPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetTests {
	
	public WebDriver driver;
	public String baseURL = "http://localhost:8080/";
	public String chromePath;
	HomePage home;
	veterinariansPage vets;
	OwnersPage owner;
	
	//1.Verify image on home page
	@Test(priority=1)
	public void verifyHomePageImg() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		home = new HomePage(driver);
		vets = new veterinariansPage(driver);
		owner = new OwnersPage(driver);
				
		//open browser with baseURL
		driver.get(baseURL);
		
		//maximize window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//validate the homepage result
		boolean homePageImgResult = home.validateHomePageImg();
		assertEquals(homePageImgResult, true);
	}
	
	//2. Find all the Veterinarians which are added in the application
	@Test(priority=2)
	public void findAllVets() {
		
		//navigate to veterinarian tab
		home.navigateToVeterinarians();
		
		//get all vet's name
		vets.getVetsName();
	}
	
	//3. Find all the existing owners which are added in application
	@Test(priority=3)
	public void findAllOwners() {
		
		//navigate to owner's tab
		home.navigateToOwners();
		
		//get all owners'names
		owner.getOwnersNames();
	}
	
	//4. Add a new owner, add pet for that owner. 
		@Test(priority=4)
		public void addOwnerPet() {
			
			//navigate to owner's page
			home.navigateToOwners();
			
			//add owner and pet
			owner.addOwner("fowner", "lowner", "owner's address", "Michigan", "4561237890", "fifi", "1988-03-24", "cat");
			
		}
		
	//5. Check all the information added for the newly created owner and pet is correct
	@Test(priority=5)
	public void validateAddition() throws InterruptedException {
		
		owner.validateData("fowner", "lowner", "owner's address", "Michigan", "4561237890", "fifi", "1988-03-24", "cat");
	}

}
