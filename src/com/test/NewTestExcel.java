package com.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewTestExcel {
	private WebDriver driver ;
	DesiredCapabilities firefoxCap;
	
	@DataProvider(name="num")
    public Object[][] Numbers() throws BiffException, IOException{
        Excel e=new Excel("testdata1", "user");
        return e.getExcelData();
    }
	
	@Test(dataProvider="num")
	public void test1(HashMap<String, String> data) throws MalformedURLException, InterruptedException{
   	 firefoxCap = DesiredCapabilities.chrome();
	 
//	 driver = new RemoteWebDriver(new URL(data.get("address")), firefoxCap);
   	
	 driver = new RemoteWebDriver(new URL("http://192.168.1.191:5555/wd/hub"), firefoxCap);
	 driver.get("http://erptest.jsynjt.com/");
	 int i=0;
	 
     driver.findElement(By.id("at-field-username")).sendKeys(data.get("name"));
     driver.findElement(By.id("at-field-password")).sendKeys(data.get("password"));
     driver.findElement(By.id("at-btn")).click();
     Thread.sleep(10000);
	 driver.findElement(By.xpath("//div[text()='ËùÓÐ¶©µ¥']")).click();

	}
	
}
