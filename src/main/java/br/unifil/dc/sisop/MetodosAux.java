package br.unifil.dc.sisop;

import java.io.IOException;
import java.io.InputStream;

/**
 * Classe com métodos auxiliares utilizados no projeto.
 *
 * @author Gabriel Rodrigues de Castro
 * @version 1.0
 */
public class MetodosAux {

    /**
     * Método para pegar o UID do usuário
     * Executa um comando unix via shell.
     *
     * @return UID do usuário.
     */
    public static String pegarUID() {
        String UID = "";

        try {
            String comando = "id -u " + Jsh.nomeUsuario;
            Process executarComando = Runtime.getRuntime().exec(comando);

            InputStream resultado = executarComando.getInputStream();

            int r;
            while ((r = resultado.read()) != -1) {
                UID += (char) r;
            }
            resultado.close();

            UID = UID.replaceAll("\n", "");
            return UID;
        } catch (IOException e) {
            System.out.println("Erro ao obter UID!");
            return "";
        }
    }

    /**
     * Método para receber um comando e o executar via shell
     * Cria um processo, transforma a sua saida em uma string e a printa na tela.
     *
     * @param comando nome do programa que será executado.
     * @return código de saida do processo (normal é 0, diferente disso é considerado falha).
     */
    public static int executarProcesso(ComandoPrompt comando) {
        String barraSistema = System.getProperty("file.separator");
        String diretorioAtual = System.getProperty("user.dir");

        String caminhoRelativo = comando.getNome();
        String caminhoAbsoluto = diretorioAtual + barraSistema + caminhoRelativo;
        int saida = 0;

        ProcessBuilder construtor = new ProcessBuilder(caminhoAbsoluto);

        try {
            Process processo = construtor.start();
            saida = processo.waitFor();
            InputStream input = processo.getInputStream();

            byte[] byteSaida = input.readAllBytes();

            String stringSaida = new String(byteSaida);

            System.out.print(stringSaida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return saida;
    }
}