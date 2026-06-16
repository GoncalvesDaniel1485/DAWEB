package com.daweb.sistema_aluno.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Aluno {

    @Id
    private int matricula;
    
    private String nome;
    private String cpf;
    private int idade;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Disciplina> disciplinas;

    public Aluno() {
        this.disciplinas = new ArrayList<>();
    }

    public Aluno(int matricula, String nome, String cpf, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.disciplinas = new ArrayList<>();
    }

    // --- Getters e Setters ---
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matrícula: " + matricula + " | Idade: " + idade;
    }
}