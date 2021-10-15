package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.MenuPage;
import br.ce.riczera.appium.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin(){
        menu.acessarSBHibrido();
        esperar(3000);
        page.entrarContextoWeb();
        page.setEmail("ricksilvatore@gmail.com");
        page.setSenha("hqbvcj6n");
        page.entrar();

        Assert.assertEquals("Bem vindo, Ricardo!", page.getMensagem());
    }

    @After
    public void tearDown(){
        page.sairContextoWeb();
    }
}
