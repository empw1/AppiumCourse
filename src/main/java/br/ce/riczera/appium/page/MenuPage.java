package br.ce.riczera.appium.page;

import br.ce.riczera.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.riczera.appium.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlertas(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void clicarSwipeList(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Swipe List");
    }

    public void clicarDragNDrop(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSBNativo(){
        clicarPorTexto("SeuBarriga Nativo");
    }
}
