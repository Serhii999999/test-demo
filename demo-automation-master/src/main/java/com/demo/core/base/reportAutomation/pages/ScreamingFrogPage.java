package com.demo.core.base.reportAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demo.core.base.Actions;


public class ScreamingFrogPage {
    private WebDriver driver;
    private Actions actions;
    public ScreamingFrogPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);

    }
    public void frogLink(){
        actions.clickWithJS(driver.findElement(By.xpath("//span[text()='ScreamingFrog']")));
    }
    public void preprodLinkClick(){
        actions.clickWithJS(driver.findElement(By.xpath("//td//span[text()='preprod']")));
    }
    public void prodLinkClick(){
        actions.clickWithJS(driver.findElement(By.xpath("//td//span[text()='prod']")));
    }

}
