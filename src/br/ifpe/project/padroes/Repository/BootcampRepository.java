package br.ifpe.project.padroes.Repository;

import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.padroes.Observer.Observador;

import java.util.ArrayList;
import java.util.List;

public class BootcampRepository {
    List<Bootcamp> bootcampList = new ArrayList<>();
    List<Observador> observadores = new ArrayList<>();

    public void create(Bootcamp bootcamp) {
        if (bootcamp != null) {
            bootcampList.add(bootcamp);
            notificarObservadores(bootcamp);


        }
    }


    public void adicionarObservador(Observador observador){
        if(!observadores.contains(observador)){
            observadores.add(observador);
        }
    }


    public void notificarObservadores(Bootcamp bootcamp){
        for(Observador ob : observadores){
            ob.enviarNotificacao(bootcamp);
        }
    }

}