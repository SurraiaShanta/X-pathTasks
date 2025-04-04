package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testNGAnnotation {
    WebDriver driver;

    @BeforeSuite()
    public void definedriver(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("Before suite");
    }

    @BeforeTest()
    public void beforetest(){
        System.out.println("Before Test");
    }

    @BeforeClass()
    public void beforeclass(){
        System.out.println("before class");
    }

    @BeforeMethod()
    public void beforemethod(){
        System.out.println("beforemethod");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("First test");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Second test");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("Second test");
    }

    @AfterMethod()
    public void aftermetion(){
        System.out.println("After Method");
    }

    @AfterClass()
    public void afterclass(){
        System.out.println("after class");
    }


    @AfterTest()
    public void aftertest(){
        System.out.println("After test");
    }

    @AfterSuite()
    public void aftersuite(){
        System.out.println("After suite");
        driver.quit();
    }

}
