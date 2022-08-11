import br.ifpe.project.padroes.Facade.FacadeBootcamp;
import br.ifpe.project.padroes.Facade.FacadeCurso;
import br.ifpe.project.padroes.Facade.FacadeDev;
import br.ifpe.project.model.negocios.Bootcamp;
import br.ifpe.project.model.negocios.Curso;
import br.ifpe.project.model.negocios.Dev;
import br.ifpe.project.model.negocios.Mentoria;
import br.ifpe.project.padroes.Facade.FacadeMentoria;


//Criação de um bootcamp
public class Main {
    public static void main(String[] args) {
        FacadeDev facadeDev = FacadeDev.getCurrentInstance();
        FacadeBootcamp facadeBootcamp = FacadeBootcamp.getCurrentInstance();
        FacadeCurso facadeCurso = FacadeCurso.getCurrentInstance();
        FacadeMentoria facadeMentoria = FacadeMentoria.getCurrentInstance();

        Curso curso1 = new Curso("Curso Java", "Descrição do curso de Java", 8);
        facadeCurso.createCurso(curso1);

        Curso curso2 = new Curso("Curso Python", "Descrição do curso de Python", 12);
        facadeCurso.createCurso(curso2);

        Curso curso3 = new Curso("Curso Spring Framework", "Descrição do curso de Spring", 12);

        Mentoria mentoria1 = new Mentoria("Mentoria Java", "Descrição da mentoria de Java");
        facadeMentoria.createMentoria(mentoria1);

        Mentoria mentoria2 = new Mentoria("Mentoria2", "Desc da Mentoria2");
        facadeMentoria.createMentoria(mentoria2);

        // Criação de um bootcamp
        Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java developer", "Descrição do bootcamp de Java developer");
        facadeBootcamp.createBootcamp(bootcamp1);

        Bootcamp bootcamp2 = new Bootcamp("Spring Framework", "Descrição do Bootcamp de Spring");
        facadeBootcamp.createBootcamp(bootcamp2);



        // Criação de dev
        Dev Dev1 = new Dev("Rapha");
        facadeDev.createDev(Dev1);

        // Adicionando conteudos
        facadeBootcamp.inserirConteudosNoBootcamp(bootcamp1, curso1, mentoria1);
        facadeBootcamp.inserirConteudosNoBootcamp(bootcamp1, curso2, mentoria2);

        facadeBootcamp.inscreverDevNoBootcamp(Dev1, bootcamp1);
        facadeBootcamp.adicionarObservador(Dev1);

        System.out.println("ÁREA DEV: " + Dev1.getNome());
        System.out.println();
        facadeDev.progredirDev(Dev1);
        facadeDev.mostrarInformacoesDev(Dev1);


        System.out.println("--------------------------------------------------------------------------------");

        //Criação do segundo DEV
        Dev dev2 = new Dev("Peu");
        facadeDev.createDev(dev2);

        // Adicionando conteudos
        facadeBootcamp.inserirConteudosNoBootcamp(bootcamp2, curso1, mentoria1);
        facadeBootcamp.inserirConteudosNoBootcamp(bootcamp2, curso3, mentoria1);

        facadeBootcamp.inscreverDevNoBootcamp(dev2, bootcamp2);


        facadeDev.progredirDev(dev2);
        facadeDev.progredirDev(dev2);

        System.out.println("AREA DEV: " + dev2.getNome());
        System.out.println();

        facadeDev.mostrarInformacoesDev(dev2);
        System.out.println("--------------------------------------------------------------------------------");


        System.out.println("Notificação do sistema: ");
        Bootcamp bootcamp3 = new Bootcamp("Python Developer", "Descrição do Bootcamp de Python");
        facadeBootcamp.createBootcamp(bootcamp3);
        //Sempre que crio um bootcamp, envio notificação para os observadores.
        // Dentro do método createBootcamp, contém o método "notificarObservadores"


    }
}
