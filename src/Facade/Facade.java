package Facade;

import br.com.Repository.CursoRepository;
import br.com.Repository.DevRepository;
import br.com.Repository.MentoriaRepository;
import br.com.Repository.BootcampRepository;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.List;

import java.util.Set;

public class Facade {

    /*
     * private Bootcamp bootcamp;
     * private Curso curso;
     * private Mentoria mentoria;
     * private Dev dev;
     */

    private BootcampRepository rBootcamp = null;
    private DevRepository rDev = null;
    private MentoriaRepository rMentoria = null;
    private CursoRepository rCurso = null;

    public Facade() {
        this.rBootcamp = new BootcampRepository();
        this.rDev = new DevRepository();
        this.rMentoria = new MentoriaRepository();
        this.rCurso = new CursoRepository();
    }

    // Métodos Facade Bootcamp

    public void createBootcamp(Bootcamp b) {
        this.rBootcamp.create(b);
    }

    public void updateBootcamp(Bootcamp b, String nome) {
        this.rBootcamp.update(b, nome);
    }

    public Bootcamp readBootcamp(String nome) {
        return this.rBootcamp.read(nome);
    }

    public void deleteBootcamp(String nome) {
        this.rBootcamp.delete(nome);
    }

    public List<Bootcamp> readAllBootcamp() {
        return this.rBootcamp.readAll();
    }

    // Métodos Facade Dev

    public void createDev(Dev d) {
        this.rDev.create(d);
    }

    public void updateDev(Dev d, String nome) {
        this.rDev.update(d, nome);
    }

    public Dev readDev(String nome) {
        return this.rDev.read(nome);
    }

    public void deleteDev(String nome) {
        this.rDev.delete(nome);
    }

    public List<Dev> readAllDev() {
        return this.rDev.readAll();
    }

    // Métodos Facade Mentoria

    public void createMentoria(Mentoria m) {
        this.rMentoria.create(m);
    }

    public void updateMentoria(Mentoria m, String nome) {
        this.rMentoria.update(m, nome);
    }

    public Mentoria readMentoria(String nome) {
        return this.rMentoria.read(nome);
    }

    public void deleteMentoria(String nome) {
        this.rMentoria.delete(nome);
    }

    public List<Mentoria> readAllMentoria() {
        return this.rMentoria.readAll();
    }

    // Métodos Facade Curso

    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

    public void updateCurso(Curso c, String nome) {
        this.rCurso.update(c, nome);
    }

    public Curso readCurso(String nome) {
        return this.rCurso.read(nome);
    }

    public void deleteCurso(String nome) {
        this.rCurso.delete(nome);
    }

    public List<Curso> readAllCurso() {
        return this.rCurso.readAll();
    }

    //

    /*
     * public Facade() {
     * this.bootcamp = new Bootcamp();
     * this.curso = new Curso();
     * this.mentoria = new Mentoria();
     * this.dev = new Dev();
     * }
     */

    public Dev createDev(Dev dev, String nome) {
        dev.setNome(nome);
        return dev;
    }

    public Bootcamp createBootcamp(Bootcamp bootcamp, String nome, String descricao) {
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        return bootcamp;

    }

    public Curso createCurso(Curso curso, String titulo, String descricao, int cargaHoraria) {
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    public Mentoria createMentoria(Mentoria mentoria, String titulo, String descricao) {
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.now());
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

    /*
     * @Override
     * public String toString() {
     * return "Facade{" +
     * "bootcamp=" + bootcamp +
     * ", curso=" + curso +
     * ", mentoria=" + mentoria +
     * ", dev=" + dev +
     * '}';
     * }
     */
}
