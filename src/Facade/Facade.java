package Facade;

import br.com.dio.desafio.dominio.*;

import java.util.Set;

public class Facade {

    private Bootcamp bootcamp;
    private Curso curso;
    private Mentoria mentoria;
    private Dev dev;

    public Facade(){
        this.bootcamp = new Bootcamp();
        this.curso = new Curso();
        this.mentoria = new Mentoria();
        this.dev = new Dev();
    }

    public Bootcamp criarBootcamp(Bootcamp bootcamp, String nome, String descricao ){
        this.bootcamp.setNome(nome);
        this.bootcamp.setDescricao(descricao);
        return bootcamp;

    }




    public void ConteudosBootcamp(Bootcamp bootcamp, Curso curso, Mentoria mentoria){
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
    }

    public Set<Conteudo> createDev(Dev dev, Set<Conteudo> conteudosInscritos){
        dev.setNome(dev.getNome());
        dev.setConteudosInscritos(dev.getConteudosInscritos());
        System.out.println("Conteudos inscritos de " + dev.getNome() + dev.getConteudosInscritos());
        return conteudosInscritos;
    }

    public Set<Conteudo> progressaoDev(Dev dev, Set<Conteudo> conteudosConcluidos){
        dev.progredir();
        System.out.println("Conteudos Concluidos de " + dev.getNome() + dev.getConteudosConcluidos());
        System.out.println("Total de XP de " + dev.getNome()+": " + dev.calcularTotalXP());
        return conteudosConcluidos;
    }

    @Override
    public String toString() {
        return "Facade{" +
                "bootcamp=" + bootcamp +
                ", curso=" + curso +
                ", mentoria=" + mentoria +
                ", dev=" + dev +
                '}';
    }
}
