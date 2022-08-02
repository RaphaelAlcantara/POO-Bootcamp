package br.ifpe.project.padroes.Repository;

import java.util.List;
import java.util.ArrayList;

import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.padroes.Observer.Observador;

public class BootcampRepository {
    List<Bootcamp> bootcampList = new ArrayList<>();
    List<Dev> devs = new ArrayList<>();
    List<Observador> observadores = new ArrayList<>();

    public void create(Bootcamp bootcamp) {
        if (bootcamp != null) {
            bootcampList.add(bootcamp);
            notificarObservadores();


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


    public void adicionarObservador(Observador observador){
        if(!observadores.contains(observador)){
            observadores.add(observador);
        }
    }


    public void removerObservador(Observador observador){
        observadores.remove(observador);
    }

    public void notificarObservadores(){
        for(Observador ob : observadores){
            ob.enviarNotificacao(devs);
        }
    }

    public int obs(){
        return observadores.size();
    }
}