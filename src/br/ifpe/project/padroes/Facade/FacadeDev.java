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

public class FacadeDev {
    private DevRepository rDev = null;

    static private FacadeDev instanceFacadeDev;

    private FacadeDev() {
        this.rDev = new DevRepository();
    }
    public static FacadeDev getCurrentInstance(){
        if(instanceFacadeDev == null){
            synchronized (FacadeBootcamp.class){
                if(instanceFacadeDev == null){
                    instanceFacadeDev = new FacadeDev();
                }
            }

        }
        return instanceFacadeDev;
    }

    public void createDev(Dev d) {
        this.rDev.create(d);
    }

    public void mostrarInformacoesDev(Dev dev) {
        System.out.println("Conteudos inscritos de " + dev.getNome() + dev.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de " + dev.getNome() + dev.getConteudosConcluidos());
        System.out.println("Total de XP de " + dev.getNome() + ": " + dev.calcularTotalXP());
    }

    public void progredirDev(Dev dev) {
        dev.progredir();
    }
}
