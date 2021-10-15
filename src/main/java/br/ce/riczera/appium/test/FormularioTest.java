package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.core.DriverFactory;
import br.ce.riczera.appium.page.FormularioPage;
import br.ce.riczera.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FormularioTest extends BaseTest {


    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        menu.acessarFormulario();
    }

    @Test
    public void deveInteragirComCampoNome() throws MalformedURLException {
        page.escreverNome("Ricardo");

        assertEquals("Ricardo", page.obterNome());
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        page.selecionarCombo("Nintendo Switch");

        assertEquals("Nintendo Switch", page.obterValorCombo());
    }

    @Test
    public void deveInteragirSwitchECheckbox() throws MalformedURLException {
        Assert.assertFalse(page.isCheckMarcado());
        Assert.assertTrue(page.isSwitchMarcado());

        page.clicarCheck();
        page.clicarSwitch();

        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        page.escreverNome("Ricardo");
        page.clicarCheck();
        page.clicarSwitch();
        page.selecionarCombo("PS4");

        page.salvar();

        assertEquals("Nome: Ricardo", page.obterNomeCadastrado());
        assertEquals("Console: ps4", page.obterConsoleCadastrado());
        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));

    }

    @Test
    public void deveRealizarCadastroDermorado() throws MalformedURLException {
        page.escreverNome("Ricardo");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        page.salvarDemorado();

        esperar(3000);

        assertEquals("Nome: Ricardo", page.obterNomeCadastrado());
    }

    @Test
    public void deveAlterarData(){
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
    }

    @Test
    public void deveAlterarHora(){
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:40"));
    }

    @Test
    public void deveInteragirComSeekbar(){
        page.clicarSeekbar(0.67);

        page.salvar();
    }
}
