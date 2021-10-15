package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe(){
        menu.acessarSwipe();

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        menu.swipeRight();

        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        menu.clicarPorTexto("›");

        Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        menu.swipeLeft();

        menu.clicarPorTexto("‹");

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
    }
}
