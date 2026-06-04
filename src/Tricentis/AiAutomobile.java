package Tricentis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AiAutomobile {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://sampleapp.tricentis.com/101/");

		// Click Automobile

		driver.findElement(By.linkText("Automobile")).click();

		// ================= ENTER VEHICLE DATA =================

		Select make = new Select(driver.findElement(By.id("make")));
		make.selectByVisibleText("Audi");

		driver.findElement(By.id("engineperformance")).sendKeys("1200");

		driver.findElement(By.id("dateofmanufacture")).sendKeys("05/20/2024");

		Select seats = new Select(driver.findElement(By.id("numberofseats")));
		seats.selectByVisibleText("5");

		Select fuel = new Select(driver.findElement(By.id("fuel")));
		fuel.selectByVisibleText("Petrol");

		driver.findElement(By.id("listprice")).sendKeys("50000");

		driver.findElement(By.id("licenseplatenumber")).sendKeys("MP09AB1234");

		driver.findElement(By.id("annualmileage")).sendKeys("10000");

		driver.findElement(By.id("nextenterinsurantdata")).click();

		// ================= ENTER INSURANT DATA =================

		driver.findElement(By.id("firstname")).sendKeys("Rohit");

		driver.findElement(By.id("lastname")).sendKeys("Chaurasia");

		driver.findElement(By.id("birthdate")).sendKeys("05/20/2002");

		driver.findElement(By.xpath("//label[text()='Male']")).click();

		driver.findElement(By.id("streetaddress")).sendKeys("Indore");

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");

		driver.findElement(By.id("zipcode")).sendKeys("452001");

		driver.findElement(By.id("city")).sendKeys("Indore");

		Select occupation = new Select(driver.findElement(By.id("occupation")));
		occupation.selectByVisibleText("Employee");

		driver.findElement(By.xpath("//label[text()='Speeding']")).click();

		driver.findElement(By.id("website")).sendKeys("https://google.com");

		// File Upload

		driver.findElement(By.id("picture"))
				.sendKeys("C:\\Users\\YourName\\Pictures\\test.jpg");

		driver.findElement(By.id("nextenterproductdata")).click();

		// ================= ENTER PRODUCT DATA =================

		// Dynamic Future Date

		LocalDate futureDate = LocalDate.now().plusMonths(1).plusDays(3);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedDate = futureDate.format(formatter);

		driver.findElement(By.id("startdate")).sendKeys(formattedDate);

		Select insurance = new Select(driver.findElement(By.id("insurancesum")));
		insurance.selectByVisibleText("3.000.000,00");

		Select merit = new Select(driver.findElement(By.id("meritrating")));
		merit.selectByVisibleText("Bonus 1");

		Select damage = new Select(driver.findElement(By.id("damageinsurance")));
		damage.selectByVisibleText("Full Coverage");

		driver.findElement(By.xpath("//label[text()='Euro Protection']")).click();

		Select courtesy = new Select(driver.findElement(By.id("courtesycar")));
		courtesy.selectByVisibleText("Yes");

		driver.findElement(By.id("nextselectpriceoption")).click();

		// ================= SELECT PRICE OPTION =================

		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='Silver']")).click();

		driver.findElement(By.id("nextsendquote")).click();

		// ================= SEND QUOTE =================

		driver.findElement(By.id("email")).sendKeys("rohit@gmail.com");

		driver.findElement(By.id("phone")).sendKeys("9876543210");

		driver.findElement(By.id("username")).sendKeys("Rohit123");

		driver.findElement(By.id("password")).sendKeys("Rohit@123");

		driver.findElement(By.id("confirmpassword")).sendKeys("Rohit@123");

		driver.findElement(By.id("Comments")).sendKeys("Automation Testing Project");

		driver.findElement(By.id("sendemail")).click();

		// Wait for Success Message

		Thread.sleep(10000);

		// ================= SCREENSHOT =================

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("./Screenshots/SuccessMessage.png");

		FileUtils.copyFile(src, dest);

		System.out.println("Screenshot Captured Successfully");

		driver.quit();

	}

}