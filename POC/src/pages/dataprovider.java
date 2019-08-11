package pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	html_page h;
	int i=0;
	int j=0;
	WebDriver dr;
	ArrayList<String> a_price=new ArrayList();
	ArrayList<String> e_price;
	ArrayList<String> a_product=new ArrayList();
	ArrayList<String> e_product;
	
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
   dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[2]/td/a")).click();
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
	  dr.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/a[1]")).click();
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th")));
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
	  
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th")));
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
  @Test(dataProvider="product")
  public void a(String anop)
  {
	  
	  h=new html_page(dr);
	  String enop=a_product.get(i);
	  
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Row']/td/b")));
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_products", enop, anop,result );
	  i++;
  }
  @DataProvider(name="product")
  public Iterator<String> get_testdata()
  {
	  h=new html_page(dr);
	  e_product=h.verify_product();
	  return e_product.iterator();
  }
  @Test(dataProvider="price")
  public void b(String anop)
  {
	  
	  h=new html_page(dr);
	  String enop=a_price.get(j);
	  
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Row']/td[2]")));
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  h.create_log("verify_price", enop, anop,result );
	  j++;
  }
  @DataProvider(name="price")
  public Iterator<String> get_testdata1()
  {
	  h=new html_page(dr);
	  e_price=h.verify_price();
	  return e_price.iterator();
  }
}
