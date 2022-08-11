package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Observer.Observador;
import br.ifpe.project.padroes.Repository.BootcampRepository;

public class FacadeBootcamp {
    private final BootcampRepository rBootcamp;

    private FacadeBootcamp() {
        this.rBootcamp = new BootcampRepository();
    }

    private static final class InstanceFacadeBootcampHolder {
        static private final FacadeBootcamp instanceFacadeBootcamp = new FacadeBootcamp();
    }

    //Lazy INITIALIZATION
    public static FacadeBootcamp getCurrentInstance(){
        return InstanceFacadeBootcampHolder.instanceFacadeBootcamp;
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


}
