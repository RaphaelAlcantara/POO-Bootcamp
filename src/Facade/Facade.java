package Facade;

import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import java.util.Set;

public class Facade {

    private Bootcamp bootcamp;
    private Curso curso;
    private Mentoria mentoria;
    private Dev dev;

    public Facade() {
        this.bootcamp = new Bootcamp();
        this.curso = new Curso();
        this.mentoria = new Mentoria();
        this.dev = new Dev();
    }

    public Dev createDev(Dev dev, String nome) {
        this.dev.setNome(nome);
        return dev;
    }

    public Bootcamp createBootcamp(Bootcamp bootcamp, String nome, String descricao) {
        this.bootcamp.setNome(nome);
        this.bootcamp.setDescricao(descricao);
        return bootcamp;

    }

    public Curso createCurso(Curso curso, String titulo, String descricao, int cargaHoraria) {
        this.curso.setTitulo(titulo);
        this.curso.setDescricao(descricao);
        this.curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    public Mentoria createMentoria(Mentoria mentoria, String titulo, String descricao) {
        this.mentoria.setTitulo(titulo);
        this.mentoria.setDescricao(descricao);
        this.mentoria.setData(LocalDate.now());
        return mentoria;
    }

    public void ConteudosBootcamp(Bootcamp bootcamp, Curso curso, Mentoria mentoria) {
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
    }

    public void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
    }

    /*
     * public Set<Conteudo> createDev(Dev dev, Set<Conteudo> conteudosInscritos) {
     * dev.setNome(dev.getNome());
     * dev.setConteudosInscritos(dev.getConteudosInscritos());
     * System.out.println("Conteudos inscritos de " + dev.getNome() +
     * dev.getConteudosInscritos());
     * return conteudosInscritos;
     * }
     */

    public void mostrarInformacoesDev(Dev dev) {
        System.out.println("Conteudos inscritos de " + dev.getNome() + dev.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de " + dev.getNome() + dev.getConteudosConcluidos());
        System.out.println("Total de XP de " + dev.getNome() + ": " + dev.calcularTotalXP());
    }

    public void progredirDev(Dev dev) {
        dev.progredir();
    }

    /*
     * public Set<Conteudo> progressaoDev(Dev dev, Set<Conteudo>
     * conteudosConcluidos) {
     * dev.progredir();
     * System.out.println("Conteudos Concluidos de " + dev.getNome() +
     * dev.getConteudosConcluidos());
     * System.out.println("Total de XP de " + dev.getNome() + ": " +
     * dev.calcularTotalXP());
     * return conteudosConcluidos;
     * }
     */

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
