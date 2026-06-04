package Tricentis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CamperInsurance {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/");
		driver.findElement(By.linkText("Camper")).click();
		
		// Enter Vehicle Data
		
		WebElement making = driver.findElement(By.xpath("//select[@id='make']"));
		Select make = new Select(making);
		make.selectByValue("Porsche");
		
		driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys("150");
		
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys("05/21/2023");
		
		WebElement seats = driver.findElement(By.xpath("//select[@id='numberofseats']"));
		Select numseats = new Select(seats);
		numseats.selectByValue("4");
		
		driver.findElement(By.xpath("//label[text()='No']")).click();
		
		WebElement fuel = driver.findElement(By.xpath("//select[@id='fuel']"));
		Select type = new Select(fuel);
		type.selectByValue("Electric Power");
		
		driver.findElement(By.xpath("//input[@id='payload']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@id='totalweight']")).sendKeys("2000");
		
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("45000");
		
		driver.findElement(By.xpath("//input[@id='licenseplatenumber']")).sendKeys("MH12AB1234");
		
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("12000");
		
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();
		
		// Enter Insurant Data
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Rohit");
		
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Chaurasia");
		
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("12/11/2002");
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		driver.findElement(By.xpath("//input[@id='streetaddress']")).sendKeys("Nanak Nagar, Pipliya Rao, Indore (M.P.)");
		
		WebElement coun = driver.findElement(By.xpath("//select[@id='country']"));
		Select country = new Select(coun);
		country.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("452001");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Indore");
		
		WebElement occ = driver.findElement(By.xpath("//select[@id='occupation']"));
		Select occp = new Select(occ);
		occp.selectByValue("Selfemployed");
		
		driver.findElement(By.xpath("//label[contains(.,' Bungee Jumping')]")).click();
		driver.findElement(By.xpath("//label[contains(.,'Cliff Diving')]")).click();
		driver.findElement(By.xpath("//label[contains(.,' Skydiving')]")).click();
		
		driver.findElement(By.xpath("//button[@id='nextenterproductdata']")).click();
		
		// Enter Product Data
		LocalDate futureDate = LocalDate.now().plusMonths(2);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String date = futureDate.format(formatter);

		driver.findElement(By.id("startdate")).sendKeys(date);
		
		WebElement insu =  driver.findElement(By.xpath("//select[@id='insurancesum']"));
		Select ins = new Select(insu);
		ins.selectByValue("35000000");
		
		WebElement damins = driver.findElement(By.xpath("//select[@id='damageinsurance']"));
		Select dmg = new Select(damins);
		dmg.selectByValue("Full Coverage");
		
		driver.findElement(By.xpath("//label[contains(.,'Euro Protection')]")).click();
		driver.findElement(By.xpath("//label[contains(.,'Legal Defense Insurance')]")).click();
		
		driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();
		
		// Select Price Options
		
		String expectedPpy = "226.00";
		String expectedOC = "No";
		String expectedCD = "No";
		String expectedWC = "No";
		
		String actualPpy = driver.findElement(By.xpath("//span[@id='selectsilver_price']")).getText();
		String actualOC = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		String actualCD = driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText();
		String actualWC = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		
		if(expectedPpy.equals(actualPpy) && expectedOC.equals(actualOC) && expectedCD.equals(actualCD) && expectedWC.equals(actualWC)) {
			WebElement price = driver.findElement(By.xpath("//input[@id='selectsilver']"));
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", price);
		}
		else {
			System.out.println("Something Went Wrong... ");
		}
		
		driver.findElement(By.xpath("//button[@id='nextsendquote']")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rohitc6261@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("6261732818");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rohitc");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rohitc6261@");
		driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys("Rohitc6261@");
		driver.findElement(By.xpath("//textarea[@id='Comments']")).sendKeys("Feels good to complete this module thorugh automation.");
		
		driver.findElement(By.xpath("//button[@id='sendemail']")).click();
		Thread.sleep(20000);
		
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f1, new File("D:\\\\Tricentis Vehicle Insurance Application\\\\Tricentis Vehicle Insurance Application\\\\Camper.png"));
		
	}

}
