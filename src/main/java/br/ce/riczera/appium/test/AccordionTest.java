package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.AccordionPage;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        menu.acessarAccordion();

        page.selecionarOpcao1();

        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
    }
}
