package com.test;


import java.io.IOException;
import java.util.HashMap;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewMDUser {

  @Test
  public void test1() throws InterruptedException {
	  System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");/*(Ĭ�ϰ�װ�����������Ҫд��δ���)*/
	  System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
	  WebDriver wd=new ChromeDriver();
	  wd.get("http://erptest.jsynjt.com/admin/users?role=store");
//	  wd.findElement(By.id("at-field-username"));
	  wd.findElement(By.id("at-field-username")).sendKeys("admin");
	  wd.findElement(By.id("at-field-password")).sendKeys("admin");
	  wd.findElement(By.id("at-btn")).click();
	  
	  Thread.sleep(3000);
	  for(int i=200;i<=200;i++){
	  
	  wd.findElement(By.linkText("系统管理")).click();
	  wd.findElement(By.xpath("//div[contains(text(),'新增用户')]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//form[@class='ui form text-left']/div[1]/div[2]/input")).sendKeys("test"+i);//	  用户名
	  
	  wd.findElement(By.xpath("//form[@class='ui form text-left']/div[2]/div[2]/input")).sendKeys("test"+i);//     名称
	  wd.findElement(By.xpath("//form[@class='ui form text-left']/div[3]/div[2]/input")).sendKeys("15010707894");//     手机号
	  wd.findElement(By.xpath("//input[@type='password']")).sendKeys("test"+i);//     密码
	  
	  Thread.sleep(2000);
      Select sel1=new Select(wd.findElement(By.tagName("select")));	  
      sel1.selectByVisibleText("门店客服");
      wd.findElement(By.xpath("//div[contains(text(),'--待分配--')]")).click();
      wd.findElement(By.xpath("//div[contains(text(),'002 盘山县吴家乡吴榆路店')]")).click();
      wd.findElement(By.xpath("//form[@class='ui form text-left']/div[8]/div")).click();
      Thread.sleep(2000);
	  }
  }
}
