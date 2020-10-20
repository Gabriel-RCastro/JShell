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
                UID += (char)r;
            }
            resultado.close();

            UID = UID.replaceAll("\n", "");
            return UID;
        } catch (IOException e) {
            System.out.println("Erro ao obter UID!");
            return "";
        }
    }
}