package br.unifil.dc.sisop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ComandosInternosTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void deveExibirHorarioAtualFormatadoDoSistema() {
        ComandosInternos.exibirRelogio();
        // assertEquals - Expected: deve ser substituído pelo horário atual do sistema para testar.
        assertEquals("Sao 20:03 de 16/11/2020.", outputStreamCaptor.toString().trim());
    }

    @Test
    void deveExibirListaDosArquivosQueEstaoNoDiretorioInformado() {
        ComandosInternos.escreverListaArquivos(java.util.Optional.of("./target/jsh-jar/teste"));
        // A quebra das linhas deve estar em formato CRLF ( \r\n ) para testar.
        assertEquals("falha_arbitraria\r\n" +
                "falha_arbitraria.c\r\n" +
                "gabaritos.txt\r\n" +
                "hobbit.txt\r\n" +
                "mesg_do_dia\r\n" +
                "mesg_do_dia.c", outputStreamCaptor.toString().trim());
    }
}