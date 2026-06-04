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

public class MotorcycleInsurance {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/");
		driver.findElement(By.linkText("Motorcycle")).click();
		
		// Enter vehicle Data
		WebElement making = driver.findElement(By.xpath("//select[@id='make']"));
		Select make = new Select(making);
		make.selectByValue("BMW");
		
		WebElement model = driver.findElement(By.xpath("//select[@id='model']"));
		Select mod = new Select(model);
		mod.selectByValue("Motorcycle");
		
		driver.findElement(By.xpath("//input[@id='cylindercapacity']")).sendKeys("1500");
		
		driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys("110");
		
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys("05/15/2025");
		
		WebElement number = driver.findElement(By.xpath("//select[@id='numberofseatsmotorcycle']"));
		Select num = new Select(number);
		num.selectByValue("2");
		
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("25000");
		
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("12000");
		
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();
		
		// Enter insurant Details
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Rohit");
		
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Chaurasia");
		
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("12/11/2002");
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		driver.findElement(By.xpath("//input[@id='streetaddress']")).sendKeys("Nanak Nagar, Pipliya Rao, Indore(M.P.)");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select cc = new Select(country);
		cc.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("452001");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Indore");
		
		WebElement occupation = driver.findElement(By.xpath("//select[@id='occupation']"));
		Select occp = new Select(occupation);
		occp.selectByValue("Selfemployed");
		
		driver.findElement(By.xpath("//label[contains(.,'Speeding')]")).click();
		driver.findElement(By.xpath("//label[contains(.,'Other')]")).click();
		
		driver.findElement(By.xpath("//button[@id=\"nextenterproductdata\"]")).click();
		
		// Enter Product Data
		
		LocalDate futureDate = LocalDate.now().plusMonths(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String date = futureDate.format(formatter);

		driver.findElement(By.id("startdate")).sendKeys(date);
		
		WebElement ins = driver.findElement(By.xpath("//select[@id='insurancesum']"));
		Select in = new Select(ins);
		in.selectByValue("10000000");
		
		WebElement damins = driver.findElement(By.xpath("//select[@id='damageinsurance']"));
		Select dam = new Select(damins);
		dam.selectByValue("Full Coverage");
		
		driver.findElement(By.xpath("//label[contains(.,'Legal Defense Insurance')]")).click();
		
		driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();
		
		// Select Price Options
		
		String expectedPpy = "1,498.00";
		String expectedOC = "Submit";
		String expectedCD = "10";
		String expectedWC = "Unlimited";
		
		String actualPpy = driver.findElement(By.xpath("//span[@id='selectultimate_price']")).getText();
		String actualOC = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		String actualCD = driver.findElement(By.xpath("//tbody/tr[3]/td[5]")).getText();
		String actualWC = driver.findElement(By.xpath("//tbody/tr[4]/td[5]")).getText();
		
		if(expectedPpy.equals(actualPpy) && expectedOC.equals(actualOC) && expectedCD.equals(actualCD) && expectedWC.equals(actualWC)) {
			WebElement price = driver.findElement(By.xpath("//input[@id='selectultimate']"));
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
		
		FileUtils.copyFile(f1, new File("D:\\\\Tricentis Vehicle Insurance Application\\\\Tricentis Vehicle Insurance Application\\\\Motorcycle.png"));

	}

}
