package com.daweb.sistema_aluno.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@Entity
public class Disciplina {

    @Id
    private int cod;
    
    private String nome;
    private String professor;
    private String curso;

    @ManyToMany(mappedBy = "disciplinas")
    @JsonIgnore
    private List<Aluno> alunos;

    public Disciplina() {
        this.alunos = new ArrayList<>();
    }

    public Disciplina(int cod, String nome, String professor, String curso) {
        this.cod = cod;
        this.nome = nome;
        this.professor = professor;
        this.curso = curso;
        this.alunos = new ArrayList<>();
    }

    // --- Getters e Setters ---
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + " | Código: " + cod + " | Professor: " + professor;
    }
}