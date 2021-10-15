package br.ce.riczera.appium.page;

import br.ce.riczera.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import java.util.List;

import static br.ce.riczera.appium.core.DriverFactory.getDriver;

public class DragNDropPage extends BasePage {

    public void arrastar(String origem, String destino){
        MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction(getDriver()).longPress(inicio).moveTo(fim).release().perform();
    }

    public String[] obterLista(){
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for (int i=0; i < elements.size(); i++){
            retorno[i] = elements.get(i).getText();
        }
        return retorno;
    }
}
