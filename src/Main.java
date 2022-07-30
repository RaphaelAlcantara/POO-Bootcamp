import Facade.Facade;
import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.Set;

//Criação de um bootcamp
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        Curso curso1 = new Curso("Curso Java", "Descrição do curso de Java", 8);

        Curso curso2 = new Curso("Curso Python", "Descrição do curso de Python", 12);

        Mentoria mentoria1 = new Mentoria("Mentoria Java", "Descrição da mentoria de Java");

        // Criação de um bootcamp
        Bootcamp bootcamp = new Bootcamp("Bootcamp Java developer", "Descrição do bootcamp de Java developer");

        // Criação de dev
        Dev Dev1 = new Dev();

        // Adicionando conteudos

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev1.setNome("Rapha");
        Dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos de " + Dev1.getNome() + Dev1.getConteudosInscritos());

        Dev1.progredir();

        System.out.println("Conteudos inscritos de " + Dev1.getNome() + Dev1.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de " + Dev1.getNome() + Dev1.getConteudosConcluidos());
        System.out.println("Total de XP de " + Dev1.getNome() + ": " + Dev1.calcularTotalXP());

        Dev Dev2 = new Dev();
        Dev2.setNome("Peu");
        Dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos de " + Dev2.getNome() + Dev2.getConteudosInscritos());

        Dev2.progredir();
        Dev2.progredir();
        System.out.println("Conteudos inscritos de " + Dev2.getNome() + Dev2.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de " + Dev2.getNome() + Dev2.getConteudosConcluidos());
        System.out.println("Total de XP de " + Dev2.getNome() + ": " + Dev2.calcularTotalXP());

        // Teste.
        System.out.printf("\n", "Teste logo após", "\n");

        Bootcamp bootcamp1 = null;
        facade.createBootcamp(bootcamp1, "Bootcamp Java developer", "Descrição do bootcamp de Java developer");
        Mentoria mentoria = null;
        facade.createMentoria(mentoria, "Mentoria Java", "Descrição da mentoria de Java");
        Dev dev = null;
        facade.createDev(dev, "Peu");
        Curso curso3 = null, curso4 = null;
        facade.createCurso(curso3, "Curso Java", "Descrição do curso de Java", 8);
        facade.createCurso(curso4, "Curso Python", "Descrição do curso de Python", 12);
        facade.inscreverDevNoBootcamp(dev, bootcamp1);
        facade.progredirDev(dev);
        facade.mostrarInformacoesDev(dev);

    }
}
