package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.padroes.Repository.CursoRepository;


public class FacadeCurso {

    private CursoRepository rCurso = null;
    static  private FacadeCurso instanceFacadeCurso;

    public static FacadeCurso getCurrentInstance(){
        if(instanceFacadeCurso == null){
            synchronized (FacadeBootcamp.class){
                if(instanceFacadeCurso == null){
                    instanceFacadeCurso = new FacadeCurso();
                }
            }

        }
        return instanceFacadeCurso;
    }

    private FacadeCurso() {
        this.rCurso = new CursoRepository();
    }

    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

}
