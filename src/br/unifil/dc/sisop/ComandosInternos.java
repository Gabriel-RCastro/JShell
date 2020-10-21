package br.unifil.dc.sisop;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author Gabriel Rodrigues de Castro
 * @version 1.0
 */
public final class ComandosInternos {
    
    public static int exibirRelogio() {
        try {
            //Define os formatos de data e hora
            DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat formatoHora = new SimpleDateFormat("HH:mm");

            //Pega a data e a hora atual
            Date dataHoraAtual = new Date();

            //Cria strings de data e hora formatadas
            String data = formatoData.format(dataHoraAtual);
            String hora = formatoHora.format(dataHoraAtual);

            System.out.println("Sao " + hora + " de " + data + ".");
            return 1;
        } catch (Exception erro){
            System.out.println(erro.getMessage());
            return 1;
        }
    }
    
    public static int escreverListaArquivos(Optional<String> nomeDir) {
        //Cria um objeto File do diretorio atual
        File diretorio = new File(nomeDir.get());

        //Cria uma lista de Files dos arquivos do diretorio
        File[] listaArquivos = diretorio.listFiles();

        //Pega o nome dos arquivos da lista e mostra um em cada linha
        assert listaArquivos != null;
        for (File listaArquivo : listaArquivos) {
            System.out.println(listaArquivo.getName());
        }
        return 1;
    }
    
    public static int criarNovoDiretorio(String nomeDir) {
        String barraSistema = System.getProperty("file.separator");
        String diretorioAtual = System.getProperty("user.dir");
        String caminhoDiretorio = diretorioAtual + barraSistema + nomeDir;

        //Cria um novo diretorio no diretorio atual de trabalho com o nome especificado no argumento
        File diretorio = new File(caminhoDiretorio);
        diretorio.mkdir();

        System.out.println("Diretorio criado com sucesso!");
        return 1;
    }
    
    public static int apagarDiretorio(String nomeDir) {

        throw new RuntimeException("Método ainda não implementado");
    }
    
    public static int mudarDiretorioTrabalho(String nomeDir){
        throw new RuntimeException("Método ainda não implementado");
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
