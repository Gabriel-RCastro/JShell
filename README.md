# JShell – Interface de Linha de Comando

## 1 Introdução

Neste projeto, será implementado uma Interface de Linha de Comando (CLI) em Java, nos moldes do bash, tcsh, fish, zsh, cmd.exe, PowerShell, dentre tantos outros. Essa versão será mais simples, porém completamente funcional para atividades básicas como: verificar o relógio; manipular e navegar pelo sistema de arquivos; lançar novos processos rodando outros programas.

O objetivo é conhecer sobre as interfaces de programação (APIs) mais baixas de um sistema operacional, que são as chamadas de sistema. Especificamente, conhecer as principais chamadas oferecidas pela Java Virtual Machine (JVM), que possuem a vantagem de serem traduzidas para o sistema operacional hospedeiro sem precisarmos reprogramar ou recompilar o programa, enquanto provêm funcionalidade similar.

---
## 2 Ferramentas e Instruções

O programa será rodado a partir de um terminal com o seguinte comando: ```java -jar jshell.jar```.

---
## 3 Bibliografia

Para este trabalho, recomenda-se a utilização das seguintes fontes para pesquisa e aprendizado dos tópicos pertinentes:
1. ORACLE. Lesson: Basic I/O. The Java™Tutorial > Essential Classes. Disponível em: <https://docs.oracle.com/javase/tutorial/essential/io/>.

2. ORACLE. ProcessBuilder (Java SE 11 & JDK 11). Disponível em: <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/ProcessBuilder.html>.

3. TANENBAUM, Andrew S. Sistemas operacionais modernos. Rio de Janeiro: Prentice-Hall, 2010. 672 p. ISBN 9788576052371.

---
## 4 Exemplo de uso do JShell

A seguir, a transcrição de um exemplo de uso de um JShell totalmente implementado e
funcional, em um sistema com as seguintes características:

- Nome de login do usuário: professor
- PID deste usuário: 1001
- Data e hora do uso: 20/05/2014, às 14:45
- Atual diretório de trabalho:/home/professor/
- Arquivos deste diretório:
    - hobbit.txt
    - gabaritos.txt
    - Documentos
    - mesg_do_dia
    - mesg_do_dia.c
    - falha_arbitraria
    - falha_arbitraria.c
- mesg_do_dia é um programa que escreve “The only way around is through.” e retorna 0
- falha_arbitraria é um programa que escreve “Invalid arguments. Please, RTFM.” e
retorna 1 (erro!)

Transcrição do uso:
```
professor#1001:/home/professor/% relogio
Sao 14:45 de 20/05/2014.
professor#1001:/home/professor/% la
Documentos
falha_arbitraria
falha_arbitraria.c
gabaritos.txt
hobbit.txt
mesg_do_dia
mesg_do_dia.c
professor#1001:/home/professor/% cd Musicas
professor#1001:/home/professor/% cd Sandbox
professor#1001:/home/professor/% ad Musicas
professor#1001:/home/professor/% la
Documentos
falha_arbitraria
falha_arbitraria.c
gabaritos.txt
hobbit.txt
mesg_do_dia
mesg_do_dia.c
Sandbox
professor#1001:/home/professor/% mdt Sandbox
professor#1001:/home/professor/% la
professor#1001:/home/professor/Sandbox/% mdt /home/professor
professor#1001:/home/professor/% teste
Comando ou programa ’teste’ inexistente.
professor#1001:/home/professor/% hobbit.txt
Arquivo ’hobbit.txt’ não tem permissão para execução.
professor#1001:/home/professor/% mesg_do_dia
The only way around is through.
professor#1001:/home/professor/% falha_arbitraria
Invalid arguments. Please, RTFM.
ERRO: o programa indicou termino com falha!
professor#1001:/home/professor/% encerrar
```

---