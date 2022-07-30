package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.Strategy.XP_interface;

public class Curso extends Conteudo implements XP_interface {
    public Curso(String titulo, String descricao, int cargaHoraria){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setCargaHoraria(cargaHoraria);
    }

    public Curso() {

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


    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
}
