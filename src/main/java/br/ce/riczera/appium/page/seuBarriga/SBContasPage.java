package br.ce.riczera.appium.page.seuBarriga;

import br.ce.riczera.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBContasPage extends BasePage {

    public void setConta(String nome){
        escrever(By.className("android.widget.EditText"), nome);
    }

    public void salvar(){
        clicarPorTexto("SALVAR");
    }

    public void excluir(){
        clicarPorTexto("EXCLUIR");
    }

    public void selecionarConta(String conta){
        cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }
}
