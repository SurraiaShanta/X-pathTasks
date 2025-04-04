package org.example;

import Utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SeleniumInteract {

    public void TextBoxesButtons(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Text Boxes and Buttons***");
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        System.out.println("print the user name-- "+ username.getAttribute("value"));
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        System.out.println("print the password-- "+password.getAttribute("value"));
        WebElement Login = driver.findElement(By.xpath("//*[@id='login']/button/i"));
        Login.click();
        Thread.sleep(2000);
        WebElement logout =driver.findElement(By.xpath("//*[@id='content']/div/a/i"));
        logout.click();
        driver.quit();
    }

    public void radioButtons(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Radio Buttons***");
        driver.get("https://practice.expandtesting.com/radio-buttons");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement FavoriteColor= driver.findElement(By.xpath("//label[text()='Red']"));
        Thread.sleep(2000);
        System.out.println("Checkbox selected: " + FavoriteColor.isSelected());
        FavoriteColor.click();
        Thread.sleep(2000);
        System.out.println("Checkbox selected: " + FavoriteColor.isSelected());
        WebElement FavoriteSport = driver.findElement(By.xpath("//label[text()='Football']"));
        FavoriteSport.click();
        Thread.sleep(2000);
        System.out.println("Checkbox selected: " + FavoriteSport.isSelected());


        driver.quit();
    }

    public void checkBoxesInterct(WebDriver driver){
        System.out.println("***Interaction with CheckBoxes***");
        driver.get("https://practice.expandtesting.com/checkboxes");
        WebElement checkbox = driver.findElement(By.id("checkbox1"));
        System.out.println("Is Selected: "+checkbox.isSelected());
        checkbox.click();
        System.out.println("Is Selected: "+checkbox.isSelected());

        WebElement checkBox2 = driver.findElement(By.className("form-check-input"));
        System.out.println("checkbox 2 Is Selected: "+checkBox2.isSelected());
        checkBox2.click();
        System.out.println("checkbox 2 Is Selected: "+checkBox2.isSelected());

        driver.quit();

    }


    public void DropdownInterct(WebDriver driver) throws InterruptedException {
        System.out.println("***Interact with DropDown***");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        dropdown.selectByIndex(2);
        Thread.sleep(2000);
        dropdown.selectByValue("1");
        Thread.sleep(2000);
        dropdown.deselectAll();
        driver.quit();

    }

    public void Interectwithlink(WebDriver driver) throws InterruptedException {
        System.out.println("***Interact with Link***");
        driver.get("https://practice.expandtesting.com/");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement AboutPageLink = driver.findElement(By.xpath("//*[@id='examples']/div[2]/div[4]/div/div[1]/h3/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AboutPageLink);
        Thread.sleep(2000);
        AboutPageLink.click();
        System.out.println("the About page header is"+ AboutPageLink.getAttribute("value"));
        Thread.sleep(4000);
        driver.quit();
    }

   public void interactImage(WebDriver driver){
       System.out.println("***Handle Images***");
        driver.get("https://practice.expandtesting.com/broken-images");
        WebElement img= driver.findElement(By.xpath("//*[@id='core']/div/div/div/div[3]/img"));
        String imgsrc = img.getAttribute("src");
        System.out.println("the image src is: "+imgsrc);
        driver.quit();
   }

   public void interactTable(WebDriver driver){
       System.out.println("***Handle Tables***");
        driver.get("https://practice.expandtesting.com/dynamic-table");
        System.out.println("Dynamic table interactions---");
        WebElement table= driver.findElement(By.xpath("//*[@id='core']/div/div/div[2]/div/div[2]/table"));
       List<WebElement> rows =table.findElements(By.tagName("tr"));
       for(WebElement row: rows){
            System.out.println(row.getText());
            List<WebElement> cols=table.findElements(By.tagName("td"));
            for(WebElement col : cols){
                System.out.println(col.getText()+"\t");
            }
       }
       driver.quit();
   }

   public void interactwithiFrams(WebDriver driver) throws InterruptedException {
       System.out.println("***Handle Frames***");
        driver.get("https://practice.expandtesting.com/iframe");
        WebElement frame1Title = driver.findElement(By.xpath("//*[@id='core']/div/div/div[1]/div/h2"));
        System.out.println(frame1Title.getText());
        Thread.sleep(2000);
        driver.switchTo().frame("iframe-youtube");

       WebElement frame2Title = driver.findElement(By.tagName("External IFrame: TinyMCE Editor"));
       System.out.println(frame2Title.getText());
       Thread.sleep(2000);
       driver.switchTo().frame("iframe-youtube");
       WebElement Frame1Vedio= driver.findElement(By.id("iframe-youtube"));
       Frame1Vedio.click();

       driver.quit();
   }

    public void interactAlert(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Alerts***");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement aLert= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        aLert.click();
        Thread.sleep(2000);
        Alert alert1 =driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        Thread.sleep(2000);

        WebElement Confirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        Confirm.click();
        Thread.sleep(3000);
        Alert Confirm1= driver.switchTo().alert();
        System.out.println(Confirm1.getText());
        Confirm1.dismiss();
        Thread.sleep(2000);

        WebElement Prompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        Prompt.click();
        Thread.sleep(2000);
        Alert Prompt1= driver.switchTo().alert();
        System.out.println(Prompt1.getText());
        Prompt1.sendKeys("Hello JS Prompt");
        Thread.sleep(5000);
        Prompt1.accept();
        Thread.sleep(2000);
        WebElement Result = driver.findElement(By.id("result"));
        System.out.println(Result.getText());

        driver.quit();
    }

    public void HandleWindowsTabs(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Windows and Tabs***");
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Thread.sleep(2000);

        Set<String> Handles = driver.getWindowHandles();
        for (String window : Handles){
            driver.switchTo().window(window);
            break;
        }
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Thread.sleep(2000);
        driver.quit();
    }


    public void HandleHiddenElements(WebDriver driver){
        System.out.println("***Handle Hidden Elements***");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement hiddenElements= driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        hiddenElements.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hiddenElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", hiddenElement);

        driver.quit();
    }

    public void HoverOver(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle HoverOver***");
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action =new Actions(driver);
        WebElement Avater = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(Avater).perform();
        System.out.println("Hover over element of :" + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    public void HandleDragandDrop(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Drag and Drop***");
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Thread.sleep(2000);

        new Actions(driver).dragAndDrop(source, target).perform();
        Thread.sleep(2000);
        driver.quit();
    }

    public void HandleDoubleClick(WebDriver driver){
        System.out.println("***Handle Double Click***");
        driver.get("https://www.selenium.dev/documentation/en/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='The Selenium Browser Automation Project']")));

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//h1[text()='The Selenium Browser Automation Project']"));
        actions.doubleClick(element).perform();

        System.out.println("Click on: " + element.getText());
        driver.quit();
    }

    public void HandleRightClick(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Right Click or Context Click***");
        driver.get("https://www.selenium.dev/documentation/en/");

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//h1[text()='The Selenium Browser Automation Project']"));
        actions.contextClick(element).perform();
        System.out.println("rightClicked at :" + element.getText());

        Thread.sleep(2000);
        driver.quit();
    }

    public void ScrollPage(WebDriver driver) throws InterruptedException {
        System.out.println("***Scroll Pages***");
        driver.get("https://www.selenium.dev/documentation/en/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
       Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-500);");
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//a[text()='Selenium Overview']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        Thread.sleep(2000);

        driver.quit();

    }

    public void HandleSpecialKey(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle Special Keys***");
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        WebElement InputField = driver.findElement(By.id("target"));
        InputField.sendKeys("Test");
        InputField.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
        InputField.sendKeys(Keys.CONTROL+"c");
        Thread.sleep(2000);
        InputField.sendKeys(Keys.CONTROL+"v");
        Thread.sleep(2000);
        InputField.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        driver.get("https://www.saucedemo.com");
        WebElement usernameID = driver.findElement(By.id("user-name"));
        usernameID.sendKeys("standard_user" + Keys.TAB + "secret_sauce" + Keys.TAB + Keys.ENTER);
        Thread.sleep(5000);

        driver.quit();
    }

    public void FileUpload(WebDriver driver) throws InterruptedException {
        System.out.println("***Handle File Uploads***");
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement ChooseFile = driver.findElement(By.id("file-upload"));
        ChooseFile.sendKeys("C:\\Users\\PONDIT_LAB\\Downloads\\Interaction with Different Types of Web Elements in Selenium_.pdf");
        Thread.sleep(2000);
        WebElement filesubmit = driver.findElement(By.id("file-submit"));
        filesubmit.click();
        Thread.sleep(5000);
        driver.quit();
    }




    public static void main(String[] args) throws InterruptedException {


        SeleniumInteract I= new SeleniumInteract();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        I.DropdownInterct(driver);
        I.TextBoxesButtons(driver);
        I.radioButtons(driver);
        I.checkBoxesInterct(driver);
        I.Interectwithlink(driver);
        I.interactImage(driver);
        I.interactTable(driver);
        I.interactwithiFrams(driver);
        I.interactAlert(driver);
        I.HandleWindowsTabs(driver);
        I.HandleHiddenElements(driver);
        I.HoverOver(driver);
        I.HandleDragandDrop(driver);
        I.HandleDoubleClick(driver);
        I.HandleRightClick(driver);
        I.ScrollPage(driver);
        I.HandleSpecialKey(driver);
        I.FileUpload(driver);


    }
}
