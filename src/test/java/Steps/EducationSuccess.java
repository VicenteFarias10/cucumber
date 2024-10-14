package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EducationSuccess {
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

    @Given("que tengo acceso a la URL válida {string}")
    public void que_tengo_acceso_a_la_url_válida(String url){
        driver.get(url); // Accede a la URL proporcionada
    }

    @And("pongo el correo {string} en el campo de correo")
    public void pongo_el_correo_en_el_campo_de_correo(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(correo);
    }

    @And("pongo la contraseña {string} en el campo de contraseña")
    public void pongo_la_contraseña_en_el_campo_de_contraseña(String contraseña) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(contraseña);
    }

    @And("doy clic en el botón de aceptar")
    public void doy_clic_en_el_botón_de_aceptar() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginSubmitButton\"]"))).click();
    }

    @And("voy a ver un mensaje de confirmación que indica {string}")
    public void voy_a_ver_un_mensaje_de_confirmación_que_indica(String mensaje) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();
        if (mensajeObtenido.trim().equals(mensaje)) {
            System.out.println("Resultado: Inicio de sesión válido");
        } else {
            System.out.println("Resultado: Inicio de sesión no válido");
        }
        try {
            Thread.sleep(2000); // Espera 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("que navego a la url {string}")
    public void que_navego_a_la_url(String url) {
        driver.get(url);
    }

    @When("hago clic en el btn de educación")
    public void hago_clic_en_el_btn_de_educación() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[1]/a[4]"))).click(); // Adjust based on actual button
    }

    @And("ingreso la universidad {string}")
    public void ingreso_la_universidad(String universidad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"medicalSchool\"]"))).sendKeys(universidad);
    }

    @And("ingreso el año de graduación {string}")
    public void ingreso_el_año_de_graduación(String anioGraduacion) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"graduationYear\"]"))).sendKeys(anioGraduacion);
    }

    @And("selecciono la especialidad {string} de la lista")
    public void selecciono_la_especialidad_de_la_lista(String especialidad) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primarySpecialization\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + especialidad + "']"))).click();
    }

    @And("hago clic en el botón {string}")
    public void hago_clic_en_el_botón(String botonTexto) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"educationInfoSubmitButton\"]"))).click();
    }

    @Then("debería ver el mensaje de éxito {string}")
    public void debería_ver_el_mensaje_de_éxito(String mensajeExito) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='success-message']")));
        String mensajeObtenido = driver.findElement(By.xpath("//*[@class='success-message']")).getText();
        if (mensajeObtenido.trim().equals(mensajeExito)) {
            System.out.println("Resultado: Información educativa actualizada correctamente");
        } else {
            System.out.println("Resultado: Error al actualizar la información educativa");
        }
        try {
            Thread.sleep(2000); // Espera 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}