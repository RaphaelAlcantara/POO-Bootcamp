package br.ifpe.project.padroes.Facade;

import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Repository.MentoriaRepository;

import java.util.List;

public class FacadeMentoria {
    private MentoriaRepository rMentoria = null;

    public FacadeMentoria() {
        this.rMentoria = new MentoriaRepository();
    }

    public void createMentoria(Mentoria m) {
        this.rMentoria.create(m);
    }

}
