package cowin.com.cowin;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CowinClass {
public static void FirstPage() throws InterruptedException, AWTException {
System.setProperty("webdriver.chrome.driver","/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.get("https://www.cowin.gov.in/");
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,1300);");
       Thread.sleep(3000);
   WebElement state= driver.findElement(By.xpath("//mat-select[@id='mat-select-4']"));
   js.executeScript("arguments[0].click();", state);
   Thread.sleep(1000);
         WebElement fe = driver.findElement(By.xpath("//span[text()=' Tamil Nadu ']"));
        js.executeScript("arguments[0].scrollIntoView();",fe);
        js.executeScript("arguments[0].click();",fe);
        Thread.sleep(5000);
        WebElement dis = driver.findElement(By.xpath("//div[@id='mat-select-value-7']"));
        js.executeScript("arguments[0].click();",dis);
        Thread.sleep(1000);
        WebElement cbe = driver.findElement(By.xpath("//span[text()=' Chennai ']"));
        js.executeScript("arguments[0].scrollIntoView();",cbe);
        js.executeScript("arguments[0].click();",cbe);
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c1']")).click();
        driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='cdoes1']")).click();
        driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c6']")).click();
driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c3']")).click();
Thread.sleep(5000);
List<WebElement> allops = driver.findElements(By.xpath("//div[contains(@class,'show-result')]/child::ul/li/child::span"));
for (WebElement data: allops) {
System.out.print(data.getText());

}
//div[@class='center-box']/descendant::div[6]
List<WebElement> box = driver.findElements(By.xpath("(//div[@class='row'])[8]/child::div/descendant::div[2]/h5"));
for(WebElement ref:box) {
String tex=ref.getText();
System.out.println(tex);
}
System.out.println(box.size());
}

public static void main(String[] args) throws InterruptedException, AWTException {
FirstPage();
}}

