package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/newDriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize(); // Maximizamos la ventana
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Limpia la instancia después de cerrar
        }
    }
}
