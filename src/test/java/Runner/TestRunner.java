package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"}, // Ruta que incluye todas las features
        glue = {"Steps"}, // Paquetes donde se encuentran los pasos y hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Opciones para el reporte
        monochrome = true, // Hace que la salida sea más legible en la consola
        tags = "@LoginFail, @LoginsSucces, @RegisterSucces, @BioDataFail, @BioDataSucces,@PageProfileFail"

)
public class TestRunner {
}
