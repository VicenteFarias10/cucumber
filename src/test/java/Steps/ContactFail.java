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

public class ContactFail {
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

    @Given("el usuario accede a la URLL {string}")
    public void el_usuario_accede_a_la_urll(String url) {
        driver.get(url); // Accede a la URL proporcionada
    }

    @When("el usuario completa el campo Correo con {string}")
    public void el_usuario_completa_el_campo_correo_con(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(correo);
    }

    @When("el usuario completa el campo Celular con {string}")
    public void el_usuario_completa_el_campo_celular_con(String celular) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phone\"]"))).sendKeys(celular);
    }

    @When("el usuario completa el campo País con {string}")
    public void el_usuario_completa_el_campo_país_con(String pais) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"country\"]"))).sendKeys(pais);
    }

    @When("el usuario completa el campo Ciudad con {string}")
    public void el_usuario_completa_el_campo_ciudad_con(String ciudad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"city\"]"))).sendKeys(ciudad);
    }

    @When("el usuario completa el campo Comuna con {string}")
    public void el_usuario_completa_el_campo_comuna_con(String comuna) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"state\"]"))).sendKeys(comuna);
    }

    @When("el usuario hace clic en el botónn Guardar")
    public void el_usuario_hace_clic_en_el_botónn_guardar() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"contactInfoSubmitButton\"]"))).click();
    }

    @Then("se muestra un mensaje de error indicando1 {string}")
    public void se_muestra_un_mensaje_de_error_indicando1(String mensajeError) {
         // Espera hasta que el mensaje de error sea visible
        By locator = By.xpath("//*[contains(text(), '" + mensajeError + "')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


        String mensajeObtenido = driver.findElement(locator).getText();
        System.out.println("Mensaje obtenido: " + mensajeObtenido); // Imprimir para depuración

        // Verifica si el mensaje obtenido es el esperado
        if (mensajeObtenido.trim().equals(mensajeError)) {
            System.out.println("Resultado: " + mensajeError + " visible correctamente");
        } else {
            System.out.println("Resultado: Mensaje esperado no encontrado");
        }

        try {
            Thread.sleep(2000); // Espera 2 segundos (2000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

