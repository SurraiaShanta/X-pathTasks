package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class seleniumAssertion {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test()
    public void credentialsCheck(){
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//div[@class='form_group']/descendant::input"));
        WebElement PassWordField = driver.findElement(By.xpath("//input[@class='input_error form_input' and @id = 'password']"));
        WebElement ClickLogin = driver.findElement(By.xpath("//input[starts-with(@class,'submit')]"));

        Assert.assertTrue(username.isDisplayed(), "Username field is not visible");
        Assert.assertTrue(PassWordField.isDisplayed(), "Password field is not visible");
        Assert.assertTrue(ClickLogin.isDisplayed(), "Login button is not visible");

    }

    @Test()
    public void LoginTest(){
        WebElement username = driver.findElement(By.xpath("//div[@class='form_group']/descendant::input"));
        username.sendKeys("standard_user");
        WebElement PassWordField = driver.findElement(By.xpath("//input[@class='input_error form_input' and @id = 'password']"));
        PassWordField.sendKeys("secret_sauce");
        WebElement ClickLogin = driver.findElement(By.xpath("//input[starts-with(@class,'submit')]"));
        ClickLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_button_container")));


        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualURL, expectedURL, "Login failed, incorrect redirection.");
    }

    /*@Test()
    public void FirstitemAdd(dependsOnMethods = "loginTest") {

        WebElement firstProduct = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        firstProduct.click();

        WebDriverWait firstaddcart = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement FirstremoveButton = firstaddcart.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert.assertEquals(FirstremoveButton.getText(), "Remove", "Item not added to cart successfully!");
    }*/

    @Test()
    public void addToCartTest() {
        WebElement firstProduct = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        firstProduct.click();
        WebElement secondProduct = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        secondProduct.click();

        WebDriverWait firstaddcart = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement FirstremoveButton = firstaddcart.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert.assertEquals(FirstremoveButton.getText(), "Remove", "Item not added to cart successfully!");

    }

    @Test()
    public void clicktoCart(){
        WebElement CartbuttonClick= driver.findElement(By.className("shopping_cart_link"));
        CartbuttonClick.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/cart.html";

        Assert.assertEquals(actualURL, expectedURL, "Incorrect redirection.");
    }

    // Go to the product details page by clicking product title from your Cart Page
    //Aita run korle 2 no test run hoy na
   /*@Test()
    public void ProductDetails() {
        WebElement firstProductDetails = driver.findElement(By.id("item_0_title_link"));
        firstProductDetails.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=0";

        Assert.assertEquals(actualURL, expectedURL, "Login failed, incorrect redirection.");

    }

    //Check out a click hocche na
    @Test()
    public void CheckoutClick(){
        driver.get("https://www.saucedemo.com/");
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebDriverWait Checkoutt = new WebDriverWait(driver, Duration.ofSeconds(15));
    }*/

    @Test()
    public void checkoutTest() {
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertEquals(actualURL, expectedURL, "Incorrect redirection.");


        driver.findElement(By.id("first-name")).sendKeys("Surraia");
        driver.findElement(By.id("last-name")).sendKeys("Shanta");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualURL1 = driver.getCurrentUrl();
        String expectedURL1 = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualURL1, expectedURL1, "Incorrect redirection.");


        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        String actualURL2 = driver.getCurrentUrl();
        String expectedURL2 = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(actualURL2, expectedURL2, "Incorrect redirection.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
