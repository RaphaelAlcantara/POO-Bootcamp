package br.ifpe.project.padroes.Strategy;

import br.ifpe.project.model.negocios.Conteudo;

public class XPCursoStrategy extends Conteudo {

    private static final double XPPADRAO = 10d;
    private int cargaHoraria;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXP() {
        return XPPADRAO * cargaHoraria;
    }
}
