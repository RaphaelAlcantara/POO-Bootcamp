package br.ifpe.project.padroes.Observer;

import br.ifpe.project.model.negocios.Bootcamp;

public interface Observador {


    void enviarNotificacao(Bootcamp bootcamp);
}
