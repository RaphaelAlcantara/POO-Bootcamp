package br.com.Repository;

import java.util.List;
import java.util.ArrayList;

import br.com.dio.desafio.dominio.Bootcamp;

public class BootcampRepository {
    List<Bootcamp> bootcampList = new ArrayList<>();

    public void create(Bootcamp bootcamp) {
        if (bootcamp != null) {
            bootcampList.add(bootcamp);
            System.out.println("Bootcamp Criado!");
        }
    }

    public void update(Bootcamp btc, String nome) {
        for (Bootcamp b : bootcampList) {
            if (b.getNome().equals(nome)) {
                b.setNome(btc.getNome());
                b.setDescricao(btc.getDescricao());
            }
        }
    }

    public Bootcamp read(String nome) {
        for (Bootcamp b : bootcampList) {
            if (b.getNome().equals(nome)) {
                return b;
            }
        }
        return null;
    }

    public List<Bootcamp> readAll() {
        List<Bootcamp> btcList = new ArrayList<>();
        for (Bootcamp b : bootcampList) {
            btcList.add(b);
        }
        return btcList;
    }

    public void delete(String nome) {
        for (Bootcamp b : bootcampList) {
            if (b.getNome().equals(nome)) {
                bootcampList.remove(bootcampList.indexOf(b));
            }
        }
    }
}