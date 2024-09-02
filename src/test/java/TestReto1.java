import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestReto1 {

    WebDriver navegador;

    @BeforeEach
    public void configurar() {

        navegador = new ChromeDriver();

        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        navegador.get("https://demoblaze.com/");

    }

    @Test
    public void buscarProductos() throws InterruptedException {

        WebElement botonCelulares = navegador.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[2]"));
        botonCelulares.click();
        WebElement enlaceSamsungGalaxyS6 = navegador.findElement(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a"));
        enlaceSamsungGalaxyS6.click();
        WebElement precioSamsung = navegador.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(precioSamsung.getText().toString().replace(" *includes tax", ""), "$360");

        navegador.navigate().back();

        WebElement enlaceNokiaLumia = navegador.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/div/h4/a"));
        enlaceNokiaLumia.click();
        WebElement precioNokia = navegador.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(precioNokia.getText().toString().replace(" *includes tax", ""), "$820");

        navegador.navigate().back();

        WebElement botonLaptops = navegador.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[3]"));
        botonLaptops.click();
        Thread.sleep(1000);
        WebElement enlaceLaptop1 = navegador.findElement(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a"));
        enlaceLaptop1.click();
        WebElement precioLaptop1 = navegador.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(precioLaptop1.getText().toString().replace(" *includes tax", ""), "$790");

        navegador.navigate().back();

        WebElement enlaceLaptop2 = navegador.findElement(By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a"));
        enlaceLaptop2.click();
        WebElement precioLaptop2 = navegador.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(precioLaptop2.getText().toString().replace(" *includes tax", ""), "$700");

        navegador.navigate().back();

        WebElement botonMonitores = navegador.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[4]"));
        botonMonitores.click();
        Thread.sleep(1000);
        WebElement enlaceMonitor1 = navegador.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/div/h4/a"));
        enlaceMonitor1.click();
        WebElement precioMonitor1 = navegador.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(precioMonitor1.getText().toString().replace(" *includes tax", ""), "$230");

    }

    @AfterEach
    public void cerrarNavegador() {
        navegador.close();
    }
}
