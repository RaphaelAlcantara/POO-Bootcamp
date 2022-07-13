package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria; //sempre que um curso for criado o xp tem acrescimo de 40
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
