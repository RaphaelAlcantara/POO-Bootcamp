package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Repository.MentoriaRepository;

public class FacadeMentoria {
    private final MentoriaRepository rMentoria;
    static private volatile FacadeMentoria instanceFacadeMentoria;

    private FacadeMentoria() {
        this.rMentoria = new MentoriaRepository();
    }

    public static FacadeMentoria getCurrentInstance(){
        if(instanceFacadeMentoria == null){
            synchronized (FacadeBootcamp.class){
                if(instanceFacadeMentoria == null){
                    instanceFacadeMentoria = new FacadeMentoria();
                }
            }

        }
        return instanceFacadeMentoria;
    }


    public void createMentoria(Mentoria m) {
        this.rMentoria.create(m);
    }

}
