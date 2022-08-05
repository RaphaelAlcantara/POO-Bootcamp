package br.ifpe.project.model.negocios;

import br.ifpe.project.padroes.Strategy.XPMentoriaStrategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Mentoria extends XPMentoriaStrategy {

    public Mentoria(String titulo, String descricao){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.data = LocalDate.now();
    }

    public Mentoria() {}

    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

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
