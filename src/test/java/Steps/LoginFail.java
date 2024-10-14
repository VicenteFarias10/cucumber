package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFail {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(); // Obtiene la instancia del WebDriver
        wait = new WebDriverWait(driver, 10); // Espera explícita de 10 segundos
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Cierra el WebDriver al finalizar
    }

    @Given("que puedo acceder a la URL {string}")
    public void que_puedo_acceder_a_la_url(String url) {
        driver.get(url); // Accede a la URL proporcionada
    }



    @When("ingresa el Correo {string} en el campo de Correo")
    public void ingresa_el_correo_en_el_campo_de_correo(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(correo);
    }

    @When("ingresa la contraseña {string} en el campo de Contraseña")
    public void ingresa_la_contraseña_en_el_campo_de_contraseña(String contraseña) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(contraseña);
    }

    @When("hacemos clic en el botón de iniciar sesión")
    public void hacemos_clic_en_el_botón_de_iniciar_sesión() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginSubmitButton\"]"))).click();
    }

    @Then("debería ver un mensaje de error indicando \"Invalid credentials\"")
    public void debería_ver_un_mensaje_de_error_indicando_invalid_credentials() {
        // Espera hasta que el mensaje de error sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));

        // Obtiene el texto del mensaje
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        // Verifica si el mensaje obtenido es el esperado
        if (mensajeObtenido.trim().equals("Invalid credentials")) {
            System.out.println("Resultado: Error de inicio de sesión válido");
        } else {
            System.out.println("Resultado: Error de inicio de sesión no válido");
        }
    }
}
