package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    protected WebDriver navegador;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null && System.getenv("CI").equals("true")) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        navegador = new ChromeDriver(options);
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @AfterEach
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}