package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Observer.Observador;
import br.ifpe.project.padroes.Repository.BootcampRepository;

import java.util.List;

public class FacadeBootcamp {
    private BootcampRepository rBootcamp = null;
    Bootcamp bootcamp = new Bootcamp();
    static private FacadeBootcamp instanceFacadeBootcamp;
    private FacadeBootcamp() {
        this.rBootcamp = new BootcampRepository();
    }

    //Lazy INITIALIZATION
    public static FacadeBootcamp getCurrentInstance(){
        if(instanceFacadeBootcamp == null){
            synchronized (FacadeBootcamp.class){
                if(instanceFacadeBootcamp == null){
                    instanceFacadeBootcamp = new FacadeBootcamp();
                }
            }

        }
        return instanceFacadeBootcamp;
    }


    public void createBootcamp(Bootcamp b) {
        this.rBootcamp.create(b);
    }

    public void inserirConteudosNoBootcamp(Bootcamp bootcamp, Curso curso, Mentoria mentoria) {
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
    }

    public void inscreverDevNoBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
    }


    public void adicionarObservador(Observador observador){
        this.rBootcamp.adicionarObservador(observador);
    }

    public void removerObservador(Observador observador){
        this.rBootcamp.removerObservador(observador);
    }

    public void notificarObservadores(){
        this.rBootcamp.notificarObservadores(bootcamp);
    }



}
