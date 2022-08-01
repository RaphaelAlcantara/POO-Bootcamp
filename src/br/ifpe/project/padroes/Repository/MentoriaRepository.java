package br.ifpe.project.padroes.Repository;

import java.time.LocalDate;

import br.ifpe.project.model.negocios.Mentoria;
import java.util.ArrayList;
import java.util.List;

public class MentoriaRepository {
    List<Mentoria> mentoriaList = new ArrayList<>();

    public void create(Mentoria mentoria) {
        if (mentoria != null) {
            mentoriaList.add(mentoria);
        }
    }

    public void update(Mentoria mentoria, String titulo) {
        for (Mentoria m : mentoriaList) {
            if (m.getTitulo().equals(titulo)) {
                m.setTitulo(mentoria.getTitulo());
                m.setDescricao(mentoria.getDescricao());
                m.setData(LocalDate.now());
            }
        }
    }

    public Mentoria read(String titulo) {
        for (Mentoria m : mentoriaList) {
            if (m.getTitulo().equals(titulo)) {
                return m;
            }
        }
        return null;
    }

    public List<Mentoria> readAll() {
        List<Mentoria> mntList = new ArrayList<>();
        for (Mentoria m : mentoriaList) {
            mntList.add(m);
        }
        return mntList;
    }

    public void delete(String titulo) {
        for (Mentoria m : mentoriaList) {
            if (m.getTitulo().equals(titulo)) {
                mentoriaList.remove(mentoriaList.indexOf(m));
            }
        }
    }

}
