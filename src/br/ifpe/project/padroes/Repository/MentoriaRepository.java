package br.ifpe.project.padroes.Repository;

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

}
