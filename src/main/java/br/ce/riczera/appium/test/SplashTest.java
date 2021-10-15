package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.MenuPage;
import br.ce.riczera.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){
        menu.acessarSplash();

        page.isTelaSplashVisivel();

        page.aguardarSplashSumir();

        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }
}
