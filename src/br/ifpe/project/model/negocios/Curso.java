package br.ifpe.project.model.negocios;

import br.ifpe.project.padroes.Strategy.XP_interface;

public class Curso extends Conteudo {
    public Curso(String titulo, String descricao, int cargaHoraria){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setCargaHoraria(cargaHoraria);
    }

    public Curso() {

    }

    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria; //sempre que um curso for criado o xp multiplicado por hr
    }

    private int cargaHoraria;
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: " +
                "titulo = " + getTitulo() +
                ", descricao = " + getDescricao() +
                ", cargaHoraria = " + cargaHoraria + "Hrs";
    }


}
