package com.demo.core.base.reportAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demo.core.base.Actions;

public class BuildPage {
    private WebDriver driver;
    private Actions actions;
    public BuildPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }
    public void clickConsoleOutputButton(){
        actions.click(driver.findElement(By.xpath("//*[text()='Console Output']")));
    }
    public void clickFullLogButton(){
        actions.click(driver.findElement(By.xpath("//a[text()='Full Log']")));
    }
}
