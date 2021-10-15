package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.core.DriverFactory;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.riczera.appium.core.DriverFactory.getDriver;

public class OpcaoEscondidaTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menu.scrollDown();

        menu.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        menu.clicarPorTexto("OK");
    }
}
