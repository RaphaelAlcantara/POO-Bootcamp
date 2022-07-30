package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.Strategy.XP_interface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Mentoria extends Conteudo implements XP_interface {

    public Mentoria(String titulo, String descricao){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.data = LocalDate.now();
    }

    public Mentoria() {
    }


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


    @Override
    public double calcularXP() {
        return XP_PADRAO * 20d;
    }
}
