package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.padroes.Repository.CursoRepository;

import java.util.List;

public class FacadeCurso {

    private CursoRepository rCurso = null;

    public FacadeCurso() {
        this.rCurso = new CursoRepository();
    }

    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

}
