package br.ifpe.project.model.negocios;

import br.ifpe.project.padroes.Observer.Observador;

import java.util.*;

public class Dev implements Observador {


    public Dev() {
    }

    private String nome;

    public Dev(String nome) {
        this.nome = nome;
    }

    //utilizando o Set pois não tem repetição de valores
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>(); //LinkedHashSet para que os valores sejam ordenados pelo inserção
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    //Criação de metodos
    public Set<Conteudo> inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); //adiciona todos os conteudos do bootcamp ao dev
        bootcamp.getDevsInscritos().add(this); //adiciona o dev ao bootcamp
        return null;
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();//retorna o primeiro conteudo do dev
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get()); //adiciona o conteudo ao dev
            this.conteudosInscritos.remove(conteudo.get()); //remove o conteudo do dev
        }
        else {
            System.err.println("Você não está matriculado em nenhum conteudo!");//mensagem de erro
        }
    }

    public double calcularTotalXP(){
        //pega o total, converte e soma os conteudos concluidos
        return conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    //implemntar o equals e o hashCode para que o Set funcione corretamente

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }


    @Override
    public void enviarNotificacao(Bootcamp bootcamp) {
        System.out.println("==== Novo Bootcamp na plataforma ====");
        System.out.println("Inscreva-se agora no " + bootcamp.getNome() + "!!!");
    }
}
