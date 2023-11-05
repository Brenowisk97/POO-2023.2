package Dao;

import entidades.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class alunoDao {
    private List<Aluno> alunos;
    private String arquivoDados;

    public alunoDao(String arquivoDados) {
        this.arquivoDados = arquivoDados;
        alunos = new ArrayList<>();
        carregarDados();
    }

//incluir aluno
    public void incluirAluno(Aluno aluno) {
        alunos.add(aluno);
        salvarDados();
    }

//remover aluno
    public void removerAluno(String matricula) {
        alunos.removeIf(aluno -> aluno.getMatricula().equals(matricula));
        salvarDados();
    }


    //atualizar curso
    public void atualizarCurso(String matricula, String novoCurso) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.setCurso(novoCurso);
                salvarDados();
                break;
            }
        }
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    private void carregarDados() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoDados))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    Aluno aluno = new Aluno(dados[0], dados[1], dados[2]);
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDados))) {
            for (Aluno aluno : alunos) {
                String linha = aluno.getNome() + "," + aluno.getCurso() + "," + aluno.getMatricula();
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}