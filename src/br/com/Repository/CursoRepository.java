package br.com.Repository;

import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    List<Curso> cursoList = new ArrayList<>();

    public void create(Curso curso) {
        if (curso != null) {
            cursoList.add(curso);
        }
    }

    public void update(Curso curso, String titulo) {
        for (Curso c : cursoList) {
            if (c.getTitulo().equals(titulo)) {
                c.setTitulo(curso.getTitulo());
                c.setDescricao(curso.getDescricao());
                c.setCargaHoraria(curso.getCargaHoraria());
            }
        }
    }

    public Curso read(String titulo) {
        for (Curso c : cursoList) {
            if (c.getTitulo().equals(titulo)) {
                return c;
            }
        }
        return null;
    }

    public List<Curso> readAll() {
        List<Curso> crList = new ArrayList<>();
        for (Curso c : cursoList) {
            crList.add(c);
        }
        return crList;
    }

    public void delete(String titulo) {
        for (Curso c : cursoList) {
            if (c.getTitulo().equals(titulo)) {
                cursoList.remove(cursoList.indexOf(c));
            }
        }
    }
}
