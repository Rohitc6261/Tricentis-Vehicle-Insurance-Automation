package Tricentis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoMobileInsurance {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.get("https://sampleapp.tricentis.com/101/");
		driver.findElement(By.linkText("Automobile")).click();
		
		//Enter vehicle data
		
		WebElement making = driver.findElement(By.xpath("//select[@id='make']"));
		Select make = new Select(making);
		make.selectByVisibleText("Volkswagen");
		
		driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys("120");
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys("05/15/2022");
		
		WebElement seats = driver.findElement(By.xpath("//select[@id='numberofseats']"));
		Select no_of_seats = new Select(seats);
		no_of_seats.selectByValue("5");
		
		WebElement fueltype = driver.findElement(By.xpath("//select[@id='fuel']"));
		Select fuel = new Select(fueltype);
		fuel.selectByValue("Petrol");
		
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("25000");
		
		driver.findElement(By.xpath("//input[@id='licenseplatenumber']")).sendKeys("MH12AB1234");
		
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("12000");
		
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();
		
		// Enter insurance data
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Rohit");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Chaurasia");
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("12/11/2002");
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//input[@id='streetaddress']")).sendKeys("Nanak Nagar");
		
		WebElement countries = driver.findElement(By.xpath("//select[@id='country']"));
		Select country = new Select(countries);
		country.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("452001");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Indore");
		
		WebElement occupation = driver.findElement(By.xpath("//select[@id='occupation']"));
		Select occp = new Select(occupation);
		occp.selectByValue("Selfemployed");
		
		driver.findElement(By.xpath("//label[contains(.,'Speeding')]")).click();

		driver.findElement(By.xpath("//label[contains(.,'Other')]")).click();
		
		driver.findElement(By.xpath("//button[@id='nextenterproductdata']")).click();
		
		// Enter Product Data
		
		LocalDate futureDate = LocalDate.now().plusMonths(1).plusDays(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String date = futureDate.format(formatter);

		driver.findElement(By.id("startdate")).sendKeys(date);
		
		WebElement InsuranceSum = driver.findElement(By.xpath("//select[@id='insurancesum']"));
		Select sum = new Select(InsuranceSum);
		sum.selectByValue("3000000");
		
		WebElement bonus = driver.findElement(By.xpath("//select[@id='meritrating']"));
		Select bn = new Select(bonus);
		bn.selectByValue("Bonus 3");
		
		WebElement damageIns = driver.findElement(By.xpath("//select[@id='damageinsurance']"));
		Select dam = new Select(damageIns);
		dam.selectByValue("Full Coverage");
		
		List<WebElement> optProducts = driver.findElements(By.xpath("//section[@class='idealsteps-step'][3]/div[5]/p/label"));
		for(WebElement chkbox : optProducts) {
			chkbox.click();
		}
		
		WebElement CourtseyCar = driver.findElement(By.xpath("//select[@id='courtesycar']"));
		Select cc = new Select(CourtseyCar);
		cc.selectByValue("No");
		
		driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();
		
		// select price option
		String expectedPpy = "449.00";
		String expectedOC = "Submit";
		String expectedCD = "2";
		String expectedWC = "Limited";
		
		String actualPpy = driver.findElement(By.xpath("//span[@id='selectgold_price']")).getText();
		String actualOC = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();
		String actualCD = driver.findElement(By.xpath("//tbody/tr[3]/td[3]")).getText();
		String actualWC = driver.findElement(By.xpath("//tbody/tr[4]/td[3]")).getText();
		
		if(expectedPpy.equals(actualPpy) && expectedOC.equals(actualOC) && expectedCD.equals(actualCD) && expectedWC.equals(actualWC)) {
			WebElement selection = driver.findElement(By.id("selectgold"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", selection);
		}
		else {
			System.out.println("Something went wrong...");
		}
		
		driver.findElement(By.xpath("//button[@id='nextsendquote']")).click();
		
		// send qoute
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rohitc6261@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("6261732818");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rohitc");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rohitc6261@");
		driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys("Rohitc6261@");
		driver.findElement(By.xpath("//textarea[@id='Comments']")).sendKeys("Feeling nice to complete this module.");
		
		driver.findElement(By.xpath("//button[@id='sendemail']")).click();
		
		Thread.sleep(20000);
		
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("D:\\Tricentis Vehicle Insurance Application\\Tricentis Vehicle Insurance Application\\Automobile.png"));
		
	}

}
