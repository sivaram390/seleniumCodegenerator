package com.test.seleniumcodegnerator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneratedCode {
private static ExtentReports extent;
private static ExtentTest test;
private static WebDriver driver;

public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
    driver = new ChromeDriver();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    LocalDateTime now = LocalDateTime.now();
    String timestamp = dtf.format(now);

    ExtentSparkReporter spark = new ExtentSparkReporter("reports/SparkReport_" + timestamp + ".html");
    extent = new ExtentReports();
    extent.attachReporter(spark);
}
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
    public static void generatedTestMethod() throws InterruptedException {
        test = extent.createTest("Sample Test");
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebDriverWait pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        pageLoadWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        });
        WebElement element1_PageObject = driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div[1]/div[1]/h2[2]/div[1]/div[1]/div[2]/input[1]"));
        WebElement element2_PageObject = driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div[1]/div[1]/h2[2]/div[1]/div[1]/div[5]/input[1]"));
        WebElement element3_PageObject = driver.findElement(By.xpath("//*[@id=\"sex-0\"]"));
        WebElement element4_PageObject = driver.findElement(By.xpath("//*[@id=\"exp-6\"]"));
        WebElement element5_PageObject = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
        WebElement element6_PageObject = driver.findElement(By.xpath("//*[@id=\"profession-1\"]"));
        WebElement element7_PageObject = driver.findElement(By.xpath("//*[@id=\"tool-1\"]"));
        WebElement element8_PageObject = driver.findElement(By.xpath("//*[@id=\"tool-2\"]"));
        WebElement element9_PageObject = driver.findElement(By.xpath("//*[@id=\"selenium_commands\"]/option[1]"));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div[1]/div[1]/h2[2]/div[1]/div[1]/div[2]/input[1]")));
        element1.click();
        element1.clear();
        element1.sendKeys("TestContent");
        Thread.sleep(2000);
        String element1Content = element1.getAttribute("value");
        if ("TestContent".equals(element1Content)) {
            test.log(Status.PASS, "Element 1 content is correct");
        } else {
            test.log(Status.FAIL, "Element 1 content is incorrect");
        }
        Thread.sleep(2000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div[1]/div[1]/h2[2]/div[1]/div[1]/div[5]/input[1]")));
        element2.click();
        element2.clear();
        element2.sendKeys("TestContent");
        Thread.sleep(2000);
        String element2Content = element2.getAttribute("value");
        if ("TestContent".equals(element2Content)) {
            test.log(Status.PASS, "Element 2 content is correct");
        } else {
            test.log(Status.FAIL, "Element 2 content is incorrect");
        }
        Thread.sleep(2000);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sex-0\"]")));
        element3.click();
        Thread.sleep(2000);

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"exp-6\"]")));
        element4.click();
        Thread.sleep(2000);

        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element5 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"datepicker\"]")));
        element5.click();
        element5.clear();
        element5.sendKeys("TestContent");
        Thread.sleep(2000);
        String element5Content = element5.getAttribute("value");
        if ("TestContent".equals(element5Content)) {
            test.log(Status.PASS, "Element 5 content is correct");
        } else {
            test.log(Status.FAIL, "Element 5 content is incorrect");
        }
        Thread.sleep(2000);

        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element6 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profession-1\"]")));
        element6.click();
        Thread.sleep(2000);

        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element7 = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tool-1\"]")));
        element7.click();
        Thread.sleep(2000);

        WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element8 = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tool-2\"]")));
        element8.click();
        Thread.sleep(2000);

        WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element9 = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"selenium_commands\"]/option[1]")));
        element9.click();
        Thread.sleep(2000);

    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        GeneratedCode obj = new GeneratedCode();
        obj.setUp();
        obj.generatedTestMethod();
        obj.tearDown();
        driver.quit();
    }
}

