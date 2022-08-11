package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.padroes.Repository.CursoRepository;


public class FacadeCurso {

    private final CursoRepository rCurso;

    private static final class InstanceFacadeCursoHolder {
        static private final FacadeCurso instanceFacadeCurso = new FacadeCurso();
    }

    public static FacadeCurso getCurrentInstance(){
        return InstanceFacadeCursoHolder.instanceFacadeCurso;
    }

    private FacadeCurso() {
        this.rCurso = new CursoRepository();
    }

    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

}
