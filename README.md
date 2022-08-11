<h1> Projeto Padrão de Projeto: Bem vindo a plataforma de aprendizado de Programação</h1>


<h2> 📚 Regra de Negócio do Sistema: </h2>

<p>
O projeto consiste basicamente em um sistema que possui um bootcamp, 
este bootcamp possui alguns cursos e mentorias, cada curso tem também 
uma carga horária. Dentro do sistema também há a classe Dev, 
que corresponde ao aluno que se matricula em um bootcamp e estuda 
os cursos que tem dentro deste bootcamp. A cada curso concluído, 
o Dev progredi, contabilizando XP. 

O XP é calculado de forma distinta entre o curso e a Mentoria, cada um possui sua regra de negócio.

</p>

<h2> 💎 O que é um padrão de projeto? </h2>
<p>Padrão de projeto (português brasileiro) (do inglês design pattern) é uma solução geral para um 
problema que ocorre com frequência dentro de um determinado contexto no projeto de software. 
Um padrão de projeto não é um projeto finalizado que pode ser diretamente transformado em 
código fonte ou de máquina, ele é uma descrição ou modelo (template) de como resolver um 
problema que pode ser usado em muitas situações diferentes.</p>


<h2>🔺 Padrões de projeto Aplicados:</h2>

<h3>🔺 FACADE:</h3>

<p>
Fornece uma interface unificada para um conjunto de interfaces em um subsistema. Define uma interface de nível mais alto que torna o subsistema mais fácil de ser usado</p>
<h3>🔺 OBSERVER:</h3>

<p> Definir uma dependência um-para-muitos entre objetos, de maneira que quando um objeto muda de estado todos os seus dependentes são notificados e atualizados automaticamente.</p>

<h3>🔺 REPOSITORY:</h3>

<p>O padrão Repository separa a lógica de acesso a dados e mapeia essa lógica para entidades na lógica de negócio. Ele trabalha com as entidades de domínio e realiza a lógica de acesso a dados. </p>

<h3> 🔺 STRATEGY:</h3>

<p>Definir uma família de algoritmos, encapsular cada uma delas e torná-las intercambiáveis. Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.</p>
<br>


<h2 align="center"> APLICAÇÃO DOS PADRÕES NO CÓDIGO  ‼️ </h2>
<p>
<h3>🔻 REEPOSITORY: </h3> 
Conforme o desenvolvimento do sistema foi seguindo, a necessidade na construção de métodos foi aumentando cada vez mais e a classe de modelo dos objetos acabou comportando muitos métodos. Então para separar, foi feito o padrão de projeto REPOSITORIO. 

Construímos repositorios para cada modelo e dentro desses repositorios aplicamos os métodos referente a cada classe.
~~~
public class BootcampRepository{
    public void create(Bootcamp bootcamp) {
        if (bootcamp != null) {
        bootcampList.add(bootcamp);
        notificarObservadores();
        }
    }
}
~~~

<h3>🔻 FACADE:</h3> 
<p>Ao construir o grosso do sistema e executarmos a main, foi notado que a aplicação cliente (main) estava tendo 
acesso direto aos métodos referentes a cada objeto. Isso se tornou um problema, pois ao acessar diretamente 
um método, pode ocorrer da aplicação cliente acabar tendo acesso há método que não se refere a camada cliente 
e sim, a camada de controladores, por exemplo.
<br>
Portanto, iniciamos a construção do padrão de projeto FACHADA que consiste em saber externalizar apenas aquilo 
que você quer que o cliente tenha acesso, abstraindo as outras camadas. Dentro do FACADE chamamos os métodos 
de cada repositorio construído, externalizando apenas os métodos da camada cliente.

Foi construído uma fachada para cada modelo, e dentro dessa fachada foi chamado apenas os métodos referentes aquele modelo. 
Se aplicar uma única fachada para todos os modelos, acabamos tendo um outro problema de complexidade, visto que se tem 
a chamada de diversos métods, com assinaturas distintas e referências a objetos diferentes. 
~~~
    public class FacadeBootcamp {
    private BootcampRepository rBootcamp = null;

    public FacadeBootcamp() {
        this.rBootcamp = new BootcampRepository();
    }

 }
   public class FacadeCurso {

    private CursoRepository rCurso = null;

    public FacadeCurso() {
        this.rCurso = new CursoRepository();
    }
}

public class FacadeDev {
    private DevRepository rDev = null;

    public FacadeDev() {
        this.rDev = new DevRepository();
    }
    
 }
 
 public class FacadeMentoria {
    private MentoriaRepository rMentoria = null;

    public FacadeMentoria() {
        this.rMentoria = new MentoriaRepository();
    }


~~~

<h3>🔻 STRATEGY: </h3>

Nos objetos curso e mentoria, cada um tem uma implementação distinta. 
Portanto, foi criado uma interface geral que contém a assinatura desse método. 
Esta interface é implementada dentro da classe conteúdo e contém uma assinatura desse método, 
e para isolar de forma mais efetiva, criou-se uma classe para cada regra do XP. 
XPCursoStrategy contém a implementação do método referente a curso, e é implementada na classe modelo Curso.

A classe Curso necessita de uma implementação concreta do método na própria classe visto que este método é chamado na classe Dev

Já a classe Mentoria implementa a classe XPMentoriaStrategy. Nesta classe contém a implementação isolada do método que diz respeito somente a mentoria.
~~~
public interface XPStrategy {

    double XP_PADRAO = 10d;
    double calcularXP();
}


public  abstract  class Conteudo implements XPStrategy {

    //adicionar o que as classes tem em comum
    private String titulo;
    private String descricao;
    
 }
 
public class XPCursoStrategy extends Conteudo {
    
    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
}

public class XPMentoriaStrategy extends Conteudo {

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }
}

public class Curso extends XPCursoStrategy{

@Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria; //sempre que um curso for criado o xp multiplicado por hr
    }
    
}

public class Mentoria extends XPMentoriaStrategy {}


~~~

<h3>🔻 OBSERVER: </h3>
Para um sistema que possui Cursos, mentorias, bootcamps e Devs ficaria ainda melhor se a cada bootcamp criado, os devs cadastrados fossem notificados desse bootcamp. Portanto, foi criado o padrão de projeto Observer.
O Bootcamp, o objeto observado, e o Dev, o objeto observador, interagem entre si com uma ligação miníma.

Criou-se uma interface com o método para enviar a notificação e dentro dos repositorios implementou os métodos do padrão Observer.
Para externalizar esses métodos eles foram colocados dentro da classe FACADE. 


~~~
public interface Observador {

    void enviarNotificacao(List<Dev> dev);
}



public class Dev implements Observador{
     @Override
    public void enviarNotificacao(List<Dev> dev) {
        System.out.println("==== Novo Bootcamp na plataforma ====");
        System.out.println("Inscreva-se agora no bootcamp !!!");

    }

}



public class BootcampRepository {
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
}


public class Facade {
    public void adicionarObservador(Observador observador){
        this.rBootcamp.adicionarObservador(observador);
    }

    public void removerObservador(Observador observador){
        this.rBootcamp.removerObservador(observador);
    }

    public void notificarObservadores(){
        this.rBootcamp.notificarObservadores();
    }

}
~~~

</p>
    
------------
<br>

<h2> 🧮 COMO FICOU A APLICAÇÃO CLIENTE? (MAIN)</h2>

<p>
<h3> ✨ MAIN:</h3> 
Na main instanciou os objetos e chamou os métodos de forma mais indireta possível<br>
<br>

~~~

public class Main {
public static void main(String[] args) {
    FacadeDev facadeDev = new FacadeDev();
    FacadeBootcamp facadeBootcamp = new FacadeBootcamp();
    FacadeCurso facadeCurso = new FacadeCurso();
    FacadeMentoria facadeMentoria = new FacadeMentoria();

    Curso curso1 = new Curso("Curso Java", "Descrição do curso de Java", 8);
    facadeCurso.createCurso(curso1);
    
    Mentoria mentoria1 = new Mentoria("Mentoria Java", "Descrição da mentoria de Java");
    facadeMentoria.createMentoria(mentoria1);
    
    Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java developer", "Descrição do bootcamp de Java developer");
    facadeBootcamp.createBootcamp(bootcamp1);
    
     // Criação de dev
     Dev Dev1 = new Dev("Rapha");
     facadeDev.createDev(Dev1);

     // Adicionando conteudos
     facadeBootcamp.inserirConteudosNoBootcamp(bootcamp1, curso1, mentoria1);
     
     facadeBootcamp.inscreverDevNoBootcamp(Dev1, bootcamp1);
     facadeBootcamp.adicionarObservador(Dev1);


     facadeDev.progredirDev(Dev1);
     facadeDev.mostrarInformacoesDev(Dev1);
     
     System.out.println("---- Enviar Notificação ----");
     System.out.println("Notificação de " + Dev1.getNome());
    
     facadeBootcamp.notificarObservadores();
     
~~~


<h3> ✨ AUTORES</h3> 

<p>LILIAN BEATRIZ<br>
<br>
<strong>CURSANDO: ANÁLISE E DESENVOLVIMENTO DE SISTEMA</strong><br>

<p>JOSÉ ALFREDO<br>
<br>
<strong>CURSANDO: ANÁLISE E DESENVOLVIMENTO DE SISTEMA</strong><br>

<p>RAPHAEL ALCÂNTARA<br>
<br>
<strong>CURSANDO: ANÁLISE E DESENVOLVIMENTO DE SISTEMA</strong><br>

🔸 <strong>Sobre a  atividade: </strong><br>
Está atividade prática corresponde a disciplina de padrões de projeto do 4º período do curso de Análise e desenvolimento de sistemas<br>
<br>
🔸  - MENTOR: PAULO GONÇALVES <br>
🔸  - ANO: 2022 <br>
<br>
</p>

