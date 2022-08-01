import br.ifpe.project.padroes.Facade.Facade;
import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Repository.BootcampRepository;

import java.sql.SQLOutput;
import java.util.Scanner;

//Criação de um bootcamp
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        Curso curso1 = new Curso("Curso Java", "Descrição do curso de Java", 8);
        facade.createCurso(curso1);

        Curso curso2 = new Curso("Curso Python", "Descrição do curso de Python", 12);
        facade.createCurso(curso2);

        Curso curso3 = new Curso("Curso Spring Framework", "Descrição do curso de Spring", 12);

        Mentoria mentoria1 = new Mentoria("Mentoria Java", "Descrição da mentoria de Java");
        facade.createMentoria(mentoria1);

        Mentoria mentoria2 = new Mentoria("Mentoria2", "Desc da Mentoria2");
        facade.createMentoria(mentoria2);

        // Criação de um bootcamp
        Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java developer", "Descrição do bootcamp de Java developer");
        facade.createBootcamp(bootcamp1);

        Bootcamp bootcamp2 = new Bootcamp("Spring Framework", "Descrição do Bootcamp de Spring");
        facade.createBootcamp(bootcamp2);


        // Criação de dev
        Dev Dev1 = new Dev("Rapha");
        facade.createDev(Dev1);

        // Adicionando conteudos
        facade.inserirConteudosNoBootcamp(bootcamp1, curso1, mentoria1);
        facade.inserirConteudosNoBootcamp(bootcamp1, curso2, mentoria2);

        facade.inscreverDevNoBootcamp(Dev1, bootcamp1);
        facade.adicionarObservador(Dev1);


        facade.progredirDev(Dev1);
        facade.mostrarInformacoesDev(Dev1);

        System.out.println("--------------------------------------------------------------------------------");

        //Criação do segundo DEV
        Dev dev2 = new Dev("Peu");
        facade.createDev(dev2);

        // Adicionando conteudos
        facade.inserirConteudosNoBootcamp(bootcamp2, curso1, mentoria1);
        facade.inserirConteudosNoBootcamp(bootcamp2, curso3, mentoria1);

        facade.inscreverDevNoBootcamp(dev2, bootcamp2);
        facade.adicionarObservador(dev2);


        facade.progredirDev(dev2);
        facade.progredirDev(dev2);
        facade.mostrarInformacoesDev(dev2);
        System.out.println("--------------------------------------------------------------------------------");


        System.out.println("---- Enviar Notificação ----");
        System.out.println("Notificação de " + Dev1.getNome());
        System.out.println("Notificação de " + dev2.getNome());
        facade.notificarObservadores();






























        /*
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



         */

        /*

        // Criar bootcamp, criar um dev, criar dois cursos, exibir dados do DEV.
        System.out.printf("\n%20s", "TESTE", "\n");
        Bootcamp btc1 = new Bootcamp("Bootcamp1", "Desc do Bootcamp 1");
        facade.createBootcamp(btc1);
        Mentoria mnt1 = new Mentoria("Mentoria1", "Desc da Mentoria1");
        facade.createMentoria(mnt1);
        Mentoria mnt2 = new Mentoria("Mentoria2", "Desc da Mentoria2");
        facade.createMentoria(mnt2);
        Dev dv1 = new Dev("Dev1");
        facade.createDev(dv1);
        Curso crs1 = new Curso("Curso1", "Desc do Curso1", 16);
        facade.createCurso(crs1);
        Curso crs2 = new Curso("Curso2", "Desc do Curso2", 8);
        facade.createCurso(crs2);

        // String nomeDev = facade.readDev("Dev1").getNome();
        // System.out.println(nomeDev);

        facade.inserirConteudosNoBootcamp(btc1, crs1, mnt1);
        facade.inserirConteudosNoBootcamp(btc1, crs2, mnt2);

        facade.inscreverDevNoBootcamp(dv1, btc1);

        facade.progredirDev(dv1);
        facade.progredirDev(dv1);
        facade.progredirDev(dv1);
        facade.progredirDev(dv1);

        facade.mostrarInformacoesDev(dv1);

        //Teste do observer
        System.out.println("TESTE DO OBSERVER");
        Bootcamp boot = new Bootcamp("Spring Framework", "Descrição do Bootcamp de Spring");
        facade.createBootcamp(boot);
        facade.adicionarObservador(dv1);
        facade.notificarObservadores();

         */

    }
}
