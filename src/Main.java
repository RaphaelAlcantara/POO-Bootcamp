import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

//Criação de um bootcamp
public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descriação do curso de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Descriação do curso de Python");
        curso2.setCargaHoraria(12);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao("Descriação da mentoria de Java");
        mentoria1.setData(LocalDate.now());





        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);


    }
}
