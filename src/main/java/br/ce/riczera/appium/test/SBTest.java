package br.ce.riczera.appium.test;

import br.ce.riczera.appium.core.BaseTest;
import br.ce.riczera.appium.page.MenuPage;
import br.ce.riczera.appium.page.seuBarriga.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBContasPage contas = new SBContasPage();
    private SBMovimentacaoPage movimentacao = new SBMovimentacaoPage();
    private SBHomePage home = new SBHomePage();
    private SBResumoPage resumo = new SBResumoPage();

    @Before
    public void setup(){
        menu.acessarSBNativo();
        login.setEmail("rick@gmail.com");
        login.setSenha("hqbvcj6n");
        login.entrar();
    }

    @Test
    public void deveInserirContaComSucesso(){
        menuSB.acessarContas();
        contas.setConta("Conta de Teste");
        contas.salvar();

        Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirContaComSucesso(){
        menuSB.acessarContas();
        contas.selecionarConta("123");
        contas.excluir();

        Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void deveValidarInclusaoMov(){
        menuSB.acessarMovimentacoes();

        movimentacao.salvar();
        Assert.assertTrue(movimentacao.existeElementoPorTexto("Descrição é um campo obrigatório"));

        movimentacao.setDescricao("Desc");
        movimentacao.salvar();
        Assert.assertTrue(movimentacao.existeElementoPorTexto("Interessado é um campo obrigatório"));

        movimentacao.setInteressado("Interessado");
        movimentacao.salvar();
        Assert.assertTrue(movimentacao.existeElementoPorTexto("Valor é um campo obrigatório"));

        movimentacao.setValor("123");
        movimentacao.salvar();
        Assert.assertTrue(movimentacao.existeElementoPorTexto("Conta é um campo obrigatório"));

        movimentacao.setConta("Conta para alterar");
        movimentacao.salvar();
        Assert.assertTrue(movimentacao.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao(){
        Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

        menuSB.acessarResumo();

        resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
        Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));

        menuSB.acessarHome();

        esperar(1000);
        home.scroll(0.2, 0.9);

        Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
    }
}
