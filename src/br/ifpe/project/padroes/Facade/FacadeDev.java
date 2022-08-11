package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.padroes.Repository.DevRepository;

public class FacadeDev {
    private final DevRepository rDev;

    static private volatile FacadeDev instanceFacadeDev;

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
