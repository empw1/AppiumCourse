package br.ce.riczera.appium.page.seuBarriga;

import br.ce.riczera.appium.core.BasePage;
import org.openqa.selenium.By;


public class SBLoginPage extends BasePage {

    public void setEmail(String email){
        escrever(By.className("android.widget.EditText"), email);
    }

    public void setSenha(String senha){
        escrever(By.xpath("//android.widget.EditText[2]"), senha);
    }

    public void entrar(){
        clicarPorTexto("ENTRAR");
    }
}
