package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProfileFail {
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

    @Given("el usuario accede a la URL {string}")
    public void el_usuario_accede_a_la_url(String url) {
        driver.get(url); // Accede a la URL proporcionada
    }

    @When("el usuario completa el campo Licencia Médica con {string}")
    public void el_usuario_completa_el_campo_licencia_médica_con(String licenciaMedica) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"medicalLicense\"]"))).sendKeys(licenciaMedica);
    }

    @When("el usuario completa el campo Años de Experiencia con {string}")
    public void el_usuario_completa_el_campo_años_de_experiencia_con(String anosExperiencia) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yearsExperience\"]"))).sendKeys(anosExperiencia);
    }

    @When("el usuario completa el campo Expiración Licencia Médica con {string}")
    public void el_usuario_completa_el_campo_expiración_licencia_médica_con(String expiracionLicencia) {
        By dateFieldLocator = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/div[3]/div/div/div/input[2]");

        wait.until(ExpectedConditions.elementToBeClickable(dateFieldLocator)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(dateFieldLocator).clear();
        driver.findElement(dateFieldLocator).sendKeys(expiracionLicencia);
        driver.findElement(dateFieldLocator).sendKeys(Keys.ENTER);
    }

    @When("el usuario completa el campo Resumen Profesional con {string}")
    public void el_usuario_completa_el_campo_resumen_profesional_con(String resumenProfesional) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bio\"]"))).sendKeys(resumenProfesional);
    }

    @When("el usuario hace clic en el botón Guardar")
    public void el_usuario_hace_clic_en_el_botón_guardar() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"profileInfoSubmitButton\"]"))).click();
    }

    @Then("se muestra un mensaje de error indicando {string}")
    public void se_muestra_un_mensaje_de_error_indicando(String mensajeError) {
        // Espera hasta que el mensaje de error sea visible
        By locator = By.xpath("//*[contains(text(), '" + mensajeError + "')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Obtiene el texto del mensaje de error
        String mensajeObtenido = driver.findElement(locator).getText();
        System.out.println("Mensaje obtenido: " + mensajeObtenido); // Imprimir para depuración

        // Verifica si el mensaje obtenido es el esperado
        if (mensajeObtenido.trim().equals(mensajeError)) {
            System.out.println("Resultado: " + mensajeError + " visible correctamente");
        } else {
            System.out.println("Resultado: Mensaje esperado no encontrado");
        }

        // Espera un poco más para permitir que el mensaje sea visible antes de cerrar
        try {
            Thread.sleep(2000); // Espera 2 segundos (2000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



