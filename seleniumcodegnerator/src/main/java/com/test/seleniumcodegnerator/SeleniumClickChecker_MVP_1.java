package com.test.seleniumcodegnerator;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeleniumClickChecker_MVP_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.techlistic.com/p/selenium-practice-form.html";
        driver.get(url);
        Thread.sleep(5000);

        String clickScript = "function getXPath(element) {" +
                "    if (element.id !== '') {" +
                "        return '//*[@id=\\\"' + element.id + '\\\"]';" +
                "    }" +
                "    if (element === document.body) {" +
                "        return element.tagName.toLowerCase();" +
                "    }" +
                "    var ix = 0;" +
                "    var siblings = element.parentNode.childNodes;" +
                "    for (var i = 0; i < siblings.length; i++) {" +
                "        var sibling = siblings[i];" +
                "        if (sibling.nodeType === 1 && sibling.tagName === element.tagName) {" +
                "            ix++;" +
                "        }" +
                "        if (sibling === element) {" +
                "            return getXPath(element.parentNode) + '/' + element.tagName.toLowerCase() + '[' + ix + ']';" +
                "        }" +
                "    }" +
                "}" +
                "document.addEventListener('click', function(e) {" +
                "    e.preventDefault();" +
                "    var elementId = e.target.id;" +
                "    var elementName = e.target.name;" +
                "    var elementCoordinates = { 'x': e.clientX, 'y': e.clientY };" +
                "    var elementXPath = getXPath(e.target);" +
                "    var elementType = e.target.type || '';" +
                "    window.clickedElementInfo = 'Element ID: ' + elementId + '\\nElement Name: ' + elementName + '\\nElement Coordinates: ' + JSON.stringify(elementCoordinates) + '\\nElement XPath: ' + elementXPath.replace(/\"/g, '\\\"') + '\\nElement Type: ' + elementType;" +
                "    if (window.lastSelectedElement) {" +
                "        window.lastSelectedElement.style.outline = '2px solid blue';" +
                "    }" +
                "    e.target.style.outline = '2px solid green';" +
                "    window.lastSelectedElement = e.target;" +
                "}, true);";

        ((JavascriptExecutor) driver).executeScript(clickScript);

        System.out.println("Click on any element in the opened webpage...");

        List<String> xPaths = new ArrayList<>();
        List<String> elementTypes = new ArrayList<>();
        List<ClickedElement> clickedElements = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press ENTER to get the clicked element info or type 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String clickedElementInfo = (String) ((JavascriptExecutor) driver).executeScript("return window.clickedElementInfo || '';");

            if (!clickedElementInfo.isEmpty()) {
                System.out.println(clickedElementInfo);
                String elementXPath = clickedElementInfo.split("\n")[3].substring("Element XPath: ".length());
                xPaths.add(elementXPath);
                String elementType = clickedElementInfo.split("\n")[4].substring("Element Type: ".length());
                elementTypes.add(elementType);
                clickedElements.add(new ClickedElement(elementXPath, elementType));
            }

            // Generate Java code using collected XPaths

           
            
        }
        String pageTitle = driver.getTitle().replaceAll("[^a-zA-Z0-9]", "");
        String className = pageTitle.isEmpty() ? "GeneratedCode" : pageTitle;
        String methodName = pageTitle.isEmpty() ? "generatedTestMethod" : pageTitle;

        System.out.println("Generating Java code using collected XPaths:");

        StringBuilder javaCode = new StringBuilder();
        javaCode.append("import com.aventstack.extentreports.ExtentReports;\n");
        javaCode.append("import com.aventstack.extentreports.ExtentTest;\n");
        javaCode.append("import com.aventstack.extentreports.Status;\n");
        javaCode.append("import com.aventstack.extentreports.reporter.ExtentSparkReporter;\n");
        javaCode.append("import java.time.Duration;\n");
        javaCode.append("import java.time.LocalDateTime;\n");
        javaCode.append("import java.time.format.DateTimeFormatter;\n");
        javaCode.append("import org.openqa.selenium.By;\n");
        javaCode.append("import org.openqa.selenium.JavascriptExecutor;\n");
        javaCode.append("import org.openqa.selenium.WebDriver;\n");
        javaCode.append("import org.openqa.selenium.WebElement;\n");
        javaCode.append("import org.openqa.selenium.chrome.ChromeDriver;\n");
        javaCode.append("import org.openqa.selenium.support.ui.ExpectedCondition;\n");
        javaCode.append("import org.openqa.selenium.support.ui.ExpectedConditions;\n");
        javaCode.append("import org.openqa.selenium.support.ui.WebDriverWait;\n");

        javaCode.append("\n");
        
        javaCode.append("public class ").append(className).append(" {\n");
        javaCode.append("private static ExtentReports extent;\n");
        javaCode.append("private static ExtentTest test;\n");
        javaCode.append("private static WebDriver driver;\n");
        javaCode.append("\n");
        javaCode.append("public void setUp() {\n");
        javaCode.append("    System.setProperty(\"webdriver.chrome.driver\", \".\\\\chromedriver.exe\");\n");
        javaCode.append("    driver = new ChromeDriver();\n");
        javaCode.append("\n");
        javaCode.append("    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(\"yyyyMMdd_HHmmss\");\n");
        javaCode.append("    LocalDateTime now = LocalDateTime.now();\n");
        javaCode.append("    String timestamp = dtf.format(now);\n");
        javaCode.append("\n");
        javaCode.append("    ExtentSparkReporter spark = new ExtentSparkReporter(\"reports/SparkReport_\" + timestamp + \".html\");\n");
        javaCode.append("    extent = new ExtentReports();\n");
        javaCode.append("    extent.attachReporter(spark);\n");
        javaCode.append("}\n");
        javaCode.append("    public void tearDown() {\n");
        javaCode.append("        extent.flush();\n");
        javaCode.append("        driver.quit();\n");
        javaCode.append("    }\n");
        
        javaCode.append("    public static void ").append(methodName).append("() throws InterruptedException {\n");
        javaCode.append("        test = extent.createTest(\"Sample Test\");\n");
        javaCode.append("        driver.get(\"").append(url).append("\");\n");
        javaCode.append("        WebDriverWait pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(30));\n");
        javaCode.append("        pageLoadWait.until(new ExpectedCondition<Boolean>() {\n");
        javaCode.append("            public Boolean apply(WebDriver webDriver) {\n");
        javaCode.append("                return ((JavascriptExecutor) webDriver).executeScript(\"return document.readyState\").equals(\"complete\");\n");
        javaCode.append("            }\n");
        javaCode.append("        });\n");
        

        for (int i = 0; i < clickedElements.size(); i++) {
            ClickedElement element = clickedElements.get(i);
            javaCode.append("        WebElement element").append(i + 1 +"_PageObject").append(" = driver.findElement(By.xpath(\"").append(element.getXPath().replace("\"", "\\\"")).append("\"));\n");
        }

        javaCode.append("\n");

        for (int i = 0; i < xPaths.size(); i++) {
            String elementType = elementTypes.get(i);
            int elementNumber = i + 1;
            String xpath = clickedElements.get(i).getXPath();

            // Add a wait for the element to be visible in the generated Java code
            javaCode.append("        WebDriverWait wait").append(elementNumber).append(" = new WebDriverWait(driver, Duration.ofSeconds(30));\n");
            javaCode.append("        WebElement element").append(elementNumber).append(" = wait").append(elementNumber).append(".until(ExpectedConditions.visibilityOfElementLocated(By.xpath(\"").append(clickedElements.get(i).getXPath().replace("\"", "\\\"")).append("\")));").append("\n");

            if ("text".equals(elementType) || "password".equals(elementType) || "email".equals(elementType)) {
                javaCode.append("        element").append(elementNumber).append(".click();\n");
                javaCode.append("        element").append(elementNumber).append(".clear();\n");
                javaCode.append("        element").append(elementNumber).append(".sendKeys(\"TestContent\");\n");
                javaCode.append("        Thread.sleep(2000);\n");
                javaCode.append("        String element").append(elementNumber).append("Content = element").append(elementNumber).append(".getAttribute(\"value\");\n");
                javaCode.append("        if (\"TestContent\".equals(element").append(elementNumber).append("Content)) {\n");
                javaCode.append("            test.log(Status.PASS, \"Element ").append(elementNumber).append(" content is correct\");\n");
                javaCode.append("        } else {\n");
                javaCode.append("            test.log(Status.FAIL, \"Element ").append(elementNumber).append(" content is incorrect\");\n");
                javaCode.append("        }\n");
                javaCode.append("        Thread.sleep(2000);\n");
            } else {
                javaCode.append("        element").append(elementNumber).append(".click();\n");
                javaCode.append("        Thread.sleep(2000);\n");
            }
            javaCode.append("\n");
        }

        javaCode.append("    }\n"); // Close methodName
        
        javaCode.append("    public static void main(String[] args) throws InterruptedException {\n");
        javaCode.append("        System.setProperty(\"webdriver.http.factory\", \"jdk-http-client\");\n");
        javaCode.append("        ").append(className).append(" obj = new ").append(className).append("();\n");
        javaCode.append("        obj.setUp();\n");
        javaCode.append("        obj.").append(methodName).append("();\n");
        javaCode.append("        obj.tearDown();\n");
        javaCode.append("        driver.quit();\n");
        javaCode.append("    }\n");
                
        javaCode.append("}\n"); // Close class

        System.out.println(javaCode.toString());

        driver.quit();
        scanner.close();
    }
}
