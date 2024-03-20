package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\narwa\\Downloads\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in chromium browser.
        driver.get(url);

        /*
         * How to identify a HTML input field - Step 1: Inspect the webpage, Step 2: locate
         * the input field, Step 3: Find out how to identify it, by id/name/...
         */

        // Find first input field which is firstname
        WebElement firstnameInput = driver.findElement(By.id("firstname"));
        firstnameInput.sendKeys("Vishal");

        // Find last name input field
        WebElement lastnameInput = driver.findElement(By.id("lastname"));
        lastnameInput.sendKeys("Kumar");

        // Find email input field
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("s222342946@deakin.edu.au");

        // Find phone number input field
        WebElement phoneInput = driver.findElement(By.id("phoneNumber"));
        phoneInput.sendKeys("0234567890");

        // Find password input field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("test123");

        // Find confirm password input field
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        confirmPasswordInput.sendKeys("test123"); // Confirm password

        /*
         * Identify button 'Create account' and click to submit using Selenium API.
         */
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();

        /*
         * Take screenshot using Selenium API.
         */
        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define destination for screenshot
        File destFile = new File("registration_page_screenshot.png");

        try {
            // Copy screenshot to destination
            FileHandler.copy(screenshotFile, destFile);
            System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sleep a while
        sleep(10); 

        // Close chrome driver
        driver.quit();
    }

    public static void figma_signup(String url) {
        // Step 1: Locate the Chrome driver in the local drive.
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\narwa\\Downloads\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

        // Step 2: Use the Chrome driver to open up a Chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load the Figma signup page in the Chromium browser.
        driver.get(url);
        
        // Wait for email input field to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        
        // Fill the email input field
        emailInput.sendKeys("s222342946@deakin.edu.au");
        
        // Find and fill the password input field
        WebElement passwordInput = driver.findElement(By.id("current-password"));
        passwordInput.sendKeys("password");
        
        /*
         * Identify button 'Create account' and click to submit using Selenium API.
         */
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createAccountButton.click();
        
        try {
            Thread.sleep(10000); // Wait for 5 seconds (you can adjust this as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        /*
         * Take screenshot using Selenium API.
         */
        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define destination for screenshot
        File destFile = new File("Figma_registration_page_screenshot.png");

        try {
            // Copy screenshot to destination
            FileHandler.copy(screenshotFile, destFile);
            System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Sleep a while
        sleep(10); 

        // Close the Chrome browser window
        driver.close();

        // Quit chrome driver
        driver.quit();
    }
}

