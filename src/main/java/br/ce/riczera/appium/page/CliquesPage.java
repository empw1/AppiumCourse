package br.ce.riczera.appium.page;

import br.ce.riczera.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.riczera.appium.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    }

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
