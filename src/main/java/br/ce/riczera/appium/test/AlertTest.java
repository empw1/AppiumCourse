package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.AlertaPage;
import br.ce.riczera.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Before
    public void setup(){
        menu.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta(){
        page.clicarAlertaConfirm();

        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        page.confirmar();

        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
        page.sair();
    }

    @Test
    public void deveClicarForaLAerta(){
        page.clicarAlertaSimples();

        esperar(1000);
        page.clicarForaCaixa();

        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
