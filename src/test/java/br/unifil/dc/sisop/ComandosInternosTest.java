package br.unifil.dc.sisop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");

        Date dataHoraAtual = new Date();

        String data = formatoData.format(dataHoraAtual);
        String hora = formatoHora.format(dataHoraAtual);

        ComandosInternos.exibirRelogio();

        assertEquals("Sao " + hora + " de " + data + ".", outputStreamCaptor.toString().trim());
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

    @Test
    void deveCriarNovoDiretorioComNomeInformado() {
        ComandosInternos.criarNovoDiretorio("diretorio-criado");

        ComandosInternos.escreverListaArquivos(java.util.Optional.of("./"));

        // A quebra das linhas deve estar em formato CRLF ( \r\n ) para testar.
        assertEquals(".git\r\n" +
                ".idea\r\n" +
                "diretorio-criado\r\n" +
                "JShell.iml\r\n" +
                "pom.xml\r\n" +
                "pom.xml.releaseBackup\r\n" +
                "README.md\r\n" +
                "release.properties\r\n" +
                "src\r\n" +
                "target", outputStreamCaptor.toString().trim());

        ComandosInternos.apagarDiretorio("diretorio-criado");
    }

    @Test
    void deveApagarDiretorioComNomeInformado() {
        ComandosInternos.criarNovoDiretorio("diretorio-apagar");

        ComandosInternos.apagarDiretorio("diretorio-apagar");

        ComandosInternos.escreverListaArquivos(java.util.Optional.of("./"));

        // A quebra das linhas deve estar em formato CRLF ( \r\n ) para testar.
        assertEquals(".git\r\n" +
                ".idea\r\n" +
                "JShell.iml\r\n" +
                "pom.xml\r\n" +
                "pom.xml.releaseBackup\r\n" +
                "README.md\r\n" +
                "release.properties\r\n" +
                "src\r\n" +
                "target", outputStreamCaptor.toString().trim());
    }

    @Test
    void deveMudarParaDiretorioDeTrabalhoInformado() {
        ComandosInternos.mudarDiretorioTrabalho("./target/jsh-jar/teste");

        assertEquals("./target/jsh-jar/teste", System.getProperty("user.dir"));
    }
}