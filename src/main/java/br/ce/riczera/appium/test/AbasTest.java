package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.AbasPage;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage page = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        menu.acessarAbas();
        Assert.assertTrue(page.isAba1());

        page.selecionarAba2();
        Assert.assertTrue(page.isAba2());
    }
}
