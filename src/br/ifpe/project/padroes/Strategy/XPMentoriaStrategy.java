package br.ifpe.project.padroes.Strategy;

import br.ifpe.project.model.negocios.Conteudo;

public class XPMentoriaStrategy extends Conteudo {

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }
}
