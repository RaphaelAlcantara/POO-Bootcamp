package br.ifpe.project.padroes.Repository;

import br.ifpe.project.model.negocios.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    List<Curso> cursoList = new ArrayList<>();

    public void create(Curso curso) {
        if (curso != null) {
            cursoList.add(curso);
        }
    }

}
