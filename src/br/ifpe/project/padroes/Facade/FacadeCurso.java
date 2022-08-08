package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.padroes.Repository.CursoRepository;

import java.util.List;

public class FacadeCurso {

    private CursoRepository rCurso = null;

    // Implementação do Singleton no FacadeCurso
    public static FacadeCurso myself = null;

    public static FacadeCurso getCurrentInstance() {
        if (myself == null) {
            myself = new FacadeCurso();
        }
        return myself;
    }

    public FacadeCurso() {
        this.rCurso = new CursoRepository();
    }

    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

}
