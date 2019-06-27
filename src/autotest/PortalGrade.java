/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author user
 */
public class PortalGrade {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException { 
         System.setProperty("webdriver.chrome.driver", "C:\\Grecko\\chrome\\chromedriver.exe"); 
         WebDriver driver; 
         driver = new ChromeDriver();
            // Open ToolsQA web site 
            String appUrl = "https://portal.aait.edu.et/Web/Guest"; 
            driver.get(appUrl); 
            // Click on Registration link 
            String gradeUrl = "https://portal.aait.edu.et/Grade/GradeReport";
            driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("xyz/xyz/09"); 
            driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("mypass"); 
            driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();
            driver.navigate().to(gradeUrl);
            List<WebElement> gradeOutput = driver.findElements(By.tagName("tr"));
            try{
            PrintStream fileStream = new PrintStream(new File("gradefile.txt"));
            for(WebElement e:gradeOutput){
                List<WebElement> grades=e.findElements(By.tagName("td"));
               for(WebElement grade:grades){
                    String str=grade.getText();
                    fileStream.println(str);
                    
            }
            }
            fileStream.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            Thread.sleep(800);
            driver.close();
    
}}
