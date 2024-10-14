package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSucces {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(); // Obtiene la instancia del driver
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Cierra el driver al final
    }

    @Given("que puedo acceder a la URL valida {string}")
    public void que_puedo_acceder_a_la_url_valida(String url) {
        driver.get(url);
    }

    @When("hacemos clic en el botón de login valido")
    public void hacemos_clic_en_el_botón_de_login_valido() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div[2]/nav/a"))).click();
    }

    @When("ingresa el Correo {string} en el campo de Correo valido")
    public void ingresa_el_correo_en_el_campo_de_correo_valido(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(correo);
    }

    @When("ingresa la contraseña {string} en el campo de Contraseña valida")
    public void ingresa_la_contraseña_en_el_campo_de_contraseña_valida(String contraseña) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(contraseña);
    }

    @When("hacemos clic en el botón de iniciar sesión valido")
    public void hacemos_clic_en_el_botón_de_iniciar_sesión_valido() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginSubmitButton\"]"))).click();
    }

    @Then("debería ver un mensaje de éxito indicando \"Login Successful\"")
    public void debería_ver_un_mensaje_de_éxito_indicando_login_successful() {
        // Espera hasta que el mensaje de éxito sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));

        // Obtiene el texto del mensaje de éxito
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        // Imprime el resultado de la verificación
        if (mensajeObtenido.trim().equals("Login Successful")) {
            System.out.println("Resultado: Inicio de sesión válido");
        } else {
            System.out.println("Resultado: Inicio de sesión no válido");
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



