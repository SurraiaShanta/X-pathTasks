package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class radiobuttons {

    public void sss(WebDriver driver) {

        try {
            // Navigate to the radio buttons page
            driver.get("https://practice.expandtesting.com/radio-buttons");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Find all radio buttons
            List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

            // Loop through each radio button and interact with it
            for (WebElement radio : radioButtons) {
                System.out.println("Radio button ID: " + radio.getAttribute("id"));
                System.out.println("Before click - Is selected: " + radio.isSelected());

                // Click the radio button if it's not already selected
                if (!radio.isSelected()) {
                    radio.click();
                    System.out.println("After click - Is selected: " + radio.isSelected());
                }

                System.out.println("----------------------------------");
            }

            // Alternatively, you can interact with specific radio buttons by their IDs
            WebElement redRadio = driver.findElement(By.id("red"));
            WebElement blueRadio = driver.findElement(By.id("blue"));
            WebElement greenRadio = driver.findElement(By.id("green"));

            System.out.println("\nTesting specific radio buttons:");
            System.out.println("Red selected: " + redRadio.isSelected());
            System.out.println("Blue selected: " + blueRadio.isSelected());
            System.out.println("Green selected: " + greenRadio.isSelected());

            // Select the blue radio button
            blueRadio.click();
            System.out.println("\nAfter selecting Blue:");
            System.out.println("Red selected: " + redRadio.isSelected());
            System.out.println("Blue selected: " + blueRadio.isSelected());
            System.out.println("Green selected: " + greenRadio.isSelected());

            // Add a small delay to see the changes (optional)
            Thread.sleep(2000);

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

    }


    public static void main(String[] args) {
        radiobuttons q = new radiobuttons();
        WebDriver driver = new ChromeDriver();
        q.sss(driver);

    }
}
