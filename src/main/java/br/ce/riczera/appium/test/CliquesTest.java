package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.CliquesPage;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setup(){
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        page.cliqueLongo();

        Assert.assertEquals("Clique Longo", page.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
    }
}
