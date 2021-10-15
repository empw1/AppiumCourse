package br.ce.riczera.appium.page.seuBarriga;

import br.ce.riczera.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static br.ce.riczera.appium.core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {

    public void excluirMovimentacao(String desc){
        MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
        swipeElement(el, 0.9, 0.1);
        clicarPorTexto("Del");
    }
}
