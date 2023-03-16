package com.dh.MDT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/header/nav/a[2]")));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/header/nav/a[2]"));
        loginButton.click();
    }

    public void clickRegister() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/header/nav/a[1]")));
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"root\"]/header/nav/a[1]"));
        registerButton.click();
    }
}
