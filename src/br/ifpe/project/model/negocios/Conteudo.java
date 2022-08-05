package br.ifpe.project.model.negocios;
//mentoria e curso são conteudos
//protected apenas os filhos podem acessar

import br.ifpe.project.padroes.Strategy.XPStrategy;

public  abstract  class Conteudo implements XPStrategy {

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



    //Criar metodo para calcular XP e o abstract para que as classes filhas implementem obrigatoriamente
    //public abstract double calcularXP();
}

