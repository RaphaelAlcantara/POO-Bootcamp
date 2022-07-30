package br.com.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import br.com.dio.desafio.dominio.Mentoria;

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
