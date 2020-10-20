package br.unifil.dc.sisop;

/**ss
 * Write a description of class Jsh here.
 *
 * @author Gabriel Rodrigues de Castro
 * @version 1.0
 */
public final class Jsh {
    public static String nomeUsuario;
    public static String UID_usuario;
    public static String diretorioUsuario;
    public static String barraSistema;
    
    /**
    * Funcao principal do Jsh.
    */
    public static void promptTerminal() {

        while (true) {
    		exibirPrompt();
    		ComandoPrompt comandoEntrado = lerComando();
    		executarComando(comandoEntrado);
    	}
    }

    /**
    * Escreve o prompt na saida padrao para o usuário reconhecê-lo e saber que o
    * terminal está pronto para receber o próximo comando como entrada.
    */
    public static void exibirPrompt() {
        //Nome do usuario
        nomeUsuario = System.getProperty("user.name");

        //UID do usuario
        UID_usuario = MetodosAux.pegarUID();

        //Diretorio do usuario
        diretorioUsuario = System.getProperty("user.dir");
        
        //Barra do sistema
        barraSistema = System.getProperty("file.separator");

        System.err.print(nomeUsuario + "#" + UID_usuario + ":" + diretorioUsuario + barraSistema + "% ");
    }

    /**
    * Preenche as strings comando e parametros com a entrada do usuario do terminal.
    * A primeira palavra digitada eh sempre o nome do comando desejado. Quaisquer
    * outras palavras subsequentes sao parametros para o comando. A palavras sao
    * separadas pelo caractere de espaco ' '. A leitura de um comando eh feita ate
    * que o usuario pressione a tecla <ENTER>, ou seja, ate que seja lido o caractere
    * EOL (End Of Line).
    *
    * @return 
    */
    public static ComandoPrompt lerComando() {

        throw new RuntimeException("Método ainda não implementado.");
    }

    /**
    * Recebe o comando lido e os parametros, verifica se eh um comando interno e,
    * se for, o executa.
    * 
    * Se nao for, verifica se é o nome de um programa terceiro localizado no atual 
    * diretorio de trabalho. Se for, cria um novo processo e o executa. Enquanto
    * esse processo executa, o processo do uniterm deve permanecer em espera.
    *
    * Se nao for nenhuma das situacoes anteriores, exibe uma mensagem de comando ou
    * programa desconhecido.
    */
    public static void executarComando(ComandoPrompt comando) {
        throw new RuntimeException("Método ainda não implementado.");
    }

    public static int executarPrograma(ComandoPrompt comando) {
        throw new RuntimeException("Método ainda não implementado.");
    }
    
    
    /**
     * Entrada do programa. Provavelmente você não precisará modificar esse método.
     */
    public static void main(String[] args) {

        promptTerminal();
    }
    
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Jsh() {}
}
