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
    
    public static void exibirRelogio() {
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
        } catch (Exception erro){
            System.out.println(erro.getMessage());
        }
    }
    
    public static void escreverListaArquivos(Optional<String> nomeDir) {
        //Cria um objeto File do diretorio atual
        File diretorio = new File(nomeDir.get());

        //Cria uma lista de Files dos arquivos do diretorio
        File[] listaArquivos = diretorio.listFiles();
        
        //Pega o nome dos arquivos da lista e mostra um em cada linha
        for (int i = 0; i < Objects.requireNonNull(listaArquivos).length; i++){
            System.out.println(listaArquivos[i].getName()); 
        }
    }
    
    public static void criarNovoDiretorio(String nomeDir) {
        String barraSistema = System.getProperty("file.separator");
        String diretorioAtual = System.getProperty("user.dir");
        String caminhoDiretorio = diretorioAtual + barraSistema + nomeDir; 
        
        //Cria um novo diretorio no diretorio atual de trabalho com o nome especificado no argumento
        File diretorio = new File(caminhoDiretorio);
        diretorio.mkdir();

        System.out.println("Diretorio criado com sucesso!");
    }
    
    public static void apagarDiretorio(String nomeDir) {
        String barraSistema = System.getProperty("file.separator");
        String diretorioAtual = System.getProperty("user.dir");
        String caminhoDiretorio = diretorioAtual + barraSistema + nomeDir; 

        File diretorio = new File(caminhoDiretorio);

        //Verifica se esse argumento é um diretorio e se ele existe
        if((diretorio.exists()) && (diretorio.isDirectory())){
            //Se existir ele é deletado
             if (diretorio.delete()) {
                 System.out.println("Deletado com sucesso!");
             } else {
                //Apaga os subdiretorios e os arquivos do diretorio a ser excluído
                File[] listaArquivos = diretorio.listFiles();

                for (int i = 0; i < Objects.requireNonNull(listaArquivos).length; i++){
                    listaArquivos[i].delete(); 
                }
            }
        } else if (!diretorio.exists()) { 
            System.out.println("Diretorio inexistente!"); 
        } else if (!diretorio.isDirectory()) {
            System.out.println("Isso nao é um diretorio!");
        }
    }
    
    public static void mudarDiretorioTrabalho(String nomeDir){
        String barraSistema = System.getProperty("file.separator");
        String diretorioAtual = System.getProperty("user.dir");
        String caminhoDiretorio = diretorioAtual;

        //Verifica se o argumento é um diretorio/arquivo do diretorio atual ou um caminho especificado com '/'
        if(nomeDir.contains("/")) {
            caminhoDiretorio = nomeDir;
        } else{
            caminhoDiretorio = diretorioAtual + barraSistema + nomeDir;
        }

        File diretorio = new File(caminhoDiretorio);

        //Verifica se esse argumento é um diretorio e se ele existe
        if ((diretorio.exists()) && (diretorio.isDirectory())){
            System.setProperty("user.dir", caminhoDiretorio);
        } else if (!diretorio.exists()) { 
            System.out.println("Diretorio inexistente!"); 
        } else if (!diretorio.isDirectory()) {
            System.out.println("Isso nao é um diretorio!");
        }
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
