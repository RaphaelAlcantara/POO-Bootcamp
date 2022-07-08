package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
    private String nome;
    //utilizando o Set pois não tem repetição de valores
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>(); //LinkedHashSet para que os valores sejam ordenados pelo inserção
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    //Criação de metodos

}
