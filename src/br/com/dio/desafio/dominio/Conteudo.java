package br.com.dio.desafio.dominio;
//mentoria e curso são conteudos
//protected apenas os filhos podem acessar

import br.com.dio.desafio.dominio.Strategy.XP_interface;

public class Conteudo implements XP_interface{
    //ambas classes tem metodo calcular XP
    protected static double XP_PADRAO = 10d;

    //adicionar o que as classes tem em comum
    private String titulo;
    private String descricao;


    public Conteudo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double calcularXP(){
        return 0;
    }



    //Criar metodo para calcular XP e o abstract para que as classes filhas implementem obrigatoriamente
    //public abstract double calcularXP();
}

