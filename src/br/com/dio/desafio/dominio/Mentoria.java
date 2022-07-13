package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Mentoria extends Conteudo {
    private LocalDate data;


    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d; //sempre que uma mentoria for criada o xp tem acrescimo de 20
    }
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
