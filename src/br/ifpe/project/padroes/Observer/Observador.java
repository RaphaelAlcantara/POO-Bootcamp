package br.ifpe.project.padroes.Observer;

import br.ifpe.project.model.negocios.Dev;

import java.util.List;

public interface Observador {


    void enviarNotificacao(List<Dev> devs);
}
