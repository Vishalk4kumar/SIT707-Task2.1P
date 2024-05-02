package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Set up Firefox driver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\narwa\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe"); // Specify path to geckodriver

        // Step 2: Use Firefox driver to open up Firefox browser
        System.out.println("Fire up Firefox browser.");
        WebDriver driver = new FirefoxDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in Firefox browser
        driver.get(url);

        // Find input fields and interact with them
        WebElement firstnameInput = driver.findElement(By.id("firstname"));
        firstnameInput.sendKeys("Vishal");

        WebElement lastnameInput = driver.findElement(By.id("lastname"));
        lastnameInput.sendKeys("Kumar");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("s222342946@deakin.edu.au");

        WebElement phoneInput = driver.findElement(By.id("phoneNumber"));
        phoneInput.sendKeys("0234567890");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("test123");

        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        confirmPasswordInput.sendKeys("test123");

        // Click the 'Create account' button
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();

        // Take screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("registration_page_screenshot.png");

        try {
            FileHandler.copy(screenshotFile, destFile);
            System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sleep(10); 

        // Close Firefox browser
        driver.quit();
    }

    public static void figma_signup(String url) {
        // Set up Firefox driver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\narwa\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        // Use Firefox driver to open up Firefox browser
        System.out.println("Fire up Firefox browser.");
        WebDriver driver = new FirefoxDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load Figma signup page in Firefox browser
        driver.get(url);
        
        // Wait for the email input field to be present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        
        // Interact with elements
        emailInput.sendKeys("s222342946@deakin.edu.au");
        
        WebElement passwordInput = driver.findElement(By.id("current-password"));
        passwordInput.sendKeys("password");
        
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();
        
        try {
            Thread.sleep(10000); // Wait for 5 seconds (you can adjust this as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Take screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("Figma_registration_page_screenshot.png");

        try {
            FileHandler.copy(screenshotFile, destFile);
            System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sleep(10); 

        // Close Firefox browser
        driver.quit();
    }
}
