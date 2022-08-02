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
<p>Ao construir o grosso do sistema e executarmos a main, foi notado que a aplicação cliente (main) estava tendo acesso direto aos métodos referentes a cada objeto. Isso se tornou um problema, pois ao acessar diretamente um método, pode ocorrer da aplicação cliente acabar tendo acesso há método que não se refere a camada cliente e sim, a camada de controladores, por exemplo.
<br>
Portanto, iniciamos a construção do padrão de projeto FACHADA que consiste em saber externalizar apenas aquilo que você quer que o cliente tenha acesso, abstraindo as outras camadas.
Dentro do FACADE chamamos os métodos de cada repositorio construído, externalizando apenas os métodos da camada cliente.

~~~
    public class Facade {

    private BootcampRepository rBootcamp = null;
    private DevRepository rDev = null;
    private MentoriaRepository rMentoria = null;
    private CursoRepository rCurso = null;

    public Facade() {
        this.rBootcamp = new BootcampRepository();
        this.rDev = new DevRepository();
        this.rMentoria = new MentoriaRepository();
        this.rCurso = new CursoRepository();
    }

    public void createBootcamp(Bootcamp b) {
        this.rBootcamp.create(b);
    }
    
    public void createDev(Dev d) {
        this.rDev.create(d);
    }
    
    
    public void createMentoria(Mentoria m) {
        this.rMentoria.create(m);
    }
    
    public void createCurso(Curso c) {
        this.rCurso.create(c);
    }

~~~

<h3>🔻 STRATEGY: </h3>
Nos objetos curso e mentoria, cada um tem uma implementação distinta. Entretanto, as duas classes herdam de Conteúdo. Portanto, para diferenciar suas implementações, o metódo foi isolado e colocado dentro de uma interface. E essa interface foi implementada dentro da classe Conteúdo fazendo com que as classes principais, Curso e Mentoria, pudessem herdar esse método e cada uma definir sua regra para implementação

~~~
public interface XP_interface {

    public double calcularXP();
}

public class Conteudo implements XP_interface {
  
    protected static double XP_PADRAO = 10d;
    @Override
    public double calcularXP() {
        return 0;
    }
    
}

public class Curso extends Conteudo{
    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria; //sempre que um curso for criado o xp multiplicado por hr
    }
}

public class Mentoria extends Conteudo{
     @Override
    public double calcularXP() {
        return XP_PADRAO + 20d; //sempre que uma mentoria for criada o xp tem acrescimo de 20
    }
}
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
    Facade facade = new Facade();
    Curso curso1 = new Curso("Curso Java", "Descrição do curso de Java", 8);
    facade.createCurso(curso1);

    Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java developer", "Descrição do bootcamp de Java developer");
    facade.createBootcamp(bootcamp1);
    
     // Criação de dev
     Dev Dev1 = new Dev("Rapha");
     facade.createDev(Dev1);

     // Adicionando conteudos
     facade.inserirConteudosNoBootcamp(bootcamp1, curso1, mentoria1);
     
     facade.inscreverDevNoBootcamp(Dev1, bootcamp1);
     facade.adicionarObservador(Dev1);


     facade.progredirDev(Dev1);
     facade.mostrarInformacoesDev(Dev1);
     
     System.out.println("---- Enviar Notificação ----");
     System.out.println("Notificação de " + Dev1.getNome());
    
     facade.notificarObservadores();
     
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
Está atividade prática corresponde a disciplina de padrões de projeto do 4º período do curso de Análise e desenvolvimento de sistemas<br>
<br>
🔸  1.1 MENTOR: PAULO GONÇALVES <br>
🔸  1.2 ANO: 2022 <br>
<br>
</p>

