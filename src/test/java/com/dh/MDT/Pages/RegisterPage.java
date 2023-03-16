package com.dh.MDT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        WebElement nameInput = driver.findElement(By.id("firstName"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterLastname(String lastName) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("repassword")));
        WebElement pass2Input = driver.findElement(By.id("repassword"));
        pass2Input.clear();
        pass2Input.sendKeys(password);
    }

    public void doClick() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[ text()='Registrarse' ]")));
        WebElement registerButton = driver.findElement(By.xpath("//*[ text()='Registrarse' ]"));
        registerButton.click();
    }

    public String checkMessage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("txt-gracias")));
        WebElement message = driver.findElement(By.className("txt-gracias"));
        String message2 = message.getText();
        return message2;
    }

    public String checkMessage2() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-feedback")));
        WebElement message = driver.findElement(By.className("form-feedback"));
        String message2 = message.getText();
        return message2;
    }
}
