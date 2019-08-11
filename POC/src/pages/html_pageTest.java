package pages;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.html_page;

public class html_pageTest {
	html_page h;
	WebDriver dr;
	ArrayList<String> a_price=new ArrayList();
	ArrayList<String> e_price=new ArrayList();
	ArrayList<String> a_product=new ArrayList();
	ArrayList<String> e_product=new ArrayList();
 @BeforeClass
 public void beforeMethod() 
 {
   System.setProperty("webdriver.chrome.driver", "chromedriver_v75.exe");
   dr=new ChromeDriver();
   dr.get("http://examples.codecharge.com/Store/Default.php");
 
   a_price.add("$36.00");
   a_price.add("$23.96");
   a_price.add("$15.99");
   a_price.add("$39.95");
   a_product.add("Flash 4 Magic");
   a_product.add("Web Design in a Nutshell");
   a_product.add("HTML 4");
   a_product.add("1001 Web Site Tips and Tricks");
   //BasicConfigurator.configure();
 }

 @AfterClass
 public void afterMethod() 
 {
		 dr.quit();
 }

  @Test(priority=0)
  public void s()
  {
	  h=new html_page(dr);
	  String anop=h.verify_search_product();
	  String enop="Search Products";
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_search_product", enop, anop,result );
  }
  @Test(priority=1)
  public void s1()
  {
	  h=new html_page(dr);
	  String anop=h.verify_catagory();
	  String enop="Categories";
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_category", enop, anop,result );
	  
  }
  @Test(priority=2)
  public void f() {
	  
	  
	  dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[2]/td/a")).click();
	 
	  h=new html_page(dr);
	  String anop=h.verify_no_of_product();
	  String enop="4";
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_no_of_product", enop, anop,result );
  }
  @Test(priority=3)
  public void f1() {
	  h=new html_page(dr);
	  e_product=h.verify_product();

	  String anop=e_product.get(0);
	  String enop=a_product.get(0);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_products", enop, anop,result );
  } 
  @Test(priority=4)
  public void f2() {
	  h=new html_page(dr);
	  e_product=h.verify_product();

	  String anop=e_product.get(1);
	  String enop=a_product.get(1);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_product", enop, anop,result );

  }
  @Test(priority=5)
  public void f3() {
	  h=new html_page(dr);
	  e_product=h.verify_product();

	  String anop=e_product.get(2);
	  String enop=a_product.get(2);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_product", enop, anop,result );
  }
  @Test(priority=6)
  public void f4() {
	  h=new html_page(dr);
	  e_product=h.verify_product();

	  String anop=e_product.get(3);
	  String enop=a_product.get(3);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_product", enop, anop,result );
  }
  @Test(priority=7)
  public void f5() {
	  h=new html_page(dr);
	  e_price=h.verify_price();

	  String anop=e_price.get(0);
	  String enop=a_price.get(0);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_price", enop, anop,result );
  }
  @Test(priority=8)
  public void f6() {
	  h=new html_page(dr);
	  e_price=h.verify_price();

	  String anop=e_price.get(1);
	  String enop=a_price.get(1);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_price", enop, anop,result );
  }
  @Test(priority=9)
  public void f7() {
	  h=new html_page(dr);
	  e_price=h.verify_price();

	  String anop=e_price.get(2);
	  String enop=a_price.get(2);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_price", enop, anop,result );
  }
  @Test(priority=10)
  public void f8() {
	  h=new html_page(dr);
	  e_price=h.verify_price();

	  String anop=e_price.get(3);
	  String enop=a_price.get(3);
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_price", enop, anop,result );
  }
  
  
  
}
