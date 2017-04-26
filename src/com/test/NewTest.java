package com.test;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.inject.internal.BytecodeGen.Visibility;

public class NewTest {
	private WebDriver driver ;
	DesiredCapabilities firefoxCap;
	@Parameters({"browser", "nodeUrl","username","password"})
	
	@BeforeTest
	public void setUp(String browser, String nodeUrl,String username,String password) throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
        if (browser.equals("ie")){
        	firefoxCap = DesiredCapabilities.internetExplorer();
        }
        else if (browser.equals("ff"))
        	firefoxCap = DesiredCapabilities.firefox();
        else if (browser.equals("chrome"))
        	firefoxCap = DesiredCapabilities.chrome();
        else
            System.out.println("browser parameter wrong , can only be :ie、 ff、chrome");
        
        String url = nodeUrl + "/wd/hub";
        URL urlInstance = null;
        try {
            urlInstance = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        driver = new RemoteWebDriver(urlInstance, firefoxCap);
        driver.get("http://erptest.jsynjt.com/");
        driver.findElement(By.id("at-field-username")).sendKeys(username);
        driver.findElement(By.id("at-field-password")).sendKeys(password);
        driver.findElement(By.id("at-btn")).click();
//        driver.wait(5000);
//        driver.findElement(By.linkText("所有订单")).click();
//        driver.findElement(By.xpath("id('react-root')/x:div/x:div[2]/x:div[1]/x:div[1]/x:div/x:a[1]id('react-root')/x:div/x:div[2]/x:div[1]/x:div[1]/x:div/x:a[1]")).click();
//        driver.findElement(By.className("active green item")).click();
//        driver.findElement(By.xpath(”//a[contains(text(), ’所有订单’)])“);
         
    }
	
//	  public void beforeTest() throws MalformedURLException {
//		DesiredCapabilities firefoxCap=DesiredCapabilities.internetExplorer();
//		DesiredCapabilities firefoxCap=DesiredCapabilities.chrome();
//		DesiredCapabilities firefoxCap=DesiredCapabilities.firefox();
//		  firefoxCap.setBrowserName("firefox");
//		  firefoxCap.setVersion("49.0.2");
//		  firefoxCap.setPlatform(Platform.WINDOWS);
//		  firefoxCap.setCapability("firefox_binary","D:\\Program Files\\Firefox\\firefox.exe");
		
//		 driver=new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"),firefoxCap);
//	  }

	  @AfterTest
	  public void afterTest() {
//		  driver.close();
	  }
      @Test
      public void f() throws InterruptedException {

//    	  Thread.sleep(10000);
//    	  driver.findElement(By.xpath("//a[text()='所有订单']")).click();
    	  Thread.sleep(1000);
    	  System.out.println("rrrrrrrrrrrrrrr");
//    	  driver.findElement(By.linkText("所有订单")).click();
//    	  driver.findElement(By.xpath("id('react-root')/x:div/x:div[3]/x:div[1]/x:div[1]/x:div/x:a[1]"));
//    	  driver.findElement(By.xpath("//div/a[contains(@href,'/store/all')]")).click();

//          (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
//            public Boolean apply(WebDriver driver){
//            	WebElement b=driver.findElement(By.xpath("//*[contains(text(),'订单'])"));
//            	if(b!=null){
//            		return true;
//            	}else{
//            		return false;
//            	}
            	
            		
            	
//            }
//          });
//        	 System.out.println("已经加载完毕");
        	 
          }
    
  
}
