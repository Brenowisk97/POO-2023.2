import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

class Aluno {
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }
}

class AlunoCRUD {
    private ArrayList<Aluno> alunos;
    private Stack<String> matriculasRemovidas;

    public AlunoCRUD() {
        this.alunos = new ArrayList<>();
        this.matriculasRemovidas = new Stack<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(String matricula) {
        Iterator<Aluno> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getMatricula().equals(matricula)) {
                iterator.remove();
                matriculasRemovidas.push(matricula);
                return;
            }
        }
    }

    public void atualizarCurso(String matricula, String novoCurso) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.setCurso(novoCurso);
            }
        }
    }

    public void listarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Curso: " + aluno.getCurso());
                return;
            }
        }
        System.out.println("Aluno não encontrado para a matrícula: " + matricula);
    }

    public void listarTodosAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Curso: " + aluno.getCurso());
        }
    }

    public void recuperarUltimaRemocao() {
        if (!matriculasRemovidas.isEmpty()) {
            String matricula = matriculasRemovidas.pop();
            System.out.println("Recuperando aluno removido com a matrícula: " + matricula);
        } else {
            System.out.println("Nenhum aluno removido para recuperar.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        AlunoCRUD crud = new AlunoCRUD();

        // Adicionando alunos
        crud.adicionarAluno(new Aluno("Breno", "Ciencia de Dados", "202201"));
        crud.adicionarAluno(new Aluno("Victor", "Engenharia da Computação", "202202"));
        crud.adicionarAluno(new Aluno("Neymar", "Ciencia de Dados", "202203"));
        crud.adicionarAluno(new Aluno("Arlindo", "Direito", "202204"));
        crud.adicionarAluno(new Aluno("Péricles", "Engenharia", "202205"));
        crud.adicionarAluno(new Aluno("Thomas", "Medicina", "202206"));
        crud.adicionarAluno(new Aluno("Larissa", "Medicina", "202207"));
        crud.adicionarAluno(new Aluno("Bernardo", "Direito", "202208"));





        // Listando Alunos
        System.out.println("Lista alunos:");
        crud.listarTodosAlunos();

        // Atualizar curso do aluno
        crud.atualizarCurso("202201", "Agronomia");
        crud.atualizarCurso("202208", "Engenharia");


        // Listar informações de um aluno
        System.out.println("\nInformações do aluno com matrícula 202201:");
        crud.listarAluno("202201");

        // Remover aluno
        crud.removerAluno("202202");

        // Listar todos os alunos após a remoção
        System.out.println("\nLista de alunos após a remoção:");
        crud.listarTodosAlunos();

        // Recuperar última remoção
        crud.recuperarUltimaRemocao();

        // Listar todos os alunos após a recuperação
        System.out.println("\nLista de alunos após a recuperação:");
        crud.listarTodosAlunos();
    }
}