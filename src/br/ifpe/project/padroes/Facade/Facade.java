package br.ifpe.project.padroes.Facade;

import br.ifpe.project.padroes.Observer.Observador;
import br.ifpe.project.padroes.Repository.CursoRepository;
import br.ifpe.project.padroes.Repository.DevRepository;
import br.ifpe.project.padroes.Repository.MentoriaRepository;
import br.ifpe.project.padroes.Repository.BootcampRepository;
import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.model.negocios.Mentoria;

import java.util.List;

public class Facade {

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

    // Métodos br.ifpe.project.padroes.Repository.Facade Bootcamp

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

    // Métodos br.ifpe.project.padroes.Repository.Facade Dev

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

    // Métodos br.ifpe.project.padroes.Repository.Facade Mentoria

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

    // Métodos br.ifpe.project.padroes.Repository.Facade Curso

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

    // Fim dos br.ifpe.project.padroes.Repository.Facade

    public void inserirConteudosNoBootcamp(Bootcamp bootcamp, Curso curso, Mentoria mentoria) {
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
    }

    public void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
    }

    public void mostrarInformacoesDev(Dev dev) {
        System.out.println("Conteudos inscritos de " + dev.getNome() + dev.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de " + dev.getNome() + dev.getConteudosConcluidos());
        System.out.println("Total de XP de " + dev.getNome() + ": " + dev.calcularTotalXP());
    }

    public void progredirDev(Dev dev) {
        dev.progredir();
    }


    public void adicionarObservador(Observador observador){
        this.rBootcamp.adicionarObservador(observador);
    }

    public void removerObservador(Observador observador){
        this.rBootcamp.removerObservador(observador);
    }

    public void notificarObservadores(){
        this.rBootcamp.notificarObservadores();
    }

    /*
     * @Override
     * public String toString() {
     * return "br.ifpe.project.padroes.Repository.Facade{" +
     * "bootcamp=" + bootcamp +
     * ", curso=" + curso +
     * ", mentoria=" + mentoria +
     * ", dev=" + dev +
     * '}';
     * }
     */
}
