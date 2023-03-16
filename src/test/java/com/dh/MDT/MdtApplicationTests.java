package com.dh.MDT;

import com.dh.MDT.Pages.BasePage;
import com.dh.MDT.Pages.LoginPage;
import com.dh.MDT.Pages.RegisterPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MdtApplicationTests {

    WebDriver driver;
    BasePage home;
    LoginPage login;
    RegisterPage register;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        System.setProperty("webdriver.edge.driver", "src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testing.ctd.academy/");

    }

    @Test
    public void testLogin() {

        home = new BasePage(driver);
        home.clickLogin();
        login = new LoginPage(driver);
        login.enterEmail("equipo9@digitalhouse.com");
        login.enterPassword("asd123");
        login.doClick();
        String result = login.checkMessage();
        assertTrue(result.contains("Sus credenciales son inválidas. Por favor, vuelva a intentarlo"));

        System.out.println("Resultado obtenido: " + result);
    }

    @Test
    public void testRegister() {

        home = new BasePage(driver);
        home.clickRegister();
        register = new RegisterPage(driver);
        register.enterName("John");
        register.enterLastname("Smith");
        register.enterEmail("johnsmith1@gmail.com");
        register.enterPassword("asd123");
        register.confirmPassword("asd123");
        register.doClick();
        String result = register.checkMessage();
        assertTrue(result.contains("¡Cuenta registrada con éxito!"));

        System.out.println("Resultado obtenido: " + result);
    }

    @Test
    public void testRegisterNegative() {

        home = new BasePage(driver);
        home.clickRegister();
        register = new RegisterPage(driver);
        register.enterName("John");
        register.enterLastname("Smith");
        register.enterEmail("johnsmith1@gmail.com");
        register.enterPassword("asd123");
        register.confirmPassword("asd123");
        register.doClick();
        String result = register.checkMessage2();
        assertTrue(result.contains("Ese email ya se encuentra registrado"));

        System.out.println("Resultado obtenido: " + result);
    }

    @AfterAll
    public void exit() {

        driver.quit();
    }
}
