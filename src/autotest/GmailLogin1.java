/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author user
 */
public class GmailLogin1 {
    public static void main(String[] args) throws InterruptedException, IOException { 
         System.setProperty("webdriver.chrome.driver", "C:\\Grecko\\chrome\\chromedriver.exe"); 
         WebDriver driver; 
         driver = new ChromeDriver();
            // Open ToolsQA web site 
            String appUrl = "https://mail.google.com"; 
            driver.get(appUrl); 
            // Click on Registration link 
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.id("identifierId")).sendKeys("hayatahimed518@gmail.com");
            driver.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();
            driver.findElement(By.name("password")).sendKeys("hayyuu518");
            Thread.sleep(1000L);
            driver.findElement(By.xpath("//*[@id=\'passwordNext\']/span/span")).click();
            
         
            List<WebElement> mailsObj=driver.findElements(By.xpath("//*[@class='zA zE']"));
            int countNew=mailsObj.size();
            try{
            PrintStream fileStream = new PrintStream(new File("Gmailfile.txt"));
            fileStream.print("Total Number of unread mails are : ");
            fileStream.println(countNew);
            fileStream.println("Unread mail Subjects are :");
            for(WebElement item:mailsObj){
                String str=item.findElement(By.className("bqe")).getAttribute("innerHTML");
                String name=item.findElement(By.className("zF")).getAttribute("innerHTML");
                fileStream.print(str);
                fileStream.print("  from  ");
                fileStream.println(name);
            }
            fileStream.close();
            }
            catch(Exception e){e.printStackTrace();}
            Thread.sleep(1000);
            driver.close();}
            
}
//String gradeOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr[3]")).getText();
//            PrintStream fileStream = new PrintStream(new File("gradefile.txt"));
//            fileStream.println(gradeOutput);
//            fileStream.close();