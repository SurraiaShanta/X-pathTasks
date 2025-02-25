package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        //login
        WebElement username = driver.findElement(By.xpath("//div[@class='form_group']/descendant::input"));
        username.sendKeys("standard_user");

        Thread.sleep(2000);

        WebElement PassWordField = driver.findElement(By.xpath("//input[@class='input_error form_input' and @id = 'password']"));
        PassWordField.sendKeys("secret_sauce");

        Thread.sleep(2000);

        WebElement ClickLogin = driver.findElement(By.xpath("//input[starts-with(@class,'submit')]"));
        ClickLogin.click();

        Thread.sleep(2000);

        //Add to Cart
        WebElement click2ndAddtoCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']/following :: button[1]"));
        click2ndAddtoCart.click();
        Thread.sleep(2000);

        //can't solve this via preceding xpath.
        /*WebElement clickfirstAddtoCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']/preceding :: button[3]"));
        clickfirstAddtoCart.click();

        WebElement clickfirstAddtoCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        clickfirstAddtoCart.click();*/

        WebElement clickfirstAddtoCart = driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-lab')][1]"));
        clickfirstAddtoCart.click();

        Thread.sleep(2000);

        WebElement AddtoCartclick = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/child::a"));
        AddtoCartclick.click();

        Thread.sleep(2000);
        
        //Click checkout button
        WebElement clickCheckout = driver.findElement(By.xpath("//button[text()='Checkout']"));
        clickCheckout.click();

        Thread.sleep(5000);
        driver.quit();

    }
}