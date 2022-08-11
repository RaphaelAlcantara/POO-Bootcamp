package br.ifpe.project.model.negocios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Mentoria extends Conteudo {

    public Mentoria(String titulo, String descricao){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.data = LocalDate.now();
    }

    public Mentoria() {}

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }

    private LocalDate data;

    public void setData(LocalDate data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "Mentoria: " +
                "titulo = " + getTitulo() +
                ", descricao =" + getDescricao() +
                ", data = " + getDataFormatada();
    }

    public String getDataFormatada() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR")));
    }

}
